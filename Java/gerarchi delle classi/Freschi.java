public class Freschi extends Alimentari {
    static private double costoSacchetto = 0.05;
    private boolean confezionamento;

    public Freschi(String codice, double prezzo, String descrizione, double peso, double calorie, boolean confezionamento) {
        super(codice, prezzo, descrizione, peso, calorie);
        this.confezionamento = confezionamento;
    }

    static public double getCostoSacchetto() {return costoSacchetto;}
    static public void setCostoSacchetto(double costo) {costoSacchetto = costo;}
    public void setConfezionamento(boolean confezionamento) {this.confezionamento = confezionamento;}
    public boolean getConfezionamento() {return confezionamento;}
    public String toString() {
        String tipoConfezione;

        if(!confezionamento)
            tipoConfezione = "sfusa";
        else
            tipoConfezione = "preconfezionata";
        return super.toString()+" Confezione: "+tipoConfezione;
    }
    public double calcolaImporto() {
        double importo = super.calcolaImporto();

        if(!confezionamento)
            importo += costoSacchetto;
        return importo;
    }

    public Freschi clone() {
        Freschi prodotto = new Freschi(super.getCodice(),super.prezzoUnitario,super.getDescrizione(),super.getPeso(),super.getCalorieUnitarie(),this.confezionamento);
        return prodotto;
    }
}