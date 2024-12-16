
/**
 * Write a description of class c here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoGrafo1 {
    private Object dato;
    private Lista listaAdyacencia;
    private NodoGrafo1 siguiente;

    public NodoGrafo1(Object dato) {
        this.dato = dato;
        this.listaAdyacencia = new Lista();
        this.siguiente = null;
    }

    public Object getDato1() {
        return dato;
    }

    public Lista getlistaAdyacencia2() {
        return listaAdyacencia;
    }

    public NodoGrafo1 getSiguiente2() {
        return siguiente;
    }

    public void setDato1(Object dato) {
        this.dato = dato;
    }

    public void setlistaAdyacencia2(Lista listaAdyacencia) {
        this.listaAdyacencia = listaAdyacencia;
    }

    public void setSiguiente2(NodoGrafo1 siguiente) {
        this.siguiente = siguiente;
    }
}

