package me.fit.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQuery(name = "Dostavljac.getAllDostavljaci", query = "SELECT d FROM Dostavljac d")
@Table(name = "dostavljac")
public class Dostavljac {
    public static final String GET_ALL_DOSTAVLJACI = "Dostavljac.getAllDostavljaci";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String ime;
    private String prezime;
    private String vozilo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dostavljac_id")
    private Set<Narudzbina> narudzbine;

    public Dostavljac() {
        super();
    }

    public Dostavljac(String ime, String prezime, String vozilo) {
        super();
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

    public Set<Narudzbina> getNarudzbine() { return narudzbine; }

    @Override
    public String toString() {
        return "Dostavljac{id=" + id + ", ime='" + ime + "', prezime='" + prezime + "', vozilo='" + vozilo + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dostavljac that)) return false;
        return id == that.id && Objects.equals(ime, that.ime) && Objects.equals(prezime, that.prezime) && Objects.equals(vozilo, that.vozilo) && Objects.equals(narudzbine, that.narudzbine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, vozilo, narudzbine);
    }
}
