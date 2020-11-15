package pieces;

import chess.*;
import java.util.*;
/**
 * Sottoclasse di Piece che implementa una regina
 * @author Andrea
 * @version 1.3
 */
public class Queen extends Piece{
    /**
     * Costruttore della classe Queen che estende
     * il costruttore della superclasse Piece
     */
    public Queen(Board board, Player player,
                int iPosition, int jPosition){
        super(board, player, iPosition, jPosition);
        piece = PieceEnum.QUEEN;
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
