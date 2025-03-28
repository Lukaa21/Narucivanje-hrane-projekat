package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Dostavljac;
import me.fit.repository.DostavljacRepository;
import java.util.List;

@Path("/dostavljac/")
public class DostavljacResource {
    @Inject
    DostavljacRepository dostavljacRepo;

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDostavljac(Dostavljac dostavljac){
        Dostavljac d = dostavljacRepo.createDostavljac(dostavljac);
        return Response.ok().entity(d).build();
    }

    @GET
    @Path("/getAll/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDostavljaci(){
        List<Dostavljac> dostavljaci = dostavljacRepo.getAllDostavljaci();
        return Response.ok().entity(dostavljaci).build();
    }
}
