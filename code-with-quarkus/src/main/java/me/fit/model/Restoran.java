package me.fit.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@NamedQuery(name = "Restoran.getAllRestorani", query = "SELECT r FROM Restoran r")
@Table(name = "restoran")
public class Restoran {
    public static final String GET_ALL_RESTORANI = "Restoran.getAllRestorani";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String naziv;
    private String lokacija;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
        result = prime * result + ((lokacija == null) ? 0 : lokacija.hashCode());
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
        Restoran other = (Restoran) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (naziv == null) {
            if (other.naziv != null)
                return false;
        } else if (!naziv.equals(other.naziv))
            return false;
        if (lokacija == null) {
            if (other.lokacija != null)
                return false;
        } else if (!lokacija.equals(other.lokacija))
            return false;
        return true;
    }
}