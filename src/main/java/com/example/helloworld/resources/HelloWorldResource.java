package com.example.helloworld.resources;

import com.example.helloworld.api.Saying;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
     HelloWorldService msv=new HelloWorldService();

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = msv.counter;
    }
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Timed

    public  List<Saying> sayHello() {
        return msv.getHellos();
    }

    @Path("/PostHello")
    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response  GetPost(@Context HttpHeaders httpHeaders, Saying say){
          msv.addhello(say);
        return Response.ok().build();

    }
}