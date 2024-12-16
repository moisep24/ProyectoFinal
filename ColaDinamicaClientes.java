
/**
 * Write a description of class h here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColaDinamicaClientes {
    private NodoCliente primero; // Primer cliente en la cola
    private NodoCliente ultimo;  // Último cliente en la cola

    public ColaDinamicaClientes() {
        this.primero = null; // Inicialmente, la cola está vacía
        this.ultimo = null;
    }

    // Verifica si la cola está vacía
    public boolean estaVacia() {
        return this.primero == null;
    }

    // Agrega un cliente al final de la cola
    public void agregarCliente(Cliente cliente) {
        NodoCliente nuevoNodo = new NodoCliente(cliente);
        if (estaVacia()) {
            this.primero = nuevoNodo; // Si está vacía, el nuevo nodo es el primero y último
            this.ultimo = nuevoNodo;
        } else {
            this.ultimo.setSiguiente(nuevoNodo); // Conecta el nuevo nodo al final
            this.ultimo = nuevoNodo; // Actualiza el último nodo
        }
    }

    // Elimina y retorna el primer cliente de la cola
    public Cliente atenderCliente() throws Exception {
        if (estaVacia()) throw new Exception("La cola está vacía.");
        Cliente clienteAtendido = this.primero.getCliente();
        this.primero = this.primero.getSiguiente(); // Actualiza el primer nodo
        if (this.primero == null) {
            this.ultimo = null; // Si la cola quedó vacía, actualiza el último nodo
        }
        return clienteAtendido;
    }

    // Muestra el primer cliente sin eliminarlo
    public Cliente verPrimero() throws Exception {
        if (estaVacia()) throw new Exception("La cola está vacía.");
        return this.primero.getCliente();
    }
    public void listarClientes() {
    if (estaVacia()) {
        System.out.println("No hay clientes en la cola.");
        return;
    }
    NodoCliente actual = this.primero;
    while (actual != null) {
        System.out.println(actual.getCliente().getNombre());
        actual = actual.getSiguiente();
    }
}

}



