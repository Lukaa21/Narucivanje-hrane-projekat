package me.fit.model.client;
import jakarta.persistence.*;

@Entity
public class HolidayType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String type;

    @ManyToOne
    @JoinColumn(name = "country_response_id")
    private CountryResponse countryResponse;

    public HolidayType() {
    }

    public HolidayType(CountryResponse countryResponse, Long id, String type) {
        this.countryResponse = countryResponse;
        this.id = id;
        this.type = type;
    }

    public CountryResponse getCountryResponse() {
        return countryResponse;
    }

    public void setCountryResponse(CountryResponse countryResponse) {
        this.countryResponse = countryResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
