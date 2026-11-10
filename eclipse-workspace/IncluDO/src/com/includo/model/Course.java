package com.includo.model;

public class Course {

    private int id;
    private String nome;
    private String descrizione;
    private String data;
    private int durataOre;
    private String luogo;
    private boolean disponibile;

    public Course(int id,
                  String nome,
                  String descrizione,
                  String data,
                  int durataOre,
                  String luogo,
                  boolean disponibile) {

        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.durataOre = durataOre;
        this.luogo = luogo;
        this.disponibile = disponibile;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getData() {
        return data;
    }

    public int getDurataOre() {
        return durataOre;
    }

    public String getLuogo() {
        return luogo;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Nome: " + nome +
                ", Data: " + data +
                ", Durata: " + durataOre + " ore" +
                ", Luogo: " + luogo +
                ", Disponibile: " +
                (disponibile ? "SI" : "NO");
    }
}