
/**
 * Write a description of class g here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grafo {
    private NodoGrafo1 primero; // Primer nodo del grafo
    private NodoGrafo1 ultimo;  // Último nodo del grafo

    public Grafo() {
        this.primero = null;
        this.ultimo = null;
    }

    // Verifica si el grafo está vacío
    public boolean estaVacio() {
        return this.primero == null && this.ultimo == null;
    }

    // Verifica si un nodo existe en el grafo
    public boolean existeVertice(Object dato) {
        if (estaVacio()) return false;
        NodoGrafo1 actual = primero;
        while (actual != null) {
            if (actual.getDato1().toString().equals(dato.toString()))
                return true; // Nodo encontrado
            actual = actual.getSiguiente2(); // Avanza al siguiente nodo
        }
        return false;
    }

    // Agrega un nodo al grafo
    public boolean agregarNodo(Object dato) {
        if (existeVertice(dato)) return false; // No se permiten nodos duplicados
        NodoGrafo1 nuevoNodo = new NodoGrafo1(dato);
        if (estaVacio()) { // Si el grafo está vacío, el nodo será el primero y último
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        } else {
            this.ultimo.setSiguiente2(nuevoNodo); // Conecta el nuevo nodo
            this.ultimo = nuevoNodo; // Actualiza el último nodo
        }
        return true;
    }

    // Agrega una arista (relación) entre dos nodos
    public boolean agregarArista(Object origen, Object destino) {
        if (!existeVertice(origen) || !existeVertice(destino)) return false; // Verifica que ambos nodos existan
        NodoGrafo1 actual = primero;
        while (!actual.getDato1().toString().equals(origen.toString())) {
            actual = actual.getSiguiente2(); // Busca el nodo de origen
        }
        actual.getlistaAdyacencia2().agregarAdyacencia(destino); // Agrega el destino a la lista de adyacencia
        return true;
    }

    // Busca un nodo específico en el grafo
    public NodoGrafo1 buscarNodo(Object dato) {
        NodoGrafo1 actual = primero;
        while (actual != null) {
            if (actual.getDato1().toString().equals(dato.toString()))
                return actual; // Retorna el nodo si lo encuentra
            actual = actual.getSiguiente2();
        }
        return null; // Nodo no encontrado
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        NodoGrafo1 actual = primero;
        while (actual != null) {
            cadena.append(actual.getDato1().toString()).append(" -> ")
                  .append(actual.getlistaAdyacencia2().toString()).append("\n");
            actual = actual.getSiguiente2();
        }
        return cadena.toString();
    }
}


