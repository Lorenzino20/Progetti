package Gioco;

public class Pennuto {
    
    private int x;
    private int y;

    public Pennuto() {
        x = 64;
        y = 30;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        if(y >= 0 && y < 200)
        this.y = y;
    }
}


