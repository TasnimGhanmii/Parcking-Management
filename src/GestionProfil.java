import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GestionProfil extends JInternalFrame {
    ArrayList<Profil> data = new ArrayList<Profil>();

    JLabel jlnom;
    JLabel jlprenom;
    JLabel jlpseudo;
    JLabel labelHelp;
    JButton btnVal;
    JPanel pnorth;
    JTextField nom, prenom, pseudo;
    DefaultListModel model;
    JTabbedPane jtp;

    GestionProfil() {
        this.setTitle("Gestion Profil ");
        this.setSize(900, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setClosable(true);
        this.setResizable(true);
        this.setIconifiable(true);
        this.setMaximizable(true);

        jlnom = new JLabel("nom");
        jlprenom = new JLabel("prenom");
        jlpseudo = new JLabel("pseudo");
        labelHelp = new JLabel("HELP");
        nom = new JTextField("ecrire nom", 15);
        prenom = new JTextField("ecrire prenom", 15);
        pseudo = new JTextField("ecrire pseudo", 15);

        btnVal = new JButton("valider");

        pnorth = new JPanel(new FlowLayout());
        pnorth.add(jlnom);
        pnorth.add(nom);
        pnorth.add(jlprenom);
        pnorth.add(prenom);
        pnorth.add(jlpseudo);
        pnorth.add(pseudo);
        pnorth.add(btnVal);

        this.add(pnorth, "North");


        this.add(labelHelp, "South");

        model = new DefaultListModel();
        JList jl = new JList<>(model);
        jl.setPreferredSize(new Dimension(150, 0));


        jtp = new JTabbedPane();


        JSplitPane jsp = new JSplitPane();
        jsp.setLeftComponent(jl);
        jsp.setRightComponent(jtp);

        this.add(jsp, BorderLayout.CENTER);



        //event part
        //action bouton valider
        btnVal.addActionListener(e -> {
            String nomText = nom.getText().trim();
            String prenomText = prenom.getText().trim();
            String pseudoText = pseudo.getText().trim();

            // Vérifier si les champs ne sont pas vides
            if (nomText.isEmpty() || prenomText.isEmpty() || pseudoText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Vérifier si le pseudo est déjà existant
            for (Profil profil : data) {
                if (profil.getPseudo().equals(pseudoText)) {
                    JOptionPane.showMessageDialog(this, "Le pseudo existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Ajouter le profil
            data.add(new Profil(nomText, prenomText, pseudoText));
            model.addElement(pseudoText);
            JOptionPane.showMessageDialog(this, "Profil ajouté avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
        });

        // Ajouter des écouteurs de souris pour chaque champ de saisie pour changer le texte d'aide
        nom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelHelp.setText("Aide : Saisissez le nom");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelHelp.setText("Aide : Passez le curseur sur les champs de saisie");
            }
        });

        prenom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelHelp.setText("Aide : Saisissez le prénom");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelHelp.setText("Aide : Passez le curseur sur les champs de saisie");
            }
        });

        pseudo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelHelp.setText("Aide : Saisissez le pseudo");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelHelp.setText("Aide : Passez le curseur sur les champs de saisie");
            }
        });
        //label coloring
        jlnom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jlnom.setForeground(Color.RED); // Changer la couleur du texte en rouge
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jlnom.setForeground(Color.BLACK); // Revenir à la couleur par défaut quand la souris quitte le label
            }
        });
        jlprenom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jlprenom.setForeground(Color.RED); // Changer la couleur du texte en rouge
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jlprenom.setForeground(Color.BLACK); // Revenir à la couleur par défaut quand la souris quitte le label
            }
        });

        jlpseudo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jlpseudo.setForeground(Color.RED); // Changer la couleur du texte en rouge
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jlpseudo.setForeground(Color.BLACK); // Revenir à la couleur par défaut quand la souris quitte le label
            }
        });
        nom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelHelp.setText("Aide : Saisissez le nom"); // Changer le texte du label d'aide
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelHelp.setText("Aide : Passez le curseur sur les champs de saisie"); // Revenir au texte d'aide par défaut
            }
        });

        prenom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelHelp.setText("Aide : Saisissez le prénom"); // Changer le texte du label d'aide
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelHelp.setText("Aide : Passez le curseur sur les champs de saisie"); // Revenir au texte d'aide par défaut
            }
        });

        pseudo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelHelp.setText("Aide : Saisissez le pseudo"); // Changer le texte du label d'aide
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelHelp.setText("Aide : Passez le curseur sur les champs de saisie"); // Revenir au texte d'aide par défaut
            }
        });


        nom.addFocusListener(new EcouteurFocus(this));
        prenom.addFocusListener(new EcouteurFocus(this));
        pseudo.addFocusListener(new EcouteurFocus(this));

        jl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Formulaire f = new Formulaire();
                    jtp.addTab(jl.getSelectedValue() + " ", f);
                }
                if(e.getButton()==MouseEvent.BUTTON3)
                {
                    JPopupMenu popup=new JPopupMenu();
                    JMenuItem itemModif=new JMenuItem("modifier");
                    JMenuItem itemSupp=new JMenuItem("supprimer");
                    JMenuItem itemSuppT=new JMenuItem("supprimer tous");

                    popup.add(itemModif);
                    popup.add(itemSupp);
                    popup.add(itemSuppT);
                    popup.show(jl,e.getX(),e.getY());
                    itemModif.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String newNom=JOptionPane.showInputDialog(GestionProfil.this,"donner nouveau nom");
                            String newPren=JOptionPane.showInputDialog(GestionProfil.this,"donner nouveau prenom");
                            data.set(jl.getSelectedIndex(),new Profil(newNom,newPren));



                        }
                    });

                    itemSupp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            data.remove(jl.getSelectedIndex());
                            model.removeElementAt(jl.getSelectedIndex());

                        }
                    });

                    itemSuppT.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            data.clear();
                            model.removeAllElements();
                            jtp.removeAll();
                        }
                    });






                }
            }
        });

        this.setVisible(true);
    }
}


//partie event
/* ne pas ajouter: un pseudo existant,des champs vides
   lorsque le curseur passe sur les label sa couleur change (foreground)
   lorsque le curseur passe sur les champs de saisi le label help change de texte
   exp:nom ici saisit votre prenom (classe externe)

 */

/*
jlist pour gerer des dds on a fait le model tzid w tna9ess fih
on doit sauvegarder les forum il faut faire: class from torbet kol profil bil formulair te3u
arraylist : type <tabform>
jtp ne5dmulu a7na notre propre projet

*/