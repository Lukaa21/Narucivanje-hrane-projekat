package me.fit.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restoran")
public class Restoran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private int id;

    private String naziv;
    private String lokacija;

    @OneToMany(mappedBy = "restoran", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jelo> jela = new ArrayList<>();

    public Restoran() {}

    public Restoran(String naziv, String lokacija) {
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
    public void addJelo(Jelo jelo) {
        jela.add(jelo);
        jelo.setRestoran(this); // Postavljamo referencu na restoran
    }

    @Override
    public String toString() {
        return "Restoran{id=" + id + ", naziv='" + naziv + "', lokacija='" + lokacija + "'}";
    }
}
