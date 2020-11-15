package pieces;

/**
 * Implementa un pair di interi che rappresentano
 * le coordinate di una casella della scacchiera
 * @author Andrea
 * @version 1.0
 */
public class IntPair{
    private int first;
    private int second;

    /**
     * Costruttore di default; inizializza
     * entrambi i valori a 0
     */
    public IntPair(){
        first = 0;
        second = 0;
    }

    /**
     * Costruttore che inizializza i valori di first
     * e second con quelli parametro
     * @param first primo valore del pair
     * @param second secondo valore del pair
     */
    public IntPair(int first, int second){
        this.first = first;
        this.second = second;
    }

    //getter/setter
    public int getFirst(){
        return first;
    }
    public int getSecond(){
        return second;
    }
    public void setFirst(int first){
        this.first = first;
    }
    public void setSecond(int second){
        this.second = second;
    }
}