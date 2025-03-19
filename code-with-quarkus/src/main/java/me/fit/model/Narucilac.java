package me.fit.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "narucilac")
public class Narucilac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ime;
    private String adresa;
    private String telefon;

    @OneToMany(mappedBy = "narucilac", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Narudzbina> narudzbine = new ArrayList<>();

    public Narucilac() {}

    public Narucilac(String ime, String adresa, String telefon) {
        this.ime = ime;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public List<Narudzbina> getNarudzbine() { return narudzbine; }
    public void addNarudzbina(Narudzbina narudzbina) {
        narudzbine.add(narudzbina);
        narudzbina.setNarucilac(this); // Postavljamo stranu vezu
    }

    @Override
    public String toString() {
        return "Narucilac{id=" + id + ", ime='" + ime + "', adresa='" + adresa + "', telefon='" + telefon + "'}";
    }
}
