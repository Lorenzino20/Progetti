package pieces;

import chess.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class KingTest {

    @Test
    public void test() {
        Player p1 = new Player("White", 1);
        Player p2 = new Player("Black", 2);
        Board board = new Board(p1, p2, 1);
        King test = new King(board, p1, 4, 4);

        assertEquals(PieceEnum.KING, test.getPiece());
        assertEquals(board, test.getBoard());
        assertEquals(4, test.getIPosition());
        assertEquals(4, test.getJPosition());

        //inserimento di una nuova pedina
        new Rook(board, p2, 3, 4);
        new Rook(board, p1, 5, 4);
        
        assertTrue(test.isValid(3, 4));
        assertTrue(!test.isValid(5, 4));
        assertTrue(!test.isValid(6, 6));

    }
}
