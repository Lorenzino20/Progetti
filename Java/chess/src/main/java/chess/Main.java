package chess;

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args){
        Player p1 = new Player("White", 1);
        Player p2 = new Player("Black", 2);
        Board board = new Board(p1, p2);
        System.out.println(board.toString());
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Chess");
        GUI gui = new GUI(board);
        window.add(gui);
        gui.repaint();
        window.setSize(500, 500);
        window.setVisible(true);
        window.setResizable(true);
    }
}