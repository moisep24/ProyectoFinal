
/**
 * Write a description of class b here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaProductosFavoritos {
    private NodoProducto primero; // Primer producto de la lista
    private NodoProducto ultimo;  // Último producto de la lista

    public ListaProductosFavoritos() {
        this.primero = null;
        this.ultimo = null;
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return this.primero == null;
    }

    // Agrega un producto al inicio de la lista
    public boolean agregarInicio(Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto(producto);
        if (estaVacia()) {
            this.primero = nuevoNodo; // Si está vacía, el nuevo nodo es el primero y último
            this.ultimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(this.primero); // Conecta el nuevo nodo al inicio
            this.primero = nuevoNodo;
        }
        return true;
    }

    // Agrega un producto al final de la lista
    public boolean agregarUltimo(Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto(producto);
        if (estaVacia()) {
            this.primero = nuevoNodo; // Si está vacía, el nuevo nodo es el primero y último
            this.ultimo = nuevoNodo;
        } else {
            this.ultimo.setSiguiente(nuevoNodo); // Conecta el nuevo nodo al final
            this.ultimo = nuevoNodo;
        }
        return true;
    }

    // Elimina un producto de la lista por su código
    public boolean eliminarPorCodigo(String codigo) {
        if (estaVacia()) return false;

        if (primero.getProducto().getCodigo().equalsIgnoreCase(codigo)) {
            primero = primero.getSiguiente(); // Elimina el primero
            if (primero == null) {
                ultimo = null; // Si la lista quedó vacía, actualiza el último nodo
            }
            return true;
        }

        NodoProducto actual = primero;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getProducto().getCodigo().equalsIgnoreCase(codigo)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente()); // Elimina el nodo
                if (actual.getSiguiente() == null) {
                    ultimo = actual; // Actualiza el último nodo si se eliminó el último
                }
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false; // No se encontró el producto
    }

    // Muestra todos los productos en la lista
    public void mostrarProductos() {
        if (estaVacia()) {
            System.out.println("La lista de productos favoritos está vacía.");
            return;
        }
        NodoProducto actual = primero;
        System.out.println("Productos favoritos:");
        while (actual != null) {
            System.out.println(actual.getProducto());
            actual = actual.getSiguiente();
        }
    }
}


