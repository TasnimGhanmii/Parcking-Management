import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class GestionEtudiant extends JFrame{
     MyTableModel model;
    JPanel pnorth;
    JButton btnvalider;
    JTextField tfnom;
    JTextField tfprenom;
    JTextField tfcin,tfmoyenne;
    JLabel lbnom;
    JLabel lbprenom ;
    JLabel lbcin,lbmoyenne;
    JTable Jt_etud;

    GestionEtudiant(){
        this.setTitle("Gestion etudiant");
        this.setSize(1000,550);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);

        pnorth = new JPanel();
        pnorth.setBackground(Color.gray);
        pnorth.setLayout(new FlowLayout());
        tfnom=new JTextField("le nom : ",15);
        tfprenom=new JTextField("le prenom : ",15);
        tfcin=new JTextField("le cin : ",15);
        tfmoyenne=new JTextField("la moyenne : ",15);
        btnvalider=new JButton("Valider");
        btnvalider.setBackground(Color.darkGray);
        btnvalider.setForeground(Color.white);
        btnvalider.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
       lbnom= new JLabel("Nom");
       lbprenom= new JLabel("Prénom");
       lbcin = new JLabel("Cin");
        lbmoyenne = new JLabel("Moyenne");
        pnorth.add(lbnom);
        pnorth.add(tfnom);
        pnorth.add(lbprenom);
        pnorth.add(tfprenom);
        pnorth.add(lbcin);
        pnorth.add(tfcin);
        pnorth.add(lbmoyenne);
        pnorth.add(tfmoyenne);
        pnorth.add(btnvalider);
        this.add(pnorth, BorderLayout.NORTH);

        // Affichage des données
        Jt_etud=new JTable();
        this.add(new JScrollPane(Jt_etud));

        EtudiantDAO dao=new EtudiantDAO(Config.URL,Config.USERNAME,Config.PASSWORD);
        String req="Select * from etudiant";
        ResultSet rs=dao.selection(req);


        // Event
        btnvalider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom=tfnom.getText();
                String prenom=tfprenom.getText();
                int cin=Integer.parseInt(tfcin.getText());
                double moyenne= Double.parseDouble(tfmoyenne.getText());

            }
        });

        model=new MyTableModel(rs,dao);
        Jt_etud.setModel(model);

        //
        btnvalider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom=tfnom.getText();
                String prenom=tfprenom.getText();
                int cin=Integer.parseInt(tfcin.getText());
                double moyenne=Double.parseDouble(tfmoyenne.getText());
                model.insertEtudiant(nom,prenom,cin,moyenne);
            }
        });



    }

    public static void main(String[] args) {
        new GestionEtudiant().setVisible(true);
    }
}

