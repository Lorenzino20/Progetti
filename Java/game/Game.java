import javax.swing.*;
import java.awt.EventQueue;
public class Game extends JFrame {
    public Game() {
        initUI();
    }
    private void initUI() {
        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Game");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var game = new Game();
            game.setVisible(true);
        });
    }

}