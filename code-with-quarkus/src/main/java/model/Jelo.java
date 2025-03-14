package model;

import java.util.ArrayList;
import java.util.List;

public class Jelo {
    private int id;
    private String naziv;
    private double cijena;
    private Restoran restoran;
    private List<Narudzbina> narudzbine = new ArrayList<>();

    public Jelo(int id, String naziv, double cijena, Restoran restoran) {
        this.id = id;
        this.naziv = naziv;
        this.cijena = cijena;
        this.restoran = restoran;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public double getCijena() { return cijena; }
    public void setCijena(double cijena) { this.cijena = cijena; }

    public Restoran getRestoran() { return restoran; }
    public void setRestoran(Restoran restoran) { this.restoran = restoran; }

    public List<Narudzbina> getNarudzbine() { return narudzbine; }
    public void addNarudzbina(Narudzbina narudzbina) { narudzbine.add(narudzbina); }

    @Override
    public String toString() {
        return "Jelo{id=" + id + ", naziv='" + naziv + "', cijena=" + cijena + "}";
    }
}