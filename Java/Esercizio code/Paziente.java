public class Paziente {
    private String nome;
    private String cognome;
    
    public Paziente (String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
    
    public String toString() {
        return nome+" "+cognome;
    }
}