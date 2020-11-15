abstract public class Alimentari extends Merce {
    private String descrizione;
    protected double peso;
    private double calorieUnitarie;

    public Alimentari(String codice, double prezzo, String descrizione, double peso, double calorie) {
        super(codice, prezzo);
        this.descrizione = descrizione;
        this.peso = peso;
        this.calorieUnitarie = calorie;
    }

    public void setDescrizione(String descrizione) {this.descrizione = descrizione;}
    public void setPeso(double peso) {this.peso = peso;}
    public void setCalorieUnitarie(double calorie) {this.calorieUnitarie = calorie;}
    public String getDescrizione() {return descrizione;}
    public double getPeso() {return peso;}
    public double getCalorieUnitarie() {return calorieUnitarie;}
    public double calcolaCalorie() {return peso*calorieUnitarie;}
    public double calcolaImporto() {return super.prezzoUnitario;}
    public String toString() {
        return super.toString()+" Descrizione: "+descrizione+" Peso: "+peso+" Importo: "+calcolaImporto()+" Calorie: "+calcolaCalorie();
    }
}