package model;

import java.util.ArrayList;
import java.util.List;

public class Restoran {
    private int id;
    private String naziv;
    private String lokacija;
    private List<Jelo> jela = new ArrayList<>();

    public Restoran(int id, String naziv, String lokacija) {
        this.id = id;
        this.naziv = naziv;
        this.lokacija = lokacija;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getLokacija() { return lokacija; }
    public void setLokacija(String lokacija) { this.lokacija = lokacija; }

    public List<Jelo> getJela() { return jela; }
    public void addJelo(Jelo jelo) { jela.add(jelo); }

    @Override
    public String toString() {
        return "Restoran{id=" + id + ", naziv='" + naziv + "', lokacija='" + lokacija + "'}";
    }
}