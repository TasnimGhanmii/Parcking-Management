import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MaFenetre extends JInternalFrame implements ActionListener {
    JComboBox month;
    JComboBox year;
    JComboBox day;
    ButtonGroup radio;
    JButton upload;
    JLabel imag;

    MaFenetre()
    {
        this.setTitle("ma premiere fenetre");
        this.setSize(700,700);
        this.setBackground(Color.gray);
        this.setLayout(new BorderLayout());
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setClosable(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lb_titre=new JLabel("create your cv");
        lb_titre.setForeground(Color.white);
        lb_titre.setBackground(Color.blue);
        lb_titre.setFont(new Font("coudy stout",Font.ITALIC,33));
        lb_titre.setHorizontalAlignment(JLabel.CENTER);
        lb_titre.setOpaque(true);
        lb_titre.setVisible(true);

        this.add(lb_titre,BorderLayout.NORTH);

        JButton quitter=new JButton("quitter");
        JButton submit=new JButton("submit");

        JPanel bouton=new JPanel();
        bouton.setLayout(new FlowLayout());
        bouton.add(submit);
        bouton.add(quitter);
        this.add(bouton,BorderLayout.SOUTH);

        JPanel center=new JPanel();
        center.setLayout(new BorderLayout());
        this.add(center,BorderLayout.CENTER);

        JPanel personal=new JPanel();
        personal.setLayout(null);
        personal.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("informations personnelles"),new EmptyBorder(10,10,10,10)));
        personal.setPreferredSize(new Dimension(400,300));
        center.add(personal,BorderLayout.NORTH);


        JLabel np=new JLabel("nom & prénom:");
        JLabel mail=new JLabel("e-mail:");
        JLabel tel=new JLabel("Tél:");


        JLabel dnaiss=new JLabel("Date de naissance:");

        //scroll
        month=new JComboBox();
        year=new JComboBox();
        day=new JComboBox();
        for(int i=1960;i<=2024;i++)
        {
            year.addItem(i);
        }
        for(int i=1;i<=12;i++)
        {
            month.addItem(i);
        }
        for(int i=1;i<=30;i++)
        {
            day.addItem(i);
        }



        JLabel sexe=new JLabel("Sexe:");
        JLabel form=new JLabel("Formation:");


        np.setBounds(120,60,300,30);
        mail.setBounds(120,100,300,30);
        tel.setBounds(120,140,300,30);
        dnaiss.setBounds(120,180,300,30);
        day.setBounds(240,180,100,25);
        month.setBounds(360,180,100,25);
        year.setBounds(480,180,100,25);
        sexe.setBounds(120,220,300,30);
        form.setBounds(120,260,300,30);



        JTextArea nompre =new JTextArea();
        JTextArea email =new JTextArea();
        JTextArea telephone =new JTextArea();


        nompre.setBounds(240,60,200,25);
        email.setBounds(240,100,200,25);
        telephone.setBounds(240,140,200,25);



        personal.add(np);
        personal.add(nompre);
        personal.add(mail);
        personal.add(email);
        personal.add(tel);
        personal.add(telephone);
        personal.add(dnaiss);
        personal.add(day);
        personal.add(month);
        personal.add(year);


        personal.add(sexe);
        radio=new ButtonGroup();
        JRadioButton bt1=new JRadioButton("Homme");
        JRadioButton bt2=new JRadioButton("Femme");
        bt1.setBounds(240,220,90,25);
        bt2.setBounds(360,220,90,25);
        radio.add(bt2);
        radio.add(bt1);
        personal.add(bt1);
        personal.add(bt2);

        personal.add(form);
        String[] items3={"Ingenieur","tech"};
        JComboBox<String> formation=new JComboBox<>(items3);
        formation.setBounds(240,260,100,30);
        personal.add(formation);


        imag=new JLabel("image");
        imag.setBounds(540,50,80,80);
        personal.add(imag);

        upload=new JButton("upload");
        upload.setBounds(500,140,180,25);
        personal.add(upload);
        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    // Process the selected file (e.g., display the image)
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image image = imageIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
                    imag.setIcon(new ImageIcon(image));
                }
            }
        });



        JPanel professional=new JPanel();
        professional.setLayout(null);
        professional.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("informations professional"),new EmptyBorder(10,10,10,10)));
        professional.setPreferredSize(new Dimension(400,260));
        center.add(professional,BorderLayout.SOUTH);

        JLabel java=new JLabel("JAVA");
        JLabel Python=new JLabel("Python");
        JLabel machine=new JLabel("machine learning");


        java.setBounds(120,60,300,30);
        Python.setBounds(120,100,300,30);
        machine.setBounds(120,140,300,30);

        JTextArea comm =new JTextArea();
        comm.setPreferredSize(new Dimension(100,100));
        comm.setLineWrap(true);
        comm.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(comm);

        String[] items4={"debutant","Expert","intermediate"};
        String[] items5={"confirme","non confirme"};
        JComboBox<String> jvp=new JComboBox<>(items4);
        JComboBox<String> jvp1=new JComboBox<>(items4);
        JComboBox<String> jvp2=new JComboBox<>(items5);

        jvp.setBounds(240,60,100,25);
        jvp1.setBounds(240,100,100,25);
        jvp2.setBounds(240,140,100,25);
        scrollPane.setBounds(400,75,150,180);

        professional.add(java);
        professional.add(Python);
        professional.add(machine);
        professional.add(jvp);
        professional.add(jvp1);
        professional.add(jvp2);
        professional.add(scrollPane);


      





        this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}