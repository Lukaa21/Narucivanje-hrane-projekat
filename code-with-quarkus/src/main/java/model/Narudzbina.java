package model;

import java.util.ArrayList;
import java.util.List;

public class Narudzbina {
    private int id;
    private String datum;
    private String status;
    private Narucilac narucilac;
    private Dostavljac dostavljac;
    private List<Jelo> jela = new ArrayList<>();

    public Narudzbina(int id, String datum, String status, Narucilac narucilac, Dostavljac dostavljac) {
        this.id = id;
        this.datum = datum;
        this.status = status;
        this.narucilac = narucilac;
        this.dostavljac = dostavljac;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Narucilac getNarucilac() { return narucilac; }
    public void setNarucilac(Narucilac narucilac) { this.narucilac = narucilac; }

    public Dostavljac getDostavljac() { return dostavljac; }
    public void setDostavljac(Dostavljac dostavljac) { this.dostavljac = dostavljac; }

    public List<Jelo> getJela() { return jela; }
    public void addJelo(Jelo jelo) { jela.add(jelo); }

    @Override
    public String toString() {
        return "Narudzbina{id=" + id + ", datum='" + datum + "', status='" + status + "'}";
    }
}