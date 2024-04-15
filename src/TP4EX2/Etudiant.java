package TP4EX2;

public class Etudiant extends Personne {
    String filiere;
    String niveau;
    String groupe;

    public Etudiant(int id, String nom, String prenom,String filiere,String niveau,String groupe) {
        super(id, nom, prenom);
        this.filiere=filiere;
        this.niveau=niveau;
        this.groupe=groupe;
    }




}
