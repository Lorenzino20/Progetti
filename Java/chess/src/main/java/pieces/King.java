package pieces;

import chess.*;
import java.util.*;
/**
 * Sottoclasse di Piece che implementa un re
 * @author Andrea
 * @version 1.0
 */
public class King extends Piece{
    /**
     * Costruttore della classe Queen che estende
     * il costruttore della superclasse Piece
     */
    public King(Board board, Player player,
                int iPosition, int jPosition){
        super(board, player, iPosition, jPosition);
        piece = PieceEnum.KING;
        board.setPiece(this, getIPosition(), getJPosition());
    }

    public List <IntPair> possibleMoves(){
        List <IntPair> moves = new ArrayList <IntPair>();

        //per non calcolare sempre get...Position
        int nowI = getIPosition();
        int nowJ = getJPosition();

        //un doppio for valuta tutte le caselle adiacenti al re
        for(int i = nowI -1; i < nowI +2; i++)
            for(int j = nowJ -1; j < nowJ +2; j++){
                if(i >= 0 && i < Board.SIZE &&
                   j >= 0 && j < Board.SIZE)
                    if(getBoard().getPiece(i, j) == null)
                        moves.add(new IntPair(i, j));
                    else
                        if(getBoard().getPiece(i, j).getPlayer() !=
                           getPlayer())
                            moves.add(new IntPair(i, j));
            }
        
        return moves;
    }
}
