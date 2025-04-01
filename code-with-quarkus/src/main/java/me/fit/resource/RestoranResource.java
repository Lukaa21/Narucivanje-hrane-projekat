package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Restoran;
import me.fit.repository.RestoranRepository;
import java.util.List;

@Path("/restoran/")
public class RestoranResource {
    @Inject
    RestoranRepository restoranRepo;

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
}