package com.includo.model;

public class Booking {

    private int id;
    private int courseId;
    private int userId;
    private String dataInizio;
    private String dataFine;

    public Booking(int id,
                   int courseId,
                   int userId,
                   String dataInizio,
                   String dataFine) {

        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getUserId() {
        return userId;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    @Override
    public String toString() {
        return "ID Prenotazione: " + id +
                ", ID Corso: " + courseId +
                ", ID Utente: " + userId +
                ", Dal: " + dataInizio +
                ", Al: " + dataFine;
    }
}