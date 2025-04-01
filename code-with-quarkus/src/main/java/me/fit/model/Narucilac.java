package me.fit.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "narucilac")
public class Narucilac {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String ime;
    private String adresa;
    private String telefon;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Narucilac other = (Narucilac) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ime == null) {
            if (other.ime != null)
                return false;
        } else if (!ime.equals(other.ime))
            return false;
        if (adresa == null) {
            if (other.adresa != null)
                return false;
        } else if (!adresa.equals(other.adresa))
            return false;
        if (telefon == null) {
            if (other.telefon != null)
                return false;
        } else if (!telefon.equals(other.telefon))
            return false;
        return true;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ime == null) ? 0 : ime.hashCode());
        result = prime * result + ((adresa == null) ? 0 : adresa.hashCode());
        result = prime * result + ((telefon == null) ? 0 : telefon.hashCode());
        return result;
    }
}
