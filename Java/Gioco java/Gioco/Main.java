package Gioco;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame finestra = new JFrame();
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setTitle("GIoco java");
        finestra.setVisible(true);
        finestra.setBounds(250, 400, 200, 315);
        /* finestra.setResizable(false);  */
        Gui g = new Gui();
        finestra.add(g);
        g.repaint();
        finestra.repaint();
    }
}