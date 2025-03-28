package me.fit.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name = "Jelo.getAllJela", query = "SELECT j FROM Jelo j LEFT JOIN FETCH j.restoran")
@Table(name = "jelo")
public class Jelo {
    public static final String GET_ALL_JELA = "Jelo.getAllJela";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String naziv;
    private double cijena;

    @ManyToOne
    private Restoran restoran;

    public Jelo() {
        super();
    }

    public Jelo(String naziv, double cijena, Restoran restoran) {
        super();
        this.naziv = naziv;
        this.cijena = cijena;
        this.restoran = restoran;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public double getCijena() { return cijena; }
    public void setCijena(double cijena) { this.cijena = cijena; }

    public Restoran getRestoran() { return restoran; }
    public void setRestoran(Restoran restoran) { this.restoran = restoran; }

    @Override
    public String toString() {
        return "Jelo{id=" + id + ", naziv='" + naziv + "', cijena=" + cijena + ", restoran=" + restoran.getNaziv() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jelo jelo)) return false;
        return id == jelo.id && Double.compare(cijena, jelo.cijena) == 0 && Objects.equals(naziv, jelo.naziv) && Objects.equals(restoran, jelo.restoran);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, cijena, restoran);
    }
}
