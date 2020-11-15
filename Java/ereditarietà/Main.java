public class Main {
    public static void main(String[] args) {
        PuntoOrientato po1 = new PuntoOrientato();
        PuntoOrientato po2 = new PuntoOrientato();
        PuntoOrientato po3 = new PuntoOrientato();

        try {
            po1 = new PuntoOrientato(1.,1.,'D');
            po2 = new PuntoOrientato(2.,1.,'A');
            po3 = new PuntoOrientato(po1);
        } catch (Exception exception) {
            System.out.println("Errore !");
        }

        System.out.println("PO1 = "+po1.toString());
        System.out.println("PO2 = "+po2.toString());
        System.out.println("PO3 = "+po3.toString());
        System.out.println("Distanza PO1-PO2: "+po1.distanza(po2));
        System.out.println("Distanza PO1-PO3: "+po1.distanza(po3));

        if(po1.equals(po3))
        System.out.println("PO1 e PO3 coincidono");
        else
        System.out.println("PO1 e PO2 coincidono");
        po1.ruotaSinistra();
        System.out.println("PO1 = "+po1.toString());
        po1.sposta(10.0);
        System.out.println("PO1 = "+po1.toString());
    }
}