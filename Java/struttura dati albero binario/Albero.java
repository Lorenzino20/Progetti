public class Albero {
    private NodoAlberoBinario ptr;

    public Albero() {
        ptr = null;
    }

    public void visitaAnticipata() {
        visitaAnticipata(ptr);
    }
    private void visitaAnticipata(NodoAlberoBinario p) {
        if(p == null) return;
        System.out.println(p.getInfo());
        if(p.getLeftChild() != null) 
            visitaAnticipata(p.getLeftChild());
        if(p.getRightChild() != null) 
            visitaAnticipata(p.getRightChild());
    }

    private void visitaDifferita(NodoAlberoBinario p) {
        if(p == null) 
        return;
        if(p.getLeftChild() != null)
            visitaDifferita(p.getLeftChild());
        if(p.getRightChild() != null)
            visitaDifferita(p.getRightChild());
        System.out.println(p.getInfo());  
    }

    public void visitaDifferita() {
        visitaDifferita(ptr);
    }
    private NodoAlberoBinario cercaNodo(NodoAlberoBinario p, char chiave) {
        NodoAlberoBinario p1 = null;
        if(p == null)
        return null;
        if(p.getInfo() == chiave) return p;
        if(p.getLeftChild() != null) {
            p1 = cercaNodo(p.getLeftChild(), chiave);
            if(p1 != null) return p1;
        }
        if(p.getRightChild() != null) {
            p1 = cercaNodo(p.getRightChild(), chiave);
            if(p1 != null) return p1;
        }
        return null;
    }

    public void aggiungiFoglio(char chiave, char info) {
        NodoAlberoBinario n = new NodoAlberoBinario(info);
        if(ptr == null) {
            ptr = n;
            return;
        }
        NodoAlberoBinario p;
        p = cercaNodo(ptr, chiave);
        if(p != null) 
            if(p.getLeftChild() == null)
                p.setLeftChild(n);
            else {
                p = p.getLeftChild();
                while(p.getRightChild() != null)
                    p = p.getRightChild();
                    p.setRightChild(n);
            }    
    }
}