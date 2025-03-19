package me.fit.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Narudzbina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String datum;
    private String status;

    @ManyToOne
    @JoinColumn(name = "narucilac_id", nullable = false)
    private Narucilac narucilac;

    @ManyToOne
    @JoinColumn(name = "dostavljac_id", nullable = false)
    private Dostavljac dostavljac;

    @ManyToMany
    @JoinTable(
            name = "narudzbina_jelo", // Ime međutabele
            joinColumns = @JoinColumn(name = "narudzbina_id"), // Strani ključ za Narudzbina
            inverseJoinColumns = @JoinColumn(name = "jelo_id") // Strani ključ za Jelo
    )
    private List<Jelo> jela = new ArrayList<>();

    public Narudzbina() {}

    public Narudzbina(String datum, String status, Narucilac narucilac, Dostavljac dostavljac) {
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
    public void addJelo(Jelo jelo) {
        jela.add(jelo);
        jelo.getNarudzbine().add(this); // Dvosmjerna veza
    }

    @Override
    public String toString() {
        return "Narudzbina{id=" + id + ", datum='" + datum + "', status='" + status + "', narucilac=" + narucilac.getIme() + "}";
    }
}
