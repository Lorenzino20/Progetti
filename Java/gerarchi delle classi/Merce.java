abstract public class Merce {
    private String codice;
    protected double prezzoUnitario;

    public Merce(String codice, double prezzo) {
        this.codice = codice;
        this.prezzoUnitario = prezzo;
    }

    public double getPrezzoUnitario() {return this.prezzoUnitario;}
    public String getCodice() {return codice;}
    public void setPrezzoUnitario(double prezzo) {this.prezzoUnitario = prezzo;}
    public void settCodice(String codice) {this.codice = codice;}
    abstract public double calcolaImporto();
    abstract public Merce clone();

    public String toString() {
        return "Codice: "+codice+" Prezzo unitario: "+prezzoUnitario;
    }
}