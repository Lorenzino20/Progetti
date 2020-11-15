package pieces;

import chess.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {

    @Test
    public void test() {
        Player p1 = new Player("White", 1);
        Player p2 = new Player("Black", 2);
        Board board = new Board(p1, p2, 1);
        Queen test = new Queen(board, p1, 4, 6);

        assertEquals(PieceEnum.QUEEN, test.getPiece());
        assertEquals(board, test.getBoard());
        assertEquals(4, test.getIPosition());
        assertEquals(6, test.getJPosition());

        //inserimento di una nuova pedina
        new Rook(board, p1, 2, 5);
        new Rook(board, p2, 5, 4);
        
        assertTrue(test.isValid(2, 6));
        assertTrue(!test.isValid(3, 8));

    }
}
