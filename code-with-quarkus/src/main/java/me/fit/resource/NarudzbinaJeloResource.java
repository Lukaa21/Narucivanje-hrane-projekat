package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.NarudzbinaJelo;
import me.fit.repository.NarudzbinaJeloRepository;

@Path("/narudzbinajelo")
public class NarudzbinaJeloResource {

    @Inject
    NarudzbinaJeloRepository narudzbinaJeloRepo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createNarudzbinaJelo(NarudzbinaJelo nj){
        NarudzbinaJelo obj = narudzbinaJeloRepo.createNarudzbinaJelo(nj);
        return Response.ok().entity(obj).build();
    }
}
