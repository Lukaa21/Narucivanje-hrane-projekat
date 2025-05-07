package me.fit.model.client;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class WeatherResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "weather_response_id_seq", sequenceName = "weather_response_id_seq", allocationSize = 1)
    private Long id;
    private String temperature;
    private String wind;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<WeatherResponse> forecast;

    public WeatherResponse() {
    }

    public WeatherResponse(String temperature, String wind, String description) {
        this.temperature = temperature;
        this.wind = wind;
        this.description = description;
    }


    // Getter Methods

    public Long getId() {
        return id;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWind() {
        return wind;
    }

    public String getDescription() {
        return description;
    }

    public void addForecast(WeatherResponse forecast) {
        this.forecast.add(forecast);
    }

    // Setter Methods

    public void setId( Long id ) {
        this.id = id;
    }

    public void setTemperature( String temperature ) {
        this.temperature = temperature;
    }

    public void setWind( String wind ) {
        this.wind = wind;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public List<WeatherResponse> getForecast() {
        return forecast;
    }
}
