package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import java.util.List;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Narudzbina;
import me.fit.repository.NarudzbinaRepository;

@Path("/narduzbina/")
public class NarudzbinaResource {

    @Inject
    NarudzbinaRepository narudzbinaRepo;

    @POST
    @Path("/create/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNarudzbina(Narudzbina narudzbina) {
        Narudzbina n = narudzbinaRepo.createNarudzbina(narudzbina);
        return Response.ok().entity(n).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll/")
    public Response getAllNarudzbine() {
        List<Narudzbina> narudzbine = narudzbinaRepo.getAllNarudzbine();
        return Response.ok().entity(narudzbine).build();
    }
}
