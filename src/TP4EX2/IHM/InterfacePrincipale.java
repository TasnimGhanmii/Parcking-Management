package TP4EX2.IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfacePrincipale extends JInternalFrame implements ActionListener {
    JMenuBar bar;
    JMenu Formation;
    JMenu Etudiant;
    JMenu enseignant;
    JDesktopPane desktop;

    JMenuItem ajouterF,afficherF,rechercherF,ajouterEN,afficherEN,rechercherEN,ajouterET,afficherET,rechercherET;
    public InterfacePrincipale()
    {
        this.setTitle("Gestion de formation");
        this.setSize(800,800);
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setClosable(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        Formation=new JMenu("formation");
        Etudiant=new JMenu("etudiant");
        enseignant=new JMenu("enseignant");

        ajouterF=new JMenuItem("ajouter");
        rechercherF=new JMenuItem("rechercher");
        afficherF=new JMenuItem("afficher");

        ajouterEN=new JMenuItem("ajouter");
        rechercherEN=new JMenuItem("rechercher");
        afficherEN=new JMenuItem("afficher");

        ajouterET=new JMenuItem("ajouter");
        rechercherET=new JMenuItem("rechercher");
        afficherET=new JMenuItem("afficher");

        Formation.add(ajouterF);
        Formation.add(rechercherF);
        Formation.add(afficherF);

        Etudiant.add(ajouterET);
        Etudiant.add(rechercherET);
        Etudiant.add(afficherET);

        enseignant.add(ajouterEN);
        enseignant.add(rechercherEN);
        enseignant.add(afficherEN);

        //listeners
        ajouterEN.addActionListener(this);
        ajouterET.addActionListener(this);
        ajouterF.addActionListener(this);
        rechercherEN.addActionListener(this);
        rechercherET.addActionListener(this);
        rechercherF.addActionListener(this);
        afficherF.addActionListener(this);
        afficherEN.addActionListener(this);
        afficherET.addActionListener(this);

        bar=new JMenuBar();

        bar.add(Formation);
        bar.add(Etudiant);
        bar.add(enseignant);

        this.setJMenuBar(bar);

        this.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ajouterF)
        {
            IHMAjoutFormation f=new IHMAjoutFormation();


        }
        if(e.getSource()==ajouterET)
        {
            IHMAjoutEtudiant et=new IHMAjoutEtudiant();


        }

        if (e.getSource()==rechercherF)
        {
            IHMRechercheFormation f=new IHMRechercheFormation();

        }
        if(e.getSource()==rechercherET)
        {
            IHMRechercheEtudiant et= new IHMRechercheEtudiant();


        }
        if(e.getSource()==rechercherEN)
        {
            IHMRechercheEnseignant en=new IHMRechercheEnseignant();
        }

    }
}




