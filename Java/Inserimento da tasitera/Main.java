import java.io.*;
public class Main {
    public static void main(String[] args) {
        ConsoleInput tastiera = new ConsoleInput();
        int centesimi = 0;
        double euro = 0.0;
        String chi = "";
        Double totale = 0.0;

        //inserimento da tastiera di un numero intero
        System.out.println("Quanti soldi hai?");
        try {
            centesimi = tastiera.readInt();
        }
        catch (java.io.IOException exception) {
            System.out.println("Valore non corretto. Reinseriscilo!");
        }
        catch (NumberFormatException exception) {
            System.out.println("Valore non corretto. Reinseriscilo!");
        }

        //inserimento da tastiera di un numero con la virgola
        System.out.println("Supponiamo di avere 75 centesimi di euro, quanti euro sono?");
        try {
            euro = tastiera.readDuoble();
        }
        catch (java.io.IOException exception) {
            System.out.println("Valore non corretto. Reinseriscilo!");
        }
        catch (NumberFormatException exception) {
            System.out.println("Valore non corretto. Reinseriscilo!");
        } 

        //inserimento da tastiera di una Stringa
        System.out.println("A chi devi questi soldi");
        try {
            chi = tastiera.readLine();
        }
        catch (java.io.IOException exception) {
        }

        totale = centesimi*0.01+euro;
        System.out.println("Devi "+totale+" a "+chi);
    }
}