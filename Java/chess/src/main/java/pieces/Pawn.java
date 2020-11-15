package pieces;

import java.util.*;

import chess.*;

/**
 * Sottoclasse di Piece che implementa un pedone
 * 
 * @author Andrea
 * @version 1.0
 */
public class Pawn extends Piece {
    /**
     * Costruttore della classe Bishop che estende il costruttore della superclasse
     * Piece
     */
    public Pawn(Board board, Player player, int iPosition, int jPosition) {
        super(board, player, iPosition, jPosition);
        piece = PieceEnum.PAWN;
        board.setPiece(this, getIPosition(), getJPosition());
    }

    public List <IntPair> possibleMoves() {
        List <IntPair> moves = new ArrayList <IntPair>();
        int nowI = getIPosition();
        int nowJ = getJPosition();

        if(getPlayer().getTurn() == 1){     //turno del bianco
            //movimento davanti
            try{
                if(getBoard().getPiece(nowI -1, nowJ) == null){
                    moves.add(new IntPair(nowI -1, nowJ));
                    if(getBoard().getPiece(nowI -2, nowJ) == null)
                        moves.add(new IntPair(nowI -2, nowJ));
                }
            }
            catch(ArrayIndexOutOfBoundsException e){}

            //movimenti laterali
            try{
            if(getBoard().getPiece(nowI -1, nowJ -1).getPlayer().getTurn() != 1)
                moves.add(new IntPair(nowI -1, nowJ -1));
            }
            catch(Exception e){}
            try{
                if(getBoard().getPiece(nowI -1, nowJ +1).getPlayer().getTurn() != 1)
                    moves.add(new IntPair(nowI -1, nowJ +1));
            }
                catch(Exception e){}
        }
        else{       //turno del nero
            //movimento davanti
            try{
                if(getBoard().getPiece(nowI +1, nowJ) == null){
                    moves.add(new IntPair(nowI +1, nowJ));
                    if(getBoard().getPiece(nowI +2, nowJ) == null)
                        moves.add(new IntPair(nowI +2, nowJ));
                }
            }
            catch(ArrayIndexOutOfBoundsException e){}

            //movimenti laterali
            try{
                if(getBoard().getPiece(nowI +1, nowJ -1).getPlayer().getTurn() != 2)
                    moves.add(new IntPair(nowI +1, nowJ -1));
            }
            catch(Exception e){}
            try{
                if(getBoard().getPiece(nowI +1, nowJ +1).getPlayer().getTurn() != 2)
                    moves.add(new IntPair(nowI +1, nowJ +1));
            }
                catch(Exception e){}
        }

        return moves;
    }
}
