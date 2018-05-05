package com.joelson.swarm.model.repository;

import com.joelson.swarm.model.enterprise.EntitySaved;
import com.joelson.swarm.model.enterprise.IEntity;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class BasicRepository {

    @Inject
    private EntityManager entityManager;

    @Inject
    @EntitySaved
    private Event<Object> event;

    public <T extends IEntity> T save(T entity) {
        if (entity.getId() != null) {
            return merge(entity);
        }
        persist(entity);
        return entity;
    }

    private <T> T merge(T entity) {
        T merged = entityManager.merge(entity);
        event.fire(entity);
        return merged;
    }

    private <T> void persist(T entity) {
        entityManager.persist(entity);
        event.fire(entity);
    }

    public <T> List<T> findAll(EntityPath<T> path) {
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        return jpaQuery.from(path)
                .list(path);
    }

    public <T> void delete(Class<T> entityClass, Long id) {
        T entity = entityManager.find(entityClass, id);
        entityManager.remove(entity);
    }
}
