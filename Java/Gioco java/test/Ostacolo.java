package test;

public class Ostacolo {

    private int[] x0;
    private int[] y0;
    private int[] x1;
    private int[] y1;
    private int[] casuale;
    private static final int DIMENZIONE = 20;

    public Ostacolo() {
        x0 = new int[100];
        y0 = new int[100];
        x1 = new int[100];
        y1 = new int[100];
        for(int i = 0; i < x0.length; i++) {
            x0[i] = i*100;
            y0[i] = 0;
            x1[i] = i*100;
        }
        /* x0 = 181;
        y0 = 0;
        x1 = 181;
        casuale = (int)(Math.random()*160); */
    }

    public int[] getX0() {
        return x0;
    }

    public int[] getY0() {
        return y0;
    }

    public void setX0(int[] x0) {
        this.x0 = x0;
    }

    public void setY0(int[] y0) {
        this.y0 = y0;
    }

    public int[] getX1() {
        return x1;
    }

    public int[] getY1() {
        return y1;
    }

    public void setX1(int[] x1) {
        this.x1 = x1;
    }

    public void setY1(int[] y1) {
        this.y1 = y1;
    }

    public int getDimenzione() {
        return DIMENZIONE;
    }

    public int[] getCasuale() {
        return casuale;
    }

    public void setCasuale() {
        for(int i = 0; i < casuale.length; i++)
        casuale[i] = (int)(Math.random()*160);
    }
}