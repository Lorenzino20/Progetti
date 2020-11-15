public class NodoAlbero {
    private Character info;
    private NodoAlbero pfc;
    private NodoAlbero pfs;

    public NodoAlbero(Character info) {
        this.info = info ;
        pfc = null;
        pfs = null;
    }

    public void setInfo(Character info) {this.info = info;}
    public Character getInfo() {return info;}
    public void setFirstChild(NodoAlbero pfc) {this.pfc = pfc;}
    public NodoAlbero getFirstChild() {return pfc;}
    public void setFirstSibling(NodoAlbero pfs) {this.pfs = pfs;}
    public NodoAlbero getFirstSibiling() {return pfs;}

}