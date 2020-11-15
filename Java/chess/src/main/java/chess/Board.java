package chess;

import pieces.*;
import java.util.*;

/**
 * Implementa una scacchiera con le relative pedine
 * @author Andrea
 * @version 1.7
 */
public class Board{
    //attributi
    public static final int SIZE = 8;
    private Piece[][] boardMatrix;
    private Player p1;
    private Player p2;
    private King whiteKing;
    private King blackKing;

    /**
     * Costruttore di default che inizializza
     * la scacchiera con i vari pezzi nella
     * nella coinfigurazione iniziale
     */
    public Board(Player p1, Player p2){
        boardMatrix = new Piece[SIZE][SIZE];
        this.p1 = p1;
        this.p2 = p2;

        //INCOMPLETO:
        //posizionare i vari pezzi
        new Rook(this, p1, 7, 0);
        new Rook(this, p1, 7, 7);
        new Bishop(this, p1, 7, 2);
        new Bishop(this, p1, 7, 5);
        new Knight(this, p1, 7, 1);
        new Knight(this, p1, 7, 6);
        new Queen(this, p1, 7, 3);
        whiteKing = new King(this, p1, 7, 4);
        for(int i = 0; i < Board.SIZE; i++)
            new Pawn(this, p1, 6, i);

        new Rook(this, p2, 0, 0);
        new Rook(this, p2, 0, 7);
        new Bishop(this, p2, 0, 2);
        new Bishop(this, p2, 0, 5);
        new Knight(this, p2, 0, 1);
        new Knight(this, p2, 0, 6);
        new Queen(this, p2, 0, 3);
        blackKing = new King(this, p2, 0, 4);
        for(int i = 0; i < Board.SIZE; i++)
            new Pawn(this, p2, 1, i);
    }

    /**
     * Costruttore utilizzato nei test dei pezzi
     */
    public Board(Player p1, Player p2, int test){
        boardMatrix = new Piece[SIZE][SIZE];
        this.p1 = p1;
        this.p2 = p2;
    }

    //getter/setter
    public Player getP1(){
        return p1;
    }
    public Player getP2(){
        return p2;
    }
    public King getWhiteKing(){
        return whiteKing;
    }
    public King getBlackKing(){
        return blackKing;
    }
    /**
     * Restituisce una lista con tutti i pezzi bianchi
     * @return lista dei pezzi bianchi
     */
    public List <Piece> getWhitePieces(){
        List <Piece> whitePieces = new ArrayList <Piece>();

        //guarda in tutta la board i pezzi bianchi rimasti
        for(int i = 0; i < SIZE; i++)
            for(int j = 0; j < SIZE; j++)
                if(getPiece(i, j) != null)
                    if(getPiece(i, j).getPlayer().getTurn() == 1)
                        whitePieces.add(getPiece(i, j));
        
        return whitePieces;
    }
    /**
     * Restituisce una lista con tutti i pezzi bianchi
     * @return lista dei pezzi bianchi
     */
    public List <Piece> getBlackPieces(){
        List <Piece> blackPieces = new ArrayList <Piece>();

        //guarda in tutta la board i pezzi bianchi rimasti
        for(int i = 0; i < SIZE; i++)
            for(int j = 0; j < SIZE; j++)
                if(getPiece(i, j) != null)
                    if(getPiece(i, j).getPlayer().getTurn() == 2)
                        blackPieces.add(getPiece(i, j));
        
        return blackPieces;
    }

    /**
     * Restituisce il pezzo alla posizione [i][j]
     * @param i riga della scacchiera
     * @param j colonna della scacchiera
     * @return pedina in [i][j]
     */
    public Piece getPiece(int i, int j){
        try{
            return boardMatrix[i][j];
        }
        catch(ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
    
    /**
     * Imposta in [i][j] il pezzo passato come parametro
     * @param piece pedina da inserire
     * @param i riga della scacchiera
     * @param j colonna della scacchiera
     */
    public void setPiece(Piece piece, int i, int j){
        try{
            boardMatrix[i][j] = piece;
        }
        catch(ArrayIndexOutOfBoundsException e){
            return;
        }
    }
    
    /**
     * Restituisce una stringa che rappresenta la scacchiera
     */
    @Override
    public String toString(){
        String string = "";
        
        for(int i = 0; i < SIZE; i++){
            string += "|";
            for(int j = 0; j < SIZE; j++){
                try{
                    switch(getPiece(i, j).getPiece()){
                        case KING:
                            if(getPiece(i, j).getPlayer().getTurn() == 1)
                                string += "k ";
                            else
                                string += "K ";
                            break;
                        case QUEEN:
                            if(getPiece(i, j).getPlayer().getTurn() == 1)
                                string += "q ";
                            else
                                string += "Q ";
                            break;
                        case BISHOP:
                            if(getPiece(i, j).getPlayer().getTurn() == 1)
                                string += "b ";
                            else
                                string += "B ";
                            break;
                        case ROOK:
                            if(getPiece(i, j).getPlayer().getTurn() == 1)
                                string += "r ";
                            else
                                string += "R ";
                            break;
                        case KNIGHT:
                            if(getPiece(i, j).getPlayer().getTurn() == 1)
                                string += "h ";
                            else
                                string += "H ";
                            break;
                        case PAWN:
                            if(getPiece(i, j).getPlayer().getTurn() == 1)
                                string += "p ";
                            else
                                string += "P ";
                            break;
                        default:
                            string += "  ";
                            break;
                    }
                }
                catch(NullPointerException e){
                    string += "  ";
                }
            }
            string += "|\n";
        }
        return string;
    }

    /**
     * Restituisce 1 se il re bianco è sotto scacco,
     *             2 se il re nero è sotto scacco,
     * -1 altrimenti
     * 
     * @return turno del giocatore sotto scacco
     */
    public int check(){
        List <IntPair> allMoves = new ArrayList <IntPair>();

        //aggiunta di tutte le mosse in allMoves
        for(int i = 0; i < SIZE; i++)
            for(int j = 0; j < SIZE; j++) 
                if(getPiece(i, j) != null)      //se il pezzo esiste
                    allMoves.addAll(getPiece(i, j).possibleMoves());
        
        //ricerca in allMoves delle coordinate del re
        for(int i = 0; i < allMoves.size(); i++){
            if(allMoves.get(i).getFirst() == getWhiteKing().getIPosition() &&
               allMoves.get(i).getSecond() == getWhiteKing().getJPosition())
                return 1;
            else
                if(allMoves.get(i).getFirst() == getBlackKing().getIPosition() &&
                   allMoves.get(i).getSecond() == getBlackKing().getJPosition())
                return 2;
        }
        return -1;
    }
}
