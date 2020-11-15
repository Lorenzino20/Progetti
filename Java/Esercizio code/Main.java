public class Main
{
	public static void main(String[] args) {
        Coda prelievi = new Coda();
        Lista effettuati = new Lista();
        Paziente pz1 = new Paziente("Giovanni","Bianchi");
        Paziente pz2 = new Paziente("Marta","Rossi");
        
        prelievi.inserisciInCoda(pz1); //paziente pz1 si mette in coda per il prelievo

        effettuati.aggiungi(prelievi); //paziente pz1 effettua il prelievo e va a casa

        prelievi.inserisciInCoda(pz2); //paziente pz2 si mette in coda per il prelievo
        
        prelievi.eliminaDallaCoda(); //paziente pz2 ha paura e torna a casa senza aver effettuato il prelievo

        prelievi.Visualizza(); //visualizzazione di chi è in coda
        
        effettuati.Visualizza(); //visualizzazione di chi ha gia effettuato il prelievo
	}
}