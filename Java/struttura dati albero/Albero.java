public class Albero {
    private NodoAlbero ptr;

    public Albero() {
        ptr = null;
    }

    public void visitaAnticipata() {
        visitaAnticipata(ptr);
    }
    private void visitaAnticipata(NodoAlbero p) {
        if(p == null) return;
        System.out.println(p.getInfo());
        if(p.getFirstChild() != null) 
            visitaAnticipata(p.getFirstChild());
        if(p.getFirstSibiling() != null) 
            visitaAnticipata(p.getFirstSibiling());
    }

    public void visitaDifferita() {
        visitaDifferita(ptr);
    }
    private void visitaDifferita(NodoAlbero p) {
        if(p == null) return;
        if(p.getFirstChild() != null) 
            visitaDifferita(p.getFirstChild());
        System.out.println(p.getInfo());
        if(p.getFirstSibiling() != null) 
            visitaDifferita(p.getFirstSibiling());
    }

    private NodoAlbero cercaNodo(NodoAlbero p, char chiave) {
        NodoAlbero p1 = null;
        if(p == null)
        return null;
        if(p.getInfo() == chiave) return p;
        if(p.getFirstChild() != null) {
            p1 = cercaNodo(p.getFirstChild(), chiave);
            if(p1 != null) return p1;
        }
        if(p.getFirstSibiling() != null) {
            p1 = cercaNodo(p.getFirstSibiling(), chiave);
            if(p1 != null) return p1;
        }
        return null;
    }

    public void aggiungiFoglio(char chiave, char info) {
        NodoAlbero n = new NodoAlbero(info);
        if(ptr == null) {
            ptr = n;
            return;
        }
        NodoAlbero p;
        p = cercaNodo(ptr, chiave);
        if(p != null) 
            if(p.getFirstChild() == null)
                p.setFirstChild(n);
            else {
                p = p.getFirstChild();
                while(p.getFirstSibiling() != null)
                    p = p.getFirstSibiling();
                    p.setFirstSibling(n);
            }    
    }
}