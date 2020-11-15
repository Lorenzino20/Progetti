package pieces;

import chess.*;
import java.util.*;
/**
 * Sottoclasse di Piece che implementa un cavallo
 * @author Andrea
 * @version 1.0
 */
public class Knight extends Piece{
    /**
     * Costruttore della classe Bishop che estende
     * il costruttore della superclasse Piece
     */
    public Knight(Board board, Player player,
                int iPosition, int jPosition){
        super(board, player, iPosition, jPosition);
        piece = PieceEnum.KNIGHT;
        board.setPiece(this, getIPosition(), getJPosition());
    }

    public List <IntPair> possibleMoves() {
        int nowI = getIPosition();
        int nowJ = getJPosition();
        
        List <IntPair> moves = new ArrayList <IntPair>();
        int[] aI = {nowI -2, nowI -1, nowI +1, nowI +2,
                    nowI +2, nowI +1, nowI -1, nowI -2};
        int[] aJ = {nowJ +1, nowJ +2, nowJ +2, nowJ +1,
                    nowJ -1, nowJ -2, nowJ -2, nowJ -1};
        
        //a moves vengono aggiunte SOLO le posizioni raggiungibili
        for(int i = 0; i < 8; i++){
            try{
                if(getBoard().getPiece(aI[i], aJ[i]).getPlayer() != getPlayer())
                    moves.add(new IntPair(aI[i], aJ[i]));
            }
            catch(ArrayIndexOutOfBoundsException e){}
            catch(NullPointerException e){
                moves.add(new IntPair(aI[i], aJ[i]));
            }
        }

        return moves;
    }
}
