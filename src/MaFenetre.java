import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaFenetre extends JFrame implements ActionListener {

    MaFenetre()
    {
        this.setTitle("ma premiere fenetre");
        this.setSize(500,500);
        this.setBackground(Color.gray);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JPanel center= new JPanel();
        center.setLayout(new GridLayout(12,3,10,10));
        center.setBounds(25,25,300,400);

        JLabel np=new JLabel("nom & prénom:");
        JLabel mail=new JLabel("e-mail:");
        JLabel tel=new JLabel("Tél:");
        JLabel dnaiss=new JLabel("Date de naissance:");
        JLabel sexe=new JLabel("Sexe:");
        JLabel form=new JLabel("Formation:");
        JLabel java=new JLabel("JAVA");
        JLabel Python=new JLabel("Python");
        JLabel machine=new JLabel("machine learning");
        JLabel ph=new JLabel("enregistrer une version pdf de la condidature avant d'envoyer");


        //Dimension d1= new Dimension(0,0);
        JTextArea nompre =new JTextArea();
        //nompre.setPreferredSize(new Dimension(0,1));
        JTextArea email =new JTextArea();
        JTextArea telephone =new JTextArea();
        JTextArea comm =new JTextArea();

        comm.setPreferredSize(new Dimension(100,100));
        comm.setLineWrap(true);
        comm.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(comm);


        center.setOpaque(true);

        JPanel j1=new JPanel();
        j1.setLayout(new GridLayout());
        JRadioButton bt1=new JRadioButton("Homme");
        JRadioButton bt2=new JRadioButton("Femme");
        j1.add(bt2);
        j1.add(bt1);

        //scroll
        String[] items={"1","2","3","4","5"};
        JComboBox<String> jour=new JComboBox<>(items);
        JComboBox<String> moins=new JComboBox<>(items);
        String[] items2={"2000","2002","2003","2005","2010"};
        JComboBox<String> annee=new JComboBox<>(items2);
        String[] items3={"Ingenieur","tech"};
        JComboBox<String> formation=new JComboBox<>(items3);
        String[] items4={"debutant","Expert","intermediate"};
        String[] items5={"confirme","non confirme"};
        JComboBox<String> jvp=new JComboBox<>(items4);
        JComboBox<String> jvp1=new JComboBox<>(items4);
        JComboBox<String> jvp2=new JComboBox<>(items5);

        //chechbox
        JCheckBox ch=new JCheckBox();

        center.add(np);
        center.add(nompre);
        center.add(mail);
        center.add(email);
        center.add(tel);
        center.add(telephone);
        center.add(dnaiss);
        center.add(jour);
        center.add(moins);
        center.add(annee);
        center.add(sexe);
        center.add(j1);
        center.add(form);
        center.add(formation);
        center.add(java);
        center.add(jvp1);
        center.add(Python);
        center.add(jvp2);
        center.add(machine);
        center.add(jvp);
        center.add(ch);
        center.add(ph);
        center.add(new JButton("envoyer"));
        center.add(new JButton("annuler"));
        //this.add(center,BorderLayout.CENTER);
        /*----------------------------------

         */




        //j1.add(bt2);
        this.add(center);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}