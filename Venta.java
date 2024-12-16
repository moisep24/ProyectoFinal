
/**
 * Write a description of class asd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Venta {
    private Producto producto;
    private int cantidad;
    private String fecha;
    public Venta(Producto producto, int cantidad, String fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String toString() {
        return producto.getNombre() + ", " + cantidad + ", " + fecha;
    }
}


