package me.fit.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import me.fit.model.DTO.CountryResponseDTO;
import me.fit.model.client.CountryResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.List;

@RegisterRestClient(configKey = "country-api")
public interface CountryClient {

    @GET
    @Path("/AvailableCountries")
    List<CountryResponse> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    List<CountryResponseDTO> getNextPublicHolidays(@PathParam("countryCode") String countryCode);
}
