package me.fit.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "narudzbina_jelo")
public class NarudzbinaJelo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    Narudzbina narudzbina;

    @ManyToOne(cascade = CascadeType.ALL)
    Jelo jelo;

    public NarudzbinaJelo(Jelo jelo, Narudzbina narudzbina) {
        this.jelo = jelo;
        this.narudzbina = narudzbina;
    }

    public NarudzbinaJelo() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Jelo getJelo() {
        return jelo;
    }

    public void setJelo(Jelo jelo) {
        this.jelo = jelo;
    }

    public Narudzbina getNarudzbina() {
        return narudzbina;
    }

    public void setNarudzbina(Narudzbina narudzbina) {
        this.narudzbina = narudzbina;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NarudzbinaJelo that)) return false;
        return id == that.id && Objects.equals(narudzbina, that.narudzbina) && Objects.equals(jelo, that.jelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, narudzbina, jelo);
    }

    @Override
    public String toString() {
        return "NarudzbinaJelo{" +
                "id=" + id +
                ", narudzbina=" + narudzbina +
                ", jelo=" + jelo +
                '}';
    }
}
