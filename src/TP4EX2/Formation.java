package TP4EX2;

import java.util.Date;

public class Formation {

    int id;
    String Titre;
    Date DateF;
    String Lieu;
    boolean certification;


    Formation(int id,String Titre,Date DateF,String lieu,boolean certif)
    {
        this.id=id;
        this.Titre=Titre;
        this.certification=certif;
        this.DateF=DateF;
        Lieu=lieu;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public Date getDateF() {
        return DateF;
    }

    public void setDateF(Date dateF) {
        DateF = dateF;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String lieu) {
        Lieu = lieu;
    }

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }
}

