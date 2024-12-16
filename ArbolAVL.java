
/**
 * Write a description of class ca here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArbolAVL {
    private Nodo raiz;
    public ArbolAVL() {
        this.raiz = null;
    }
    public void insertar(Producto producto) {
        raiz = insertarNodo(producto, raiz);
    }
    private Nodo insertarNodo(Producto producto, Nodo nodo) {
        if (nodo == null) 
            return new Nodo(producto);
        if (producto.getCodigo().compareTo(nodo.getProducto().getCodigo()) < 0) 
            nodo.setIzquierda(insertarNodo(producto, nodo.getIzquierda()));
        if (producto.getCodigo().compareTo(nodo.getProducto().getCodigo()) > 0)
            nodo.setDerecha(insertarNodo(producto, nodo.getDerecha()));
            
        nodo.setAltura(1 + Math.max(obtenerAltura(nodo.getIzquierda()), obtenerAltura(nodo.getDerecha())));
        int balance = obtenerBalance(nodo);
        
        if (balance > 1 && producto.getCodigo().compareTo(nodo.getIzquierda().getProducto().getCodigo()) < 0)
            return rotacionDerecha(nodo);
        if (balance < -1 && producto.getCodigo().compareTo(nodo.getDerecha().getProducto().getCodigo()) > 0)
            return rotacionIzquierda(nodo);
        if (balance > 1 && producto.getCodigo().compareTo(nodo.getIzquierda().getProducto().getCodigo()) > 0) {
            nodo.setIzquierda(rotacionIzquierda(nodo.getIzquierda()));
            return rotacionDerecha(nodo);
        } 
        if (balance < -1 && producto.getCodigo().compareTo(nodo.getDerecha().getProducto().getCodigo()) < 0) {
            nodo.setDerecha(rotacionDerecha(nodo.getDerecha()));
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }
    private int obtenerAltura(Nodo nodo) {
        if (nodo == null)
            return 0;
        return nodo.getAltura();
    }
    private Nodo rotacionIzquierda(Nodo x) {
        Nodo y = x.getDerecha();
        Nodo z = y.getIzquierda();
        y.setIzquierda(x);
        x.setDerecha(z);
        x.setAltura(1 + Math.max(obtenerAltura(x.getIzquierda()), obtenerAltura(x.getDerecha())));
        y.setAltura(1 + Math.max(obtenerAltura(y.getIzquierda()), obtenerAltura(y.getDerecha())));
        return y;
    }
    private Nodo rotacionDerecha(Nodo x) {
        Nodo y = x.getIzquierda();
        Nodo z = y.getDerecha();
        y.setDerecha(x);
        x.setIzquierda(z);
        x.setAltura(1 + Math.max(obtenerAltura(x.getIzquierda()), obtenerAltura(x.getDerecha())));
        y.setAltura(1 + Math.max(obtenerAltura(y.getIzquierda()), obtenerAltura(y.getDerecha())));
        return y;
    }
    private int obtenerBalance(Nodo nodo) {
        if (nodo == null)
            return 0;
        return obtenerAltura(nodo.getIzquierda()) - obtenerAltura(nodo.getDerecha());
    }
    public void codigoEnOrden() {
        codigoEnOrden(raiz);
    }
    private void codigoEnOrden(Nodo nodo) {
        if (nodo != null) {
            codigoEnOrden(nodo.getIzquierda());
            System.out.println(nodo.getProducto());
            codigoEnOrden(nodo.getDerecha());
        }
    }
         // Método para buscar un producto por su código
    public Producto buscar(String codigo) {
        return buscarNodo(codigo, raiz);
    }

    private Producto buscarNodo(String codigo, Nodo nodo) {
        if (nodo == null) {
            return null; // No encontrado
        }
        int comparacion = codigo.compareTo(nodo.getProducto().getCodigo());
        if (comparacion == 0) {
            return nodo.getProducto(); // Producto encontrado
        }
        if (comparacion < 0) {
            return buscarNodo(codigo, nodo.getIzquierda()); // Buscar en el subárbol izquierdo
        }
        return buscarNodo(codigo, nodo.getDerecha()); // Buscar en el subárbol derecho
    }
    }


