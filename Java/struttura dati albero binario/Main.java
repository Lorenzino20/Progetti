public class Main {
    public static void main(String[] args) {
        Albero a = new Albero();
        a.aggiungiFoglio('a', 'a');
        a.aggiungiFoglio('a', 'b');
        a.aggiungiFoglio('a', 'd');
        a.aggiungiFoglio('b', 'e');
        a.aggiungiFoglio('b', 'g');
        a.aggiungiFoglio('g', 'f');
        a.aggiungiFoglio('d', 'l');
        a.aggiungiFoglio('d', 'c');
        a.aggiungiFoglio('c', 'h');
        a.aggiungiFoglio('c', 'i');

        a.visitaAnticipata();
        System.out.println("");
        a.visitaDifferita();
    }
}