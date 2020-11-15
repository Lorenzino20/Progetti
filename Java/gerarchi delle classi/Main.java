public class Main {
    public static void main(String[] args) {
        Carrello carrello = new Carrello();

        Abbigliamento abbligliamento1 = new Abbigliamento("PU01", 50.00, 'M', "XL", "Pantaloni");

        Abbigliamento abbligliamento2 = new Abbigliamento("CD22", 35.00, 'F', "XS", "Camicia");

        Abbigliamento abbligliamento3 = new Abbigliamento("GD46", 29.00, 'F', "S", "Giacca");

        Freschi freschi1 = new Freschi("OR044", 1.50, "Peperoni", 1.4, 170, true);

        Freschi freschi2 = new Freschi("FR012", 1.90, "Mele", 0.5, 730, false);

        Conservati conservati = new Conservati("BS003", 2.00, "Biscotti", 0.37, 1200, "Buoni e belli");

        carrello.inserisciProdotto(abbligliamento1);
        carrello.inserisciProdotto(abbligliamento2);
        carrello.inserisciProdotto(abbligliamento3);
        carrello.inserisciProdotto(freschi1);
        carrello.inserisciProdotto(freschi2);
        carrello.inserisciProdotto(conservati);

        Merce prodotti[] = carrello.esportaContenuto();
        for(int i = 0; i < prodotti.length; i++)
        System.out.println(prodotti[i]);

        System.out.println("Spesa totale: "+carrello.calcolaPrezzoTotale());
        System.out.println("Calorie totali:"+carrello.calcolaCalorieTotali());
    }
}