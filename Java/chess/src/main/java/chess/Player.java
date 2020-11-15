package chess;

/**
 * Implementa un giocatore di una partita di scacchi
 * @author Andrea
 * @version 1.0
 */
public class Player{
    //attributi
    private String name;
    private int turn;   //1 or 2

    public Player(String name, int turn){
        this.name = name;
        if(turn == 1 || turn == 2)
            this.turn = turn;
        else
            turn = 0;
    }

    //getter/setter
    public String getName(){
        return name;
    }
    public int getTurn(){
        return turn;
    }
}