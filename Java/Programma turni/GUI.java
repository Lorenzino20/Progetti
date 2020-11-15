import javax.swing.*;
import java.awt.*;
public class GUI extends JFrame {
    public GUI() {
        JFrame finestra = new JFrame();
        Container c = finestra.getContentPane();
        String lista[] = new String[10];
        for(int i = 0; i < 10; i++)
        lista[i] = "Elemento";
        finestra.setSize(700, 700);
        JTextField text = new JTextField("Ciao");
        text.setBounds(50, 50, 100, 100);
        JComboBox box1 = new JComboBox(lista);
        c.add(box1);
        c.add(text);
        finestra.setDefaultCloseOperation(EXIT_ON_CLOSE);
        finestra.setVisible(true);
        finestra.setTitle("Turni");
    }
}