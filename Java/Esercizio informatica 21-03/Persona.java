public class Persona {
    private String nome;
    private String cognome;
    private int annoDiNascita;

    public Persona(String nome, String cognome, int annoDiNascita) {
        setNome(nome);
        setCognome(cognome);
        setAnnoDiNascita(annoDiNascita);
    }

    public Persona(Persona persona) {
        setNome(persona.getNome());
        setCognome(persona.getCognome());
        setAnnoDiNascita(persona.getAnnoDiNascita());
    }

    public void setNome(String nome) {this.nome = nome;}
    public String getNome() {return nome;}
    public void setCognome(String cognome) {this.cognome = cognome;}
    public String getCognome() {return cognome;}
    public void setAnnoDiNascita(int anno) {this.annoDiNascita = anno;}
    public int getAnnoDiNascita() {return annoDiNascita;}

    public String saluta() {
        return "Ciao sono "+nome+" "+cognome;
    }
}