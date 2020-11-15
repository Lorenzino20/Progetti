public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {return this.x;}
    public void setX(double x) {this.x = x;}
    public double getY() {return this.y;}
    public void setY(double y) {this.y = y;}

    public double distanza(Punto p) {
        double d = Math.sqrt((Math.pow((getX()-p.getX()), 2))+(Math.pow((getY()-p.getY()), 2)));
        return d;
    }
    public String toString() {
        return "("+x+";"+y+")";
    }
}