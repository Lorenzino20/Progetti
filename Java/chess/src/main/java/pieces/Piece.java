package pieces;

import java.util.List;

import chess.*;

/**
 * Classe astratta che descrive una generica
 * pedina degli scacchi
 * @author Andrea
 * @version 1.3
 */
public abstract class Piece{
    //attributi
    //Private Player black or white
    protected PieceEnum piece;
    private Board board;
    private int iPosition;
    private int jPosition;
    private Player player;

    /**
     * Costruttore di base della classe astratta
     * @param piece Tipo di pezzo
     * @param board Scacchiera alla quale appartiene il pezzo
     */
    public Piece(Board board, Player player,
                 int iPosition, int jPosition){
        this.board = board;
        this.player = player;

        //iPosition e jPosition devono essere
        //compresi tra 0 e Board.SIZE -1
        if(iPosition >= 0 && iPosition < Board.SIZE)
            this.iPosition = iPosition;
        else
            this.iPosition = 0;
        if(jPosition >= 0 && jPosition < Board.SIZE)
            this.jPosition = jPosition;
        else
            this.jPosition = 0;
    }

    //getter/setter
    public PieceEnum getPiece(){
        return piece;
    }
    public Board getBoard(){
        return board;
    }
    public int getIPosition(){
        return iPosition;
    }
    public int getJPosition(){
        return jPosition;
    }
    public Player getPlayer(){
        return player;
    }

    public void setIPosition(int newPosition){
        if(newPosition >= 0 && newPosition < Board.SIZE)
            iPosition = newPosition;
    }
    public void setJPosition(int newPosition){
        if(newPosition >= 0 && newPosition < Board.SIZE)
            jPosition = newPosition;
    }

    /**
     * Muove il pezzo dalla posizione attuale a quella
     * passata come parametro
     * @param endI riga della posizione finale
     * @param endJ colonna della posizione finale
     */
    public void move(int endI, int endJ)
        throws InvalidMoveException{
        if(!isValid(endI, endJ))
            throw new InvalidMoveException();
        
        board.setPiece(this, endI, endJ);
        board.setPiece(null, iPosition, jPosition);
        setIPosition(endI);
        setJPosition(endJ);
    }

    /**
     * Verifica se la casella[i][j] non esca fuori
     * dal limite di boardMatrix
     * @param i riga della scacchiera
     * @param j colonna della scacchiera
     * @return verifica della validità della casella
     */
    public boolean validPosition(int i, int j){
        try{
            if(getBoard().getPiece(i, j)
                .getPlayer().getName()
                .equals(getPlayer().getName()))
                return false;
            if(i >= 0 && i < Board.SIZE &&
               j >= 0 && j < Board.SIZE)
                return true;

            return false;
        }
        catch(NullPointerException e){
            //significa che la casella è vuota
            if(i >= 0 && i < Board.SIZE &&
               j >= 0 && j < Board.SIZE)
                return true;
            return false;
        }
    }

    
    /**
     * Verifica se la pedina si può muovere in [endI][endj]
     * @param endI riga finale della scacchiera
     * @param endJ colonna finale della scacchiera
     * @return true se la mossa è valida, false altrimenti
     */
    public boolean isValid(int endI, int endJ){
        List <IntPair> moves = possibleMoves();
        
        //si cerca se le coordinate parametro corrispondono
        //ad una di quelle della lista
        for(int i = 0; i < moves.size(); i++)
            if(endI == moves.get(i).getFirst())
                if(endJ == moves.get(i).getSecond())
                    return true;
        
        return false;
    }

    //metodi astratti
    /**
     * restituisce una lista di tutte le mosse effettivamente
     * possibili
     * @return lista delle mosse possibili
     */
    public abstract List <IntPair> possibleMoves();
}