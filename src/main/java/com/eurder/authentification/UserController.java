package com.eurder.authentification;

import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.Response.Status.CREATED;

@Path("/admins")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    public Response registerAdmin(@Valid User user) {
        return Response.status(CREATED).entity(userService.registerAdmin(user)).build();
    }
}
