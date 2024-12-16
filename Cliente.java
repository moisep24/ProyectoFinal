
/**
 * Write a description of class c here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Pedido> carrito;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.carrito = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pedido> getCarrito() {
        return carrito;
    }

    public void agregarProductoAlCarrito(Pedido pedido) {
        carrito.add(pedido);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(nombre).append("\nCarrito:\n");
        for (Pedido pedido : carrito) {
            sb.append("  ").append(pedido).append("\n");
        }
        return sb.toString();
    }
}

