package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Narucilac;
import me.fit.repository.NarucilacRepository;
import java.util.List;

@Path("/narucilac/")
public class NarucilacResource {
    @Inject
    NarucilacRepository narucilacRepo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create/")
    public Response createNarucilac(Narucilac narucilac) {
        Narucilac n = narucilacRepo.createNarucilac(narucilac);
        return Response.ok().entity(n).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll/")
    public Response getAllNarucioci(){
        List<Narucilac> narucioci = narucilacRepo.getAllNarucioci();
        return Response.ok().entity(narucioci).build();
    }
}
