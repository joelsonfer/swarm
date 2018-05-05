package com.joelson.swarm.rest;

import com.joelson.swarm.model.entity.Curso;
import com.joelson.swarm.model.entity.QCurso;
import com.joelson.swarm.model.repository.BasicRepository;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("cursos")
@Produces("application/json")
@Consumes("application/json")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CursoResource {

    @Inject
    private BasicRepository service;

    @GET
    public Response findAll() {
        List<Curso> all = service.findAll(QCurso.curso);
        return Response.ok(all).build();
    }

    @POST
    @Transactional
    public Response post(Curso curso) {
        Curso save = service.save(curso);
        return Response.ok(save).build();
    }

    @PUT
    @Transactional
    public Response put(Curso curso) {
        Curso save = service.save(curso);
        return Response.ok(save).build();
    }

    @DELETE
    @Transactional
    public Response delete(Long id) {
        service.delete(Curso.class, id);
        return Response.noContent().build();
    }

}
