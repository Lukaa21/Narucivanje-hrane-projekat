package me.fit.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dostavljac")
public class Dostavljac {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String ime;
    private String prezime;
    private String vozilo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ime == null) ? 0 : ime.hashCode());
        result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
        result = prime * result + ((vozilo == null) ? 0 : vozilo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dostavljac other = (Dostavljac) obj;
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
        if (prezime == null) {
            if (other.prezime != null)
                return false;
        } else if (!prezime.equals(other.prezime))
            return false;
        if (vozilo == null) {
            if (other.vozilo != null)
                return false;
        } else if (!vozilo.equals(other.vozilo))
            return false;
        return true;
    }


}
