public class Conservati extends Alimentari {
    private String marca;

    public Conservati(String codice, double prezzo, String descrizione, double peso, double calorie, String marca) {
        super(codice, prezzo, descrizione, peso, calorie);
        this.marca = marca;
    }

    public void setMarca(String marca) {this.marca = marca;}
    public String getMarca() {return marca;}
    public String toString() {
        return super.toString()+" Marca: "+marca;
    }

    public Conservati clone() {
        Conservati prodotto = new Conservati(super.getCodice(),super.prezzoUnitario,super.getDescrizione(),super.getPeso(),super.getCalorieUnitarie(),this.marca);
        return prodotto;
    }
}