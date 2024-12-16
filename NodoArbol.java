
/**
 * Write a description of class b here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoArbol {
    private Producto producto;
    private NodoArbol izq;
    private NodoArbol der;

    public NodoArbol(Producto producto) {
        this.producto = producto;
        this.izq = null;
        this.der = null;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public NodoArbol getIzq() {
        return this.izq;
    }

    public NodoArbol getDer() {
        return this.der;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }
}
