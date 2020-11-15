import javax.naming.spi.DirStateFactory.Result;

public class Piece {
    private int x;
    private int y;
    private int[][] coords;
    protected enum Tetrominoe {
        NoShape, ZShape, SShape, LineShape,
        TShape, SquareShape, LShape, MirroredLShape
    }
    private Tetrominoe pieceShape;
    public void setPiece(Tetrominoe piece) {
        int[][][] coordsTable = new int[][][]{
            {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
            {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
            {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
            {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
            {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
            {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
            {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
    };
    for (int i = 0; i < 4; i++) {

        System.arraycopy(coordsTable[piece.ordinal()], 0, coords, 0, 4);
    }
    pieceShape = piece;
    }

    public Piece() {
        coords = new int[4][2];
        setPiece(Tetrominoe.NoShape);
    }

    public void setX(int x) {
        this.x = x;
    } 
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    int x(int index) {
        return coords[index][0];
    }

    int y(int index) {
        return coords[index][1];
    }
}