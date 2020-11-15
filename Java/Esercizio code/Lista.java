public class Lista {
    Nodo head = null;

    public Lista() {}

    public Nodo creaNodo(Paziente persona, Nodo link) {
        Nodo p = new Nodo(persona);
        p.link = link;
        return p;
    }

    public void aggiungi (Coda coda) {
        Nodo p = coda.head;
        p.link = null;
        coda.eliminaDallaCoda();
        if(head == null) {
            head = p;
            p.link = null;
        } else {
            Nodo f = head;
            f = head.link;
            head = p;
            p.link = f;
        }
    }

    public void Visualizza() {
        if(head == null)
        System.out.println("Lista vuota");
        else {
            System.out.println("Pazienti che hanno effettuato il prelievo");
            Nodo p = head;
            while(p != null) {
                System.out.println(p.info);
                p = p.link;
            }
        }
    }
}