public class Nodo {
    Paziente info;
    Nodo link;
    
    public Nodo(Paziente paziente) {
        this.info = paziente;
        this.link = null;
    }
}