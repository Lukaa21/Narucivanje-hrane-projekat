package me.fit.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dostavljac")
public class Dostavljac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ime;
    private String prezime;
    private String vozilo;

    @OneToMany(mappedBy = "dostavljac", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Narudzbina> narudzbine = new ArrayList<>();

    public Dostavljac() {}

    public Dostavljac(String ime, String prezime, String vozilo) {
        this.ime = ime;
        this.prezime = prezime;
        this.vozilo = vozilo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }

    public String getVozilo() { return vozilo; }
    public void setVozilo(String vozilo) { this.vozilo = vozilo; }

    public List<Narudzbina> getNarudzbine() { return narudzbine; }
    public void addNarudzbina(Narudzbina narudzbina) {
        narudzbine.add(narudzbina);
        narudzbina.setDostavljac(this);
    }

    @Override
    public String toString() {
        return "Dostavljac{id=" + id + ", ime='" + ime + "', prezime='" + prezime + "', vozilo='" + vozilo + "'}";
    }
}
