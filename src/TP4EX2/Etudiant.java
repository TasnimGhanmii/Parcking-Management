package TP4EX2;

public class Etudiant extends Personne {
    String filiere;
    int niveau;
    int groupe;

    public Etudiant(int id, String nom, String prenom,String filiere,int niveau,int groupe) {
        super(id, nom, prenom);
        this.filiere=filiere;
        this.niveau=niveau;
        this.groupe=groupe;
    }




}
