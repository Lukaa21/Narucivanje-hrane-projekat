package me.fit.model.client;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CountryResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "date", unique = true)
    private String date;
    private String localName;
    private String name;
    private String countryCode;
    private boolean fixed;
    private boolean global;
    private String counties;
    private String launchYear;

    @OneToMany(mappedBy = "countryResponse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HolidayType> types = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getLocalName() {
        return localName;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public boolean getFixed() {
        return fixed;
    }

    public boolean getGlobal() {
        return global;
    }

    public String getCounties() {
        return counties;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public List<HolidayType> getTypes() {
        return types;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public void setLocalName( String localName ) {
        this.localName = localName;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setCountryCode( String countryCode ) {
        this.countryCode = countryCode;
    }

    public void setFixed( boolean fixed ) {
        this.fixed = fixed;
    }

    public void setGlobal( boolean global ) {
        this.global = global;
    }

    public void setCounties( String counties ) {
        this.counties = counties;
    }

    public void setLaunchYear( String launchYear ) {
        this.launchYear = launchYear;
    }

    public void setTypes(List<HolidayType> types) {
        this.types = types;
    }

    public CountryResponse() {
    }

    public CountryResponse(String date, String localName, String name, String countryCode, boolean fixed, boolean global, String counties, String launchYear, List<HolidayType> types) {
        this.date = date;
        this.localName = localName;
        this.name = name;
        this.countryCode = countryCode;
        this.fixed = fixed;
        this.global = global;
        this.counties = counties;
        this.launchYear = launchYear;
        this.types = types;
    }

    @Override
    public String toString() {
        return "CountryResponse{" +
                "counties='" + counties + '\'' +
                ", date='" + date + '\'' +
                ", localName='" + localName + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", fixed=" + fixed +
                ", global=" + global +
                ", launchYear='" + launchYear + '\'' +
                ", types=" + types +
                '}';
    }
}

