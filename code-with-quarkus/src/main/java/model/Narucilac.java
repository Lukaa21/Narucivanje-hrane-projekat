package model;

import java.util.ArrayList;
import java.util.List;

public class Narucilac {
    private int id;
    private String ime;
    private String adresa;
    private String telefon;
    private List<Narudzbina> narudzbine = new ArrayList<>();

    public Narucilac(int id, String ime, String adresa, String telefon) {
        this.id = id;
        this.ime = ime;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public List<Narudzbina> getNarudzbine() { return narudzbine; }
    public void addNarudzbina(Narudzbina narudzbina) { narudzbine.add(narudzbina); }

    @Override
    public String toString() {
        return "Narucilac{id=" + id + ", ime='" + ime + "', adresa='" + adresa + "', telefon='" + telefon + "'}";
    }
}
