package me.fit.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Narudzbina;
import me.fit.repository.NarudzbinaRepository;

public class NarudzbinaResource {

    NarudzbinaRepository narudzbinaRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createNarudzbina")
    public Response createNarudzbina(Narudzbina n){
        Narudzbina na = narudzbinaRepository.createNarudzbina(n);
        return Response.ok().entity(na).build();
    }
}
