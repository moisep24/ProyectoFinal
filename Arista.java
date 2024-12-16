
/**
 * Write a description of class c here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arista {
    private Object destino;
    private Arista siguiente;

    public Arista(Object destino) {
        this.destino = destino;
        this.siguiente = null;
    }

    public Object getDestino() {
        return destino;
    }

    public Arista getSiguiente() {
        return siguiente;
    }

    public void setDestino(Object destino) {
        this.destino = destino;
    }

    public void setSiguiente(Arista siguiente) {
        this.siguiente = siguiente;
    }
}

