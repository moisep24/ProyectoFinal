
/**
 * Write a description of class xa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pila {
    private NodoVenta tope; // Nodo superior de la pila
    private int size;       // Tamaño de la pila

    public Pila() {
        this.tope = null;   // Inicialmente, la pila está vacía
        this.size = 0;      // El tamaño es 0
    }

    // Agrega una venta a la pila
    public boolean push(Venta venta) {
        NodoVenta nuevoNodo = new NodoVenta(venta);
        if (estaVacia()) {
            this.tope = nuevoNodo; // Si está vacía, el nuevo nodo será el tope
        } else {
            nuevoNodo.setSiguiente(this.tope); // Conecta el nuevo nodo al tope actual
            this.tope = nuevoNodo;             // Actualiza el tope
        }
        size++; // Incrementa el tamaño
        return true;
    }

    // Verifica si la pila está vacía
    public boolean estaVacia() {
        return this.tope == null;
    }

    // Elimina el nodo superior y retorna la venta
    public Venta pop() throws Exception {
        if (estaVacia()) throw new Exception("Pila vacía");
        Venta venta = this.tope.getVenta(); // Obtiene la venta del nodo superior
        this.tope = this.tope.getSiguiente(); // Actualiza el tope
        size--; // Decrementa el tamaño
        return venta;
    }

    // Muestra el nodo superior sin eliminarlo
    public Venta peek() throws Exception {
        if (estaVacia()) throw new Exception("Pila vacía");
        return this.tope.getVenta();
    }

    // Imprime todas las ventas en la pila
    public void imprimirVentas() {
        NodoVenta actual = this.tope;
        while (actual != null) {
            System.out.println(actual.getVenta());
            actual = actual.getSiguiente();
        }
    }

    // Retorna el tamaño de la pila
    public int getSize() {
        return this.size;
    }
}



