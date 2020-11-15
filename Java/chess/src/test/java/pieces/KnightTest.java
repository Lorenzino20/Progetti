package pieces;

import chess.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTest {

    @Test
    public void test() {
        Player p1 = new Player("White", 1);
        Player p2 = new Player("Black", 2);
        Board board = new Board(p1, p2, 1);
        Knight test = new Knight(board, p1, 4, 6);

        assertEquals(PieceEnum.KNIGHT, test.getPiece());
        assertEquals(board, test.getBoard());
        assertEquals(4, test.getIPosition());
        assertEquals(6, test.getJPosition());

        //inserimento di una nuova pedina
        new Rook(board, p1, 2, 5);
        new Rook(board, p2, 5, 4);
        
        assertTrue(test.validPosition(7, 3));
        assertTrue(!test.isValid(2, 5));
        assertTrue(test.isValid(5, 4));
        assertTrue(!test.isValid(3, 8));
        assertTrue(test.isValid(6, 7));
        assertTrue(!test.isValid(2, 2));
    }
}
