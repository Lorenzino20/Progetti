package pieces;

import java.util.*;

import chess.*;

/**
 * Sottoclasse di Piece che implementa una torre
 * @author Andrea
 * @version 1.2
 */
public class Rook extends Piece{
    /**
     * Costruttore della classe Rook che estende
     * il costruttore della superclasse Piece
     */
    public Rook(Board board, Player player,
                int iPosition, int jPosition){
        super(board, player, iPosition, jPosition);
        piece = PieceEnum.ROOK;
        board.setPiece(this, getIPosition(), getJPosition());
    }

    public List <IntPair> possibleMoves(){
        List <IntPair> moves = new ArrayList <IntPair>();

        //per non calcolare sempre get...Position
        int nowI = getIPosition();
        int nowJ = getJPosition();
        int i = nowI;
        int j = nowJ;

        //mosse verso sopra
        try{
            i--;
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
            }
        }
        catch(ArrayIndexOutOfBoundsException e){}
        
        //mosse verso destra
        try{
            i = nowI;
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

                j++;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){}

        //mosse verso sotto
        try{
            i = nowI +1;
            j = nowJ;
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
            }
        }
        catch(ArrayIndexOutOfBoundsException e){}

        //mosse verso destra
        try{
            i = nowI;
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

                j--;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){}

        return moves;
    }
}
