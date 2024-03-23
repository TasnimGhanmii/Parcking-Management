import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EcouteurFocus implements FocusListener {
    GestionProfil gestionProfil;
    JTextField tf;

    public EcouteurFocus(GestionProfil gestionProfil) {
        this.gestionProfil=gestionProfil;
    }

    @Override
    public void focusGained(FocusEvent e) {
        tf=(JTextField) e.getComponent();
        tf.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(tf.getText().equals(""))
        {
            if (tf.equals(gestionProfil.nom))
            {
                tf.setText("ecrire nom");
            }
            if (tf.equals(gestionProfil.prenom))
            {
                tf.setText("ecrire prenom");
            }
            if (tf.equals(gestionProfil.pseudo))
            {
                tf.setText("ecrire pseudo");
            }
        }
    }
}
