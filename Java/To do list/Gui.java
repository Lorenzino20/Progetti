import javax.swing.*;
public class Gui {
    public JFrame finestra;
    public JTextField to_do;
    public JTextField doing;
    public JTextField done;
    public JTextArea to_do_list;
    public Gui() {
        finestra = new JFrame();
        finestra.setSize(400, 400);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setVisible(true);
        finestra.setLayout(null);
        addTodo();
        addDoing();
        addDone();
        addTo_do_Area();
    }

    public JTextField createTodo() {
        to_do = new JTextField();
        to_do.setBounds(20, 20, 40, 40);
        to_do.setText("To-do");
        to_do.setEditable(false);
        return to_do;
    }

    public void addTodo() {
        finestra.add(createTodo());
        finestra.repaint();
    }

    public JTextField createDoing() {
        doing = new JTextField();
        doing.setBounds(80, 20, 40, 40);
        doing.setText("Doing");
        doing.setEditable(false);
        return doing;
    }

    public void addDoing() {
        finestra.add(createDoing());
        finestra.repaint();
    }

    public JTextField createDone() {
        done = new JTextField();
        done.setBounds(140, 20, 40, 40);
        done.setText("Done");
        done.setEditable(false);
        return done;
    }

    public void addDone() {
        finestra.add(createDone());
        finestra.repaint();
    }

    public JTextArea create_To_do_Area() {
        to_do_list = new JTextArea();
        to_do_list.setBounds(20, 100, 40, 40);
        return to_do_list;
    }

    public void addTo_do_Area() {
        finestra.add(create_To_do_Area());
        finestra.repaint();
    }
    
    public static void main(String[] args) {
        new Gui();
    }
}