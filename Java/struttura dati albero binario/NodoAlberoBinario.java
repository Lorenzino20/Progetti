public class NodoAlberoBinario {
    private Character info;
    private NodoAlberoBinario psx;
    private NodoAlberoBinario pdx;

    public NodoAlberoBinario(Character info) {
        this.info = info;
        psx = null;
        pdx = null;
    }

    public void setInfo(Character info) {this.info = info;}
    public Character getInfo() {return info;}
    public void setLeftChild(NodoAlberoBinario psx) {this.psx = psx;}
    public NodoAlberoBinario getLeftChild() {return psx;}
    public void setRightChild(NodoAlberoBinario pdx) {this.pdx = pdx;}
    public NodoAlberoBinario getRightChild() {return pdx;}
}