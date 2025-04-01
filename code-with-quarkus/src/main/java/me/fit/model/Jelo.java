package me.fit.model;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "Jelo.getJelaForRestoran", query = "Select j from Jelo j where j.restoran.id = :id")
@Table(name = "jelo")
public class Jelo {
    public static final String GET_JELA_FOR_RESTORAN = "Jelo.getJelaForRestoran";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String naziv;
    private double cijena;

    @ManyToOne
    private Restoran restoran;

    public Jelo() {
        super();
    }

    public Jelo(String naziv, double cijena) {
        super();
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public double getCijena() { return cijena; }
    public void setCijena(double cijena) { this.cijena = cijena; }

    @Override
    public String toString() {
        return "Jelo{id=" + id + ", naziv='" + naziv + "', cijena=" + cijena;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Jelo other = (Jelo) obj;
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
        if (Double.doubleToLongBits(cijena) != Double.doubleToLongBits(other.cijena))
            return false;
        return true;
    }
}