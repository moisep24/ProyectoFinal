
/**
 * Write a description of class g here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArbolBinario {
    private NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public boolean estaVacia() {
        return this.raiz == null;
    }

    public boolean agregar(Producto producto) {
        NodoArbol nuevo = new NodoArbol(producto);
        if (estaVacia()) {
            raiz = nuevo;
            return true;
        }
        return agregarEnNodo(nuevo, raiz);
    }

    private boolean agregarEnNodo(NodoArbol nuevo, NodoArbol raiz) {
        int comparacion = nuevo.getProducto().getCodigo().compareTo(raiz.getProducto().getCodigo());
        if (comparacion < 0) { // Ir a la izquierda
            if (raiz.getIzq() == null) {
                raiz.setIzq(nuevo);
                return true;
            }
            return agregarEnNodo(nuevo, raiz.getIzq());
        } else if (comparacion > 0) { // Ir a la derecha
            if (raiz.getDer() == null) {
                raiz.setDer(nuevo);
                return true;
            }
            return agregarEnNodo(nuevo, raiz.getDer());
        }
        return false; // Código ya existente, no se agrega
    }

    public Producto buscar(String codigo) {
        return buscarEnNodo(codigo, raiz);
    }

    private Producto buscarEnNodo(String codigo, NodoArbol nodo) {
        if (nodo == null) {
            return null; // No encontrado
        }
        int comparacion = codigo.compareTo(nodo.getProducto().getCodigo());
        if (comparacion == 0) {
            return nodo.getProducto(); // Encontrado
        }
        if (comparacion < 0) {
            return buscarEnNodo(codigo, nodo.getIzq()); // Buscar en el subárbol izquierdo
        }
        return buscarEnNodo(codigo, nodo.getDer()); // Buscar en el subárbol derecho
    }

    public void inOrden() {
        inOrdenNodo(raiz);
    }

    private void inOrdenNodo(NodoArbol nodo) {
        if (nodo != null) {
            inOrdenNodo(nodo.getIzq());
            System.out.println(nodo.getProducto());
            inOrdenNodo(nodo.getDer());
        }
    }
}
