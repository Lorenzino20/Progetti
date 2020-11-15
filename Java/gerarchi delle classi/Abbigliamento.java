public class Abbigliamento extends Merce {
    private static double scontoDonna = 10.0;
    private static double scontoUomo = 5.0;
    private char sesso;
    private String taglia;
    private String tipologia;

    public Abbigliamento(String codice, double prezzo, char sesso, String taglia, String tipologia) {
        super(codice, prezzo);
        this.sesso = sesso;
        this.taglia = taglia;
        this.tipologia = tipologia;
    } 

    static public double getScontoDonna() {return scontoDonna;}
    static public void setScontoDonna(double percentuale) {scontoDonna = percentuale;}
    static public double setScontoUomo() {return scontoUomo;}
    static public void setScontoUomo(double percentuale) {scontoUomo = percentuale;}
    public void setSesso(char sesso) {this.sesso = sesso;}
    public char getSesso() {return this.sesso;}
    public void setTaglia(String taglia) {this.taglia = taglia;}
    public String getTaglia() {return this.taglia;}
    public void setTipologia(String tipologia) {this.tipologia = tipologia;}
    public String getTipologia() {return this.tipologia;}
    public double calcolaImporto() {
        if(sesso == 'F')
            return prezzoUnitario-prezzoUnitario*scontoDonna/100.0;
        if(sesso == 'M')
            return prezzoUnitario-prezzoUnitario*scontoUomo/100.0;
        return prezzoUnitario;
    }

    public String toString() {
        return super.toString()+" Tipologia: "+tipologia+" Sesso: "+sesso+" Taglia: "+taglia+" Prezzo: "+calcolaImporto();
    }

    public Abbigliamento clone() {
        Abbigliamento prodotto = new Abbigliamento(super.getCodice(), super.prezzoUnitario, this.sesso, this.taglia, this.tipologia);
        return prodotto;
    }
}