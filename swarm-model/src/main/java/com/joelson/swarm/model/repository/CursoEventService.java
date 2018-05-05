package com.joelson.swarm.model.repository;

import com.joelson.swarm.model.enterprise.EntitySaved;
import com.joelson.swarm.model.enterprise.UserHolder;
import com.joelson.swarm.model.entity.Curso;
import com.joelson.swarm.model.entity.CursoEvent;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Stateless
public class CursoEventService {

    private final Logger LOGGER = Logger.getLogger(CursoEventService.class);

    @Inject
    private BasicRepository repository;

    @Inject
    private UserHolder userHolder;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void teste(@Observes(during = TransactionPhase.AFTER_SUCCESS) @EntitySaved Curso curso) {
        CursoEvent build = CursoEvent.builder()
                .descricao(curso.getDescricao())
                .horario(LocalDateTime.now())
                .user(userHolder.getUser())
                .build();
        LOGGER.info("Eittaaa " + curso.getId());
        repository.save(build);
    }
}
