import javax.swing.*;
import java.awt.*;
public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField textUp = new JTextField();
    JTextField textDown = new JTextField();
    JButton bottone1 = new JButton("1");
    JButton bottone2 = new JButton("2");
    JButton bottone3 = new JButton("3");
    JButton bottone4 = new JButton("4");
    JButton bottone5 = new JButton("5");
    JButton bottone6 = new JButton("6");
    JButton bottone7 = new JButton("7");
    JButton bottone8 = new JButton("8");
    JButton bottone9 = new JButton("9");
    JButton bottone0 = new JButton("0");
    JButton bottonePoint = new JButton(".");
    JButton bottoneCanc = new JButton("Canc");
    JButton bottonePlus = new JButton("+");
    JButton bottoneMinus = new JButton("-");
    JButton bottoneTime = new JButton("*");
    JButton bottoneDivide = new JButton("/");
    JButton bottoneEquals = new JButton("=");
    
    public GUI() {
        super("Calcolatrice");
        Container finestra = this.getContentPane();
        finestra.setLayout(null);
        finestra.setSize(400,500);
        finestra.setVisible(true);
        finestra.add(bottone1);
        finestra.add(bottone2);
        finestra.add(bottone3);
        finestra.add(bottone4);
        finestra.add(bottone5);
        finestra.add(bottone6);
        finestra.add(bottone7);
        finestra.add(bottone8);
        finestra.add(bottone9);
        finestra.add(bottone0);
        finestra.add(bottonePoint);
        finestra.add(bottoneCanc);
        finestra.add(bottonePlus);
        finestra.add(bottoneMinus);
        finestra.add(bottoneTime);
        finestra.add(bottoneDivide);
        finestra.add(bottoneEquals);
        finestra.add(textUp);
        finestra.add(textDown);
        textUp.setBounds(120, 20, 210, 50);
        textDown.setBounds(120, 80, 210, 50);
        
        bottoneCanc.setBounds(40, 20, 70, 50);

        bottone1.setBounds(40, 140, 50, 50);
        bottone4.setBounds(40, 220, 50, 50);
        bottone7.setBounds(40, 300, 50, 50);
        bottone0.setBounds(40, 380, 50, 50);

        bottone2.setBounds(120, 140, 50, 50);
        bottone5.setBounds(120, 220, 50, 50);
        bottone8.setBounds(120, 300, 50, 50);
        bottonePoint.setBounds(120, 380, 50, 50);

        bottone3.setBounds(200, 140, 50, 50);
        bottone6.setBounds(200, 220, 50, 50);
        bottone9.setBounds(200, 300, 50, 50);
        bottoneEquals.setBounds(200, 380, 70, 50);

        bottonePlus.setBounds(280, 140, 50, 50);
        bottoneMinus.setBounds(280, 220, 50, 50);
        bottoneTime.setBounds(280, 300, 50, 50);
        bottoneDivide.setBounds(280, 380, 50, 50);
    }        
}   