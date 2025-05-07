package me.fit.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import me.fit.model.client.WeatherResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "weather-api")
public interface WeatherClient {
    @GET
    @Path("/weather/{city}")
    WeatherResponse getForecast(@PathParam("city") String city);
}
