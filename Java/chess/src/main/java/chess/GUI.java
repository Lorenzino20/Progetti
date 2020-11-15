package chess;

import java.awt.*;
import javax.swing.*;

import pieces.IntPair;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Implementa una GUI per la visualizzazione grafica
 * della aprtita di scacchi
 * @author Andrea
 * @version 1.1
 */
public class GUI extends JPanel{
    private static final long serialVersionUID = 1L;

    private Font drawFont;
    private Board board;

    //coordinate del click del mouse
    public int x;
    public int y;

    private int turn;
    private int subTurn; //0: inizio turno, 1: selezionata la pedina

    IntPair start;
    IntPair end;

    //colori usati per la scacchiera
    Color beige = new Color(255, 200, 150);
    Color brown = new Color(130, 95, 65);

    //immagini dei vari pezzi
    private Image w_King;
    private Image w_Queen;
    private Image w_Rook;
    private Image w_Bishop;
    private Image w_Knight;
    private Image w_Pawn;
    private Image b_King;
    private Image b_Queen;
    private Image b_Rook;
    private Image b_Bishop;
    private Image b_Knight;
    private Image b_Pawn;

    /**
     * Costruttore
     */
    public GUI(Board board){
        x = 0;
        y = 0;
        start = new IntPair(Board.SIZE, Board.SIZE);
        end = new IntPair(Board.SIZE, Board.SIZE);
        turn = 1;
        subTurn = 1;

        //aggiunta evento del click del mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                if(x < 50)
                    x = 50 * Board.SIZE +50;

                int tmpI = y /50;
                int tmpJ = (x -50) /50;
                
                if(subTurn == 1){
                    try{
                        if(tmpI >= 0 && tmpI < Board.SIZE &&
                           tmpJ >= 0 && tmpJ < Board.SIZE &&
                           board.getPiece(tmpI, tmpJ).getPlayer().getTurn() == turn){
                            start = new IntPair(y /50, (x -50) /50);
                            subTurn = 2;

                            //reset dati di end
                            end = new IntPair(-1, -1);
                        }
                    }
                    catch(NullPointerException ex){}
                }
                else{
                    if(tmpI == start.getFirst() && tmpJ == start.getSecond()){
                        start = new IntPair(-1, -1);
                        subTurn = 1;
                        repaint();
                        return;
                    }
                    try{
                        if(tmpI >= 0 && tmpI < Board.SIZE &&
                           tmpJ >= 0 && tmpJ < Board.SIZE &&
                           board.getPiece(tmpI, tmpJ).getPlayer().getTurn() !=  turn){
                        end = new IntPair(y /50, (x -50) /50);
                        subTurn = 1;

                        //cambio di turno
                        turn = turn == 1 ? 2 : 1;
                        }
                    }
                    catch(NullPointerException ex){
                        end = new IntPair(y /50, (x -50) /50);
                        subTurn = 1;

                        //cambio di turno
                        turn = turn == 1 ? 2 : 1;
                    }

                    //esegui la mossa
                    if(subTurn == 1 && start.getFirst() != -1){
                        try{
                            board.getPiece(start.getFirst(), start.getSecond())
                            .move(end.getFirst(), end.getSecond());

                            //reset dati di start
                            start = new IntPair(-1, -1);
                        }
                        catch(Exception ex){    //significa che la casella cliccata non vale
                            subTurn = 2;
                            turn = turn == 1 ? 2 : 1;
                        }
                        System.out.println(board.check());
                    }
                }
                repaint();
            }
        });

        this.board = board;
        drawFont = new Font("Arial Black", Font.BOLD, 20);

        b_King = Toolkit.getDefaultToolkit().getImage("res/pieces/b_King.svg");
        b_Queen = Toolkit.getDefaultToolkit().getImage("res/pieces/b_Queen.svg");
        b_Rook = Toolkit.getDefaultToolkit().getImage("res/pieces/b_Rook.svg");
        b_Bishop = Toolkit.getDefaultToolkit().getImage("res/pieces/b_Bishop.svg");
        b_Knight = Toolkit.getDefaultToolkit().getImage("res/pieces/b_Knight.svg");
        b_Pawn = Toolkit.getDefaultToolkit().getImage("res/pieces/b_Pawn.svg");
        w_King = Toolkit.getDefaultToolkit().getImage("res/pieces/w_King.svg");
        w_Queen = Toolkit.getDefaultToolkit().getImage("res/pieces/w_Queen.svg");
        w_Rook = Toolkit.getDefaultToolkit().getImage("res/pieces/w_Rook.svg");
        w_Bishop = Toolkit.getDefaultToolkit().getImage("res/pieces/w_Bishop.svg");
        w_Knight = Toolkit.getDefaultToolkit().getImage("res/pieces/w_Knight.svg");
        w_Pawn = Toolkit.getDefaultToolkit().getImage("res/pieces/w_Pawn.svg");

    }

    //getter/setter
    public Board getBoard(){
        return board;
    }
    public int getTurn(){
        return turn;
    }
    public int getSubTurn(){
        return subTurn;
    }

    /**
     * Disegna la scacchiera con tutti i pezzi posizionati
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //disegno delle lettere di riferimento
        g.setFont(drawFont);
        g.setColor(Color.BLACK);
        g.drawString("8", 20, 35);
        g.drawString("7", 20, 35 + 50*1);
        g.drawString("6", 20, 35 + 50*2);
        g.drawString("5", 20, 35 + 50*3);
        g.drawString("4", 20, 35 + 50*4);
        g.drawString("3", 20, 35 + 50*5);
        g.drawString("2", 20, 35 + 50*6);
        g.drawString("1", 20, 35 + 50*7);
        g.drawString("A", 15 + 50*1, 430);
        g.drawString("B", 15 + 50*2, 430);
        g.drawString("C", 15 + 50*3, 430);
        g.drawString("D", 15 + 50*4, 430);
        g.drawString("E", 15 + 50*5, 430);
        g.drawString("F", 15 + 50*6, 430);
        g.drawString("G", 15 + 50*7, 430);
        g.drawString("H", 15 + 50*8, 430);

        //scritte sotto la scacchiera
        /*
        if(turn == 1)
            g.drawString("Turno: bianco", 0, 450);
        else 
            g.drawString("Turno: nero", 0, 450);
        */
        //disegno della scacchiera
        for(int i = 0; i < Board.SIZE; i++){
            for(int j = 0; j < Board.SIZE; j++){
                //selezione del colore per la scacchiera
                if(subTurn == 2          &&
                   j == start.getFirst() &&
                   i == start.getSecond())
                    g2.setColor(Color.green);
                else if((i + j) %2 == 0)
                    g2.setColor(beige);
                else
                    g2.setColor(brown);
                g2.fillRect(50+ 50 *i, 50 *j, 50, 50);
            }
        }

        //disegno delle pedine
        for(int i = 0; i < Board.SIZE; i++)
            for(int j = 0; j < Board.SIZE; j++){
                try{
                    switch(board.getPiece(i, j).getPiece()){
                        case KING:
                            if(board.getPiece(i, j).getPlayer().getTurn() == 1)
                                g2.drawImage(w_King, 50 *j +55, 50 *i +5, 40, 40, this);
                            else
                                g2.drawImage(b_King, 50 *j +55, 50 *i +5, 40, 40, this);
                            break;
                        case QUEEN:
                            if(board.getPiece(i, j).getPlayer().getTurn() == 1)
                                g2.drawImage(w_Queen, 50 *j +55, 50 *i +5, 40, 40, this);
                            else
                                g2.drawImage(b_Queen, 50 *j +55, 50 *i +5, 40, 40, this);
                            break;
                        case BISHOP:
                            if(board.getPiece(i, j).getPlayer().getTurn() == 1)
                                g2.drawImage(w_Bishop, 50 *j +55, 50 *i +5, 40, 40, this);
                            else
                                g2.drawImage(b_Bishop, 50 *j +55, 50 *i +5, 40, 40, this);
                            break;
                        case ROOK:
                            if(board.getPiece(i, j).getPlayer().getTurn() == 1)
                                g2.drawImage(w_Rook, 50 *j +55, 50 *i +5, 40, 40, this);
                            else
                                g2.drawImage(b_Rook, 50 *j +55, 50 *i +5, 40, 40, this);
                            break;
                        case KNIGHT:
                            if(board.getPiece(i, j).getPlayer().getTurn() == 1)
                                g2.drawImage(w_Knight, 50 *j +55, 50 *i +5, 40, 40, this);
                            else
                                g2.drawImage(b_Knight, 50 *j +55, 50 *i +5, 40, 40, this);
                            break;
                        case PAWN:
                            if(board.getPiece(i, j).getPlayer().getTurn() == 1)
                                g2.drawImage(w_Pawn, 50 *j +55, 50 *i +5, 40, 40, this);
                            else
                                g2.drawImage(b_Pawn, 50 *j +55, 50 *i +5, 40, 40, this);
                            break;
                        default:
                            break;
                    }
                    setVisible(true);
                }
                catch(NullPointerException e){}
            }
      }
}