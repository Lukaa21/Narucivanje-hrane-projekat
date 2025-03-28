package me.fit.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = "Narudzbina.getAllNarudzbine",
            query = "SELECT n FROM Narudzbina n LEFT JOIN FETCH n.narucilac LEFT JOIN FETCH n.dostavljac")
@Table(name = "narudzbina")
public class Narudzbina {
    public static final String GET_ALL_NARUDZBINE = "Narudzbina.getAllNarudzbine";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String datum;
    private String status;

    @ManyToOne
    private Narucilac narucilac;

    @ManyToOne
    private Dostavljac dostavljac;

    @ManyToMany
    private List<Jelo> jela = new ArrayList<>();

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

    public int getId() { return id; }

    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Narucilac getNarucilac() { return narucilac; }
    public void setNarucilac(Narucilac narucilac) { this.narucilac = narucilac; }

    public Dostavljac getDostavljac() { return dostavljac; }
    public void setDostavljac(Dostavljac dostavljac) { this.dostavljac = dostavljac; }

    public List<Jelo> getJela() { return jela; }
    public void ListJela(List<Jelo> jela) { this.jela = jela; }

    @Override
    public String toString() {
        return "Narudzbina{id=" + id + ", datum='" + datum + "', status='" + status + "', narucilac=" + narucilac.getIme() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Narudzbina that)) return false;
        return id == that.id && Objects.equals(datum, that.datum) && Objects.equals(status, that.status) && Objects.equals(narucilac, that.narucilac) && Objects.equals(dostavljac, that.dostavljac) && Objects.equals(jela, that.jela);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datum, status, narucilac, dostavljac, jela);
    }
}
