import javax.swing.*;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Board extends JPanel {
    private final int BOARD_HEIGHT = 500;
    private final int BOARD_WIDTH = 500;
    private final int PERIOD_INTERVAL = 300;

    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isPaused = false;

    private int curY;
    private int curX;

    private Piece piece;
    private Piece[] board;
    public Board(Game parent) {

        initBoard(parent);
    }
    private void initBoard(Game parent) {
        setFocusable(true);
        addKeyListener(new TAdapter());
    }

    public void start() {
        piece = new Piece();
        timer = new Timer(PERIOD_INTERVAL, new GameCycle());
        timer.start();
        board = new Piece[BOARD_WIDTH];
    }

    public void pause() {
        isPaused = !isPaused;
        if(isPaused) 
            System.out.println("Pause");
        else
            System.out.println("Nothing");
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLine(g);
    }
    public void dropDown() {
        int newY = curY;

        while(newY > 0) {
            if(!tryMove(piece, curX, newY - 1)) {
                break;
            }
            newY--;
        }
        pieceDropped();
    }
    public void clearBoard() {
        piece.setX(0);
        piece.setY(BOARD_HEIGHT/2);
    }
    public void pieceDropped() {
        for(int i = 0; i < 4; i++) {
            int x = curX + piece.x(i);
            int y = curY - piece.y(i);
            board[(y * BOARD_WIDTH) + x] = piece;
        }
        if(!isFallingFinished) {
            System.out.println("Perso");
        }
    }
    public boolean tryMove(Piece piece, int newX, int newY) {
        for(int i = 0; i < 4; i++) {
            int x = newX + piece.x(i);
            int y = newY - piece.y(i);

            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) {

                return false;
            }
        }
        curX = newX;
        curY = newY;
        return true;
    }

    public void drawLine(Graphics g) {
        g.drawLine(0, BOARD_HEIGHT/2, BOARD_WIDTH, BOARD_HEIGHT/2);
    }

    private class GameCycle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            doGameCycle();
        }
    }
    private void doGameCycle() {
        update();
        repaint();
    }
    private void update() {
        if(isPaused)
            return;
        if(isFallingFinished) {
            isFallingFinished = false;
            System.out.println("Hai perso");
        }
    }
    class TAdapter extends KeyAdapter {
        public void KeyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if(keycode == KeyEvent.VK_SPACE)
            //move();
            System.out.println("OK");
        }
    }
}