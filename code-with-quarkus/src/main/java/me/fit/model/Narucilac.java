package me.fit.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQuery(name = "Narucilac.getAllNarucioci", query = "SELECT n FROM Narucilac n")
@Table(name = "narucilac")
public class Narucilac {
    public static final String GET_ALL_NARUCIOCI = "Narucilac.getAllNarucioci";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String ime;
    private String adresa;
    private String telefon;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "narucilac_id")
    private Set<Narudzbina> narudzbine;

    public Narucilac() {
        super();
    }

    public Narucilac(String ime, String adresa, String telefon) {
        super();
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

    public Set<Narudzbina> getNarudzbine() { return narudzbine; }
    public void setNarudzbine(Set<Narudzbina> narudzbine) {this.narudzbine = narudzbine;}

    @Override
    public String toString() {
        return "Narucilac{id=" + id + ", ime='" + ime + "', adresa='" + adresa + "', telefon='" + telefon + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Narucilac narucilac)) return false;
        return id == narucilac.id && Objects.equals(ime, narucilac.ime) && Objects.equals(adresa, narucilac.adresa) && Objects.equals(telefon, narucilac.telefon) && Objects.equals(narudzbine, narucilac.narudzbine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, adresa, telefon, narudzbine);
    }
}
