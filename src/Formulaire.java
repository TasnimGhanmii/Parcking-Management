import javax.swing.*;
import java.awt.*;

public class Formulaire extends JPanel {

    Formulaire(){
        JLabel lb = new JLabel("Bienvenus");
        lb.setForeground(Color.PINK);
        lb.setOpaque(true);
        lb.setFont(new Font("Arial",Font.BOLD,20));
        lb.setHorizontalAlignment(JLabel.CENTER);

        this.add(lb);
        this.setVisible(true);
    }
}
