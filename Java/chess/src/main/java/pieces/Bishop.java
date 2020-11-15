package pieces;

import java.util.*;

import chess.*;

/**
 * Sottoclasse di Piece che implementa un'alfiere
 * @author Andrea
 * @version 1.1
 */
public class Bishop extends Piece{
    /**
     * Costruttore della classe Bishop che estende
     * il costruttore della superclasse Piece
     */
    public Bishop(Board board, Player player,
                int iPosition, int jPosition){
        super(board, player, iPosition, jPosition);
        piece = PieceEnum.BISHOP;
        board.setPiece(this, getIPosition(), getJPosition());
    }

    public List <IntPair> possibleMoves(){
        List <IntPair> moves = new ArrayList <IntPair>();

        //per non calcolare sempre get...Position
        int nowI = getIPosition();
        int nowJ = getJPosition();
        int i = nowI;
        int j = nowJ;

        //mosse verso sopra dx
        try{
            i = nowI -1; 
            j = nowJ +1;
            while(i >= 0){
                try{
                    if(getBoard().getPiece(i, j).getPlayer() !=
                       getPlayer())
                       moves.add(new IntPair(i, j));
                    break;
                }
                catch(NullPointerException e){
                    moves.add(new IntPair(i, j));
                }

                i--;
                j++;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){}
        
        //mosse verso sotto dx
        try{
            i = nowI +1;
            j = nowJ +1;
            while(j < Board.SIZE){
                try{
                    if(getBoard().getPiece(i, j).getPlayer() !=
                       getPlayer())
                       moves.add(new IntPair(i, j));
                    break;
                }
                catch(NullPointerException e){
                    moves.add(new IntPair(i, j));
                }

                i++;
                j++;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){}

        //mosse verso sotto sx
        try{
            i = nowI +1;
            j = nowJ -1;
            while(i < Board.SIZE){
                try{
                    if(getBoard().getPiece(i, j).getPlayer() !=
                       getPlayer())
                       moves.add(new IntPair(i, j));
                    break;
                }
                catch(NullPointerException e){
                    moves.add(new IntPair(i, j));
                }

                i++;
                j--;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){}

        //mosse verso sopra sx
        try{
            i = nowI -1;
            j = nowJ -1;
            while(j >= 0){
                try{
                    if(getBoard().getPiece(i, j).getPlayer() !=
                       getPlayer())
                       moves.add(new IntPair(i, j));
                    break;
                }
                catch(NullPointerException e){
                    moves.add(new IntPair(i, j));
                }

                i--;
                j--;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){}

        return moves;
    }
}
