import javax.swing;
public class Main {
    JFrame finestra;
    public Main() {
        finestra = new JFrame();
        finestra.setBounds(200, 200, 200, 200);
        finestra.setVisible(true);
        finestra.setDefaultClose(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] arg) {
        new Main();
    }
}