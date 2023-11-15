package com.eurder.customers;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

@Path("customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Valid Customer customer) {

        return Response.status(Response.Status.CREATED)
                .entity(customerService.register(customer))
                .build();

    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(customerService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@RestPath("id") Long id) {

        return Response.ok(customerService.get(id)).build();
    }
}
