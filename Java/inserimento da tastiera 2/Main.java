
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int centesimi = 0;
        double euro = 0.0;
        String chi = "";

        Scanner tastiera = new Scanner(System.in);

        System.out.println("Quanti soldi hai?");
        try {
            centesimi = tastiera.nextInt();
        }
        catch (NumberFormatException exception) {
            System.out.println("Errore di inserimento");
        }

        System.out.println("Quanti soldi sono in euro?");
        try {
            euro = tastiera.nextDouble();
        }
        catch (NumberFormatException exception) {
            System.out.println("Errore di inserimento");
        }

        Scanner tastiera1 = new Scanner(System.in);

        System.out.println("A chi devi questi soldi?");
        chi = tastiera1.nextLine();

        System.out.println("Devi a "+chi+" in euro"+euro);
    }
}