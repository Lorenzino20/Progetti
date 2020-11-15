public class Coda {
    Nodo head = null;
    Nodo tail = null;
    public int count = 0;
    
    public Coda() {}
    
    public Nodo creaNodo(Paziente persona, Nodo link) {
        Nodo p = new Nodo(persona);
        p.link = link;
        count ++;
        return p;
    }
    
    public void inserisciInCoda(Paziente persona) {
        if(count >= 20) 
        System.out.println("La coda e piena!");
        else {
            if(count == 19) 
            System.out.println("Questo era l'ultimo posto");
            Nodo p = creaNodo(persona, null);
            if(head == null) {
                tail = p;
                head = tail;
            }
            else {
                tail.link = p;
                tail = p;
            }
        }
    }
    
    public void eliminaDallaCoda() {
        if(head == null)
        System.out.println("Coda vuota");
        else {
            Nodo p = head;
            head = head.link;
            count --;
            if(head == null) {
                tail = null;
            }
        }    
    }
    
    public void Visualizza() {
        if(head == null)
        System.out.println("Coda vuota");
        else {
            System.out.println("Pazienti in coda");
            Nodo p = head;
            while(p != null) {
                System.out.println(p.info);
                p = p.link;
            }
        }
    }
}