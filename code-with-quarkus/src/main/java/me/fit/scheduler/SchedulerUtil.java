package me.fit.scheduler;

import io.quarkus.scheduler.Scheduled;
import me.fit.model.client.TimeResponse;
import me.fit.restclient.TimeClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

public class SchedulerUtil {

    @RestClient
    TimeClient timeClient;

    @Scheduled(every = "30000s")
    void getTime(){
        TimeResponse time = timeClient.getTime("Europe/Amsterdam");
        System.out.println(time);
    }
}
