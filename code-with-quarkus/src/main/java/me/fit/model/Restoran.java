package me.fit.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQuery(name = "Restoran.getAllRestorani", query = "SELECT r FROM Restoran r")
@Table(name = "restoran")
public class Restoran {
    public static final String GET_ALL_RESTORANI = "Restoran.getAllRestorani";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String naziv;
    private String lokacija;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "restoran_id")
    private Set<Jelo> jela;

    public Restoran() {
        super();
    }

    public Restoran(String naziv, String lokacija) {
        super();
        this.naziv = naziv;
        this.lokacija = lokacija;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getLokacija() { return lokacija; }
    public void setLokacija(String lokacija) { this.lokacija = lokacija; }

    public Set<Jelo> getJela() { return jela; }
    public void setJela(Set<Jelo> jela) {this.jela = jela;}

    @Override
    public String toString() {
        return "Restoran{id=" + id + ", naziv='" + naziv + "', lokacija='" + lokacija + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Restoran restoran)) return false;
        return id == restoran.id && Objects.equals(naziv, restoran.naziv) && Objects.equals(lokacija, restoran.lokacija) && Objects.equals(jela, restoran.jela);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, lokacija, jela);
    }
}
