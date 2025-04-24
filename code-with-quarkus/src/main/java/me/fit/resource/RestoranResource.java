package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import me.fit.model.client.TimeResponse;
import me.fit.restclient.TimeClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import jakarta.ws.rs.core.MediaType;
import me.fit.exception.RestoranException;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import me.fit.model.Restoran;
import me.fit.repository.RestoranRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/restoran/")
public class RestoranResource {
    @Inject
    RestoranRepository restoranRepo;

    @RestClient
    TimeClient timeClient;

    @ConfigProperty(name = "greeting.message")
    String message;


    @Path("/getAll/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRestorani(){
        List<Restoran> restorani = restoranRepo.getAllRestorani();
        return Response.ok().entity(restorani).build();
    }

    @Path("/create/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRestoran(Restoran restoran){
        Restoran r = restoranRepo.createRestoran(restoran);
        return Response.ok().entity(r).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllByName")
    public Response getRestoraniByName(@QueryParam(value="naziv") String naziv){
        List<Restoran> restorani;
        try {
            restorani = restoranRepo.getRestoraniByName(naziv);
        } catch (RestoranException e) {
            return Response.ok().entity(e.getMessage()).build();
        }
        return Response.ok().entity(restorani).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTime")
    public Response getTime(@QueryParam(value = "timeZone") String timeZone) {

        TimeResponse time = timeClient.getTime(timeZone);

        return Response.ok().entity(time).build();
    }
}