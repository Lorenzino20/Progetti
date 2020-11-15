public class Main {
    public static void main(String[] args) {
        Persona io = new Persona("Lorenzo", "D'Amico", 30102002);
        System.out.println(io.saluta());
        Personainglese me = new Personainglese(io);
        System.out.println(me.salutaInglese());
    }
}