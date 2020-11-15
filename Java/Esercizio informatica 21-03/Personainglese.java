public class Personainglese extends Persona {
    public Personainglese(Persona persona) {
        super(persona);
    }

    public String salutaInglese() {
        return "Hello i'm "+this.getNome()+" "+this.getCognome();
    }
}