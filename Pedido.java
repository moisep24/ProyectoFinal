
/**
 * Write a description of class f here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido {
    private Producto producto;
    private int cantidad;
    private String cliente;
    private String fecha;

    public Pedido(Producto producto, int cantidad, String cliente, String fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCliente() {
        return cliente;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Pedido: " + producto.getNombre() + ", Cantidad: " + cantidad + 
               ", Cliente: " + cliente + ", Fecha: " + fecha;
    }
}


