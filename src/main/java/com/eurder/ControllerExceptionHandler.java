package com.eurder;

import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.postgresql.util.PSQLException;

import java.util.NoSuchElementException;

import static jakarta.ws.rs.core.Response.Status.*;

public class ControllerExceptionHandler {
    private static final Logger LOG = Logger.getLogger(ControllerExceptionHandler.class);

    @ServerExceptionMapper(value = {NotFoundException.class, NoSuchElementException.class})
    public Response handleNotFound(RuntimeException exception) {

        LOG.error(exception.getMessage());
        return Response.status(NOT_FOUND).entity(exception.getMessage()).build();
    }

    @ServerExceptionMapper(value ={IllegalArgumentException.class, ConstraintViolationException.class})
    public Response handleBadRequest(RuntimeException exception) {

        LOG.error(exception.getMessage());
        return Response.status(BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
