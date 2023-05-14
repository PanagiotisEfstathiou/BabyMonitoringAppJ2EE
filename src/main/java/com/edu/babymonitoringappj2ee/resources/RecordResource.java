package com.edu.babymonitoringappj2ee.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/record")
public class RecordResource {
    @GET
    @Path("/ping")
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}
