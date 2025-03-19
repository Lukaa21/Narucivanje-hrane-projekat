package me.fit.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Jelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String naziv;
    private double cijena;

    @ManyToOne
    @JoinColumn(name = "restoran_id", nullable = false)
    private Restoran restoran;

    @ManyToMany(mappedBy = "jela")
    private List<Narudzbina> narudzbine = new ArrayList<>();

    public Jelo() {}

    public Jelo(String naziv, double cijena, Restoran restoran) {
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

    public List<Narudzbina> getNarudzbine() { return narudzbine; }

    @Override
    public String toString() {
        return "Jelo{id=" + id + ", naziv='" + naziv + "', cijena=" + cijena + ", restoran=" + restoran.getNaziv() + "}";
    }
}
