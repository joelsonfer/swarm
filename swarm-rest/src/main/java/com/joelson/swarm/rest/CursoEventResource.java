package com.joelson.swarm.rest;

import com.joelson.swarm.model.entity.CursoEvent;
import com.joelson.swarm.model.entity.QCursoEvent;
import com.joelson.swarm.model.repository.BasicRepository;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;


@ApplicationScoped
@Path("eventos-cursos")
@Produces("application/json")
@Consumes("application/json")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CursoEventResource {

    @Inject
    private BasicRepository service;

    @GET
    public Response findAll() {
        List<CursoEvent> all = service.findAll(QCursoEvent.cursoEvent);
        return Response.ok(all).build();
    }


}
