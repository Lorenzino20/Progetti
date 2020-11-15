package pieces;

/**
 * Eccezione generata se la mossa da effettuare
 * non è valida (causa uno scacco al proprio re,
 * la posizione finale non è raggiungibile)
 */
public class InvalidMoveException extends Exception{
    private static final long serialVersionUID = 1L;
}