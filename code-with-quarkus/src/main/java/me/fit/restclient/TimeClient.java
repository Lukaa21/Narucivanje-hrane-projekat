package me.fit.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import me.fit.model.client.TimeResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/time/current")
@RegisterRestClient(configKey = "time-api")
public interface TimeClient {
    @GET
    @Path("/zone")
    TimeResponse getTime(@QueryParam("timezone") String timezone);

    @GET
    @Path("/coordinates")
    TimeResponse getCoordinate(@QueryParam("latitude") String latitude, @QueryParam("longitude") String longitude);

    @GET
    @Path("/ip")
    TimeResponse getIp(@QueryParam("ipAddress") String ipAddress);

}
