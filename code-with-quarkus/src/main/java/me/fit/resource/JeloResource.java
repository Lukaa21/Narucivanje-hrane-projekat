package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Jelo;
import me.fit.repository.JeloRepository;
import java.util.List;

@Path("/jelo/")
public class JeloResource {
    @Inject
    JeloRepository jeloRepo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create/")
    public Response createJelo(Jelo jelo) {
        Jelo j = jeloRepo.createJelo(jelo);
        return Response.ok().entity(j).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll/")
    public Response getAllJela() {
        List<Jelo> jela = jeloRepo.getAllJela();
        return Response.ok().entity(jela).build();
    }
}
