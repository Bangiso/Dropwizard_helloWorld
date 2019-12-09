package com.example.helloworld.resources;

import com.example.helloworld.api.Saying;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hello-world")
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    HelloWorldService msv;


    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.msv=new HelloWorldService(template);

    }



    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)

    public  List<Saying> sayHello() {
        return msv.getHellos();
    }


    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response  postPost(@Context HttpHeaders httpHeaders, Saying say){
          msv.addhello(say);
        return Response.ok().build();

    }

    @DELETE
    @Path("/{id}")

    public Response  deletePost(@PathParam("id") int id, Saying say){
        msv.deleleHello(id);
        return Response.ok().build(); }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response  putPost(@PathParam("id") int id, Saying say){
        msv.putHello(id,say);
        return Response.ok().build();

    }




}