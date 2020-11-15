public class Carrello {
    private final int MAX_OGGETTI = 100;
    private int oggetti;
    private Merce[] contenutoCarrello;

    public Carrello() {
        contenutoCarrello = new Merce [MAX_OGGETTI];
        oggetti = 0;
    }

    public void inserisciProdotto(Merce prodotto) {
        if(oggetti < MAX_OGGETTI) {
            contenutoCarrello[oggetti] = prodotto.clone();
            oggetti++;
        }
    }

    public double calcolaPrezzoTotale() {
        double prezzoTotale = 0;

        for(int i = 0; i < oggetti; i++) 
            prezzoTotale += contenutoCarrello[i].calcolaImporto();
        return prezzoTotale;
    }

    public double calcolaCalorieTotali() {
        double calorieTotali = 0;

        for(int i = 0; i < oggetti; i++) 
            if(contenutoCarrello[i] instanceof Alimentari) 
            calorieTotali += ((Alimentari)contenutoCarrello[i]).calcolaCalorie();
        return calorieTotali;
    }

    public Merce[] esportaContenuto() {
        Merce prodotti[] = new Merce[oggetti];
        for(int i = 0; i < oggetti; i++)
            prodotti[i] = contenutoCarrello[i].clone();

        return prodotti;
    }
}