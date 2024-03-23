import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TpJava extends JFrame implements ActionListener {
    JMenuItem newitemTP1;
    JMenuItem newitemTP2;
    JDesktopPane desktop;
    TpJava()
    {
        this.setTitle("TP JAVA ");
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         desktop=new JDesktopPane();
         this.add(desktop);

        JMenuBar newBar=new JMenuBar();
        JMenu newTp=new JMenu("TP");
        newitemTP1=new JMenuItem("TP1");
        newitemTP2=new JMenuItem("TP2");
        newitemTP2.addActionListener(this);
        newitemTP1.addActionListener(this);
        newTp.add(newitemTP1);
        newTp.add(newitemTP2);
        newBar.add(newTp);
        this.setJMenuBar(newBar);



        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newitemTP2)
        {
            GestionProfil g=new GestionProfil();
            desktop.add(g);

        }
        if(e.getSource()==newitemTP1)
        {
            MaFenetre f=new MaFenetre();
            desktop.add(f);

        }

    }
}
