package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import me.fit.model.DTO.CountryResponseDTO;
import me.fit.model.client.CountryResponse;
import me.fit.model.client.TimeResponse;
import me.fit.model.client.WeatherResponse;
import me.fit.restclient.CountryClient;
import me.fit.restclient.TimeClient;
import me.fit.restclient.WeatherClient;
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

    @Inject
    EntityManager em;

    @RestClient
    TimeClient timeClient;

    @RestClient
    WeatherClient weatherClient;

    @RestClient
    CountryClient countryClient;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/AvailableCountries")
    public Response getAvailableCountries() {
        List<CountryResponse> countries = countryClient.getAvailableCountries();
        return Response.ok().entity(countries).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getForecast")
    @Transactional
    public Response getForecast(@QueryParam(value = "city") String city) {
         WeatherResponse weather = weatherClient.getForecast(city);
         restoranRepo.saveAndFilterForecast(weather);
         return Response.ok().entity(weather).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/NextPublicHolidays/{countryCode}")
    @Transactional
    public Response getNextPublicHolidays(@PathParam("countryCode") String countryCode) {
        List<CountryResponseDTO> dtos = countryClient.getNextPublicHolidays(countryCode);
        List<CountryResponse> holidays = restoranRepo.fromDtoList(dtos);

        for (CountryResponse holiday : holidays) {
            Long count = em.createQuery(
                            "SELECT COUNT(c) FROM CountryResponse c WHERE c.name = :name AND c.date = :date", Long.class)
                    .setParameter("name", holiday.getName())
                    .setParameter("date", holiday.getDate())
                    .getSingleResult();

            if (count == 0) {
                em.persist(holiday);
            }
        }
        return Response.ok().entity(holidays).build();
    }
}