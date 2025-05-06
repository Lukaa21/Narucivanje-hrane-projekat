package me.fit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "narudzbina")
public class Narudzbina {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String datum;
    private String status;

    @ManyToOne
    private Narucilac narucilac;

    @ManyToOne
    private Dostavljac dostavljac;

    public Narudzbina() {
        super();
    }

    public Narudzbina(String datum, String status, Narucilac narucilac, Dostavljac dostavljac) {
        super();
        this.datum = datum;
        this.status = status;
        this.narucilac = narucilac;
        this.dostavljac = dostavljac;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Narucilac getNarucilac() { return narucilac; }
    public void setNarucilac(Narucilac narucilac) { this.narucilac = narucilac; }

    public Dostavljac getDostavljac() { return dostavljac; }
    public void setDostavljac(Dostavljac dostavljac) { this.dostavljac = dostavljac; }

    @Override
    public String toString() {
        return "Narudzbina{id=" + id + ", datum='" + datum + "', status='" + status + "', narucilac=" + narucilac.getIme() + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Narudzbina other = (Narudzbina) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (datum == null) {
            if (other.datum != null)
                return false;
        } else if (!datum.equals(other.datum))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((datum == null) ? 0 : datum.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }
}
