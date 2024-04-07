package TP4EX2;

class Enseignant extends Personne
{
     String grade,speacialte;

    public Enseignant(int id, String nom, String prenom,String grade ,String specialte ) {
        super(id, nom, prenom);
        this.grade=grade;
        this.speacialte=specialte;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpeacialte() {
        return speacialte;
    }

    public void setSpeacialte(String speacialte) {
        this.speacialte = speacialte;
    }
}