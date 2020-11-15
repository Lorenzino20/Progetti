package pieces;

import chess.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BishopTest {

    @Test
    public void test() {
        Player p1 = new Player("White", 1);
        Player p2 = new Player("Black", 2);
        Board board = new Board(p1, p2, 1);
        Bishop test = new Bishop(board, p1, 4, 6);

        assertEquals(PieceEnum.BISHOP, test.getPiece());
        assertEquals(board, test.getBoard());
        assertEquals(4, test.getIPosition());
        assertEquals(6, test.getJPosition());

        //inserimento di una nuova pedina
        new Rook(board, p2, 5, 5);
        
        assertTrue(test.validPosition(7, 3));
        assertTrue(!test.isValid(7, 3));
    }
}
