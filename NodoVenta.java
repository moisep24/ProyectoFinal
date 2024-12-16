
/**
 * Write a description of class NodoVenta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoVenta {
    private Venta venta;
    private NodoVenta siguiente;

    public NodoVenta(Venta venta) {
        this.venta = venta;
        this.siguiente = null;
    }
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    public void setSiguiente(NodoVenta siguiente) {
        this.siguiente = siguiente;
    }
    public Venta getVenta() {
        return this.venta;
    }
    public NodoVenta getSiguiente() {
        return this.siguiente;
    }
}


