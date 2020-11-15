package pieces;

import chess.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {

    @Test
    public void test() {
        Player p1 = new Player("White", 1);
        Player p2 = new Player("Black", 2);
        Board board = new Board(p1, p2, 1);
        Pawn test = new Pawn(board, p1, 4, 6);

        assertEquals(PieceEnum.PAWN, test.getPiece());
        assertEquals(board, test.getBoard());
        assertEquals(4, test.getIPosition());
        assertEquals(6, test.getJPosition());

        //inserimento di una nuova pedina
        Rook rook = new Rook(board, p2, 3, 6);
        
        assertTrue(test.validPosition(2, 6));
        assertTrue(!test.isValid(3, 6));

        try{
            rook.move(3, 5);
        }
        catch(Exception e){}
        assertTrue(test.isValid(3,6));
        assertTrue(test.isValid(3,5));
    }
}
