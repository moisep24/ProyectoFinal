
/**
 * Write a description of class nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nodo {
         Producto producto;
         int altura;
         Nodo izquierda;
         Nodo derecha;

        public Nodo(Producto producto) {
            this.producto = producto;
            this.derecha = null;
            this.izquierda = null;
            this.altura = 1;
        }
        public Producto getProducto() {
            return producto;
        }
        public int getAltura() {
            return altura;
        }
        public void setAltura(int altura) {
            this.altura = altura;
        }
        public Nodo getIzquierda() {
            return izquierda;
        }
        public void setIzquierda(Nodo izquierda) {
            this.izquierda = izquierda;
        }
        public Nodo getDerecha() {
            return derecha;
        }
        public void setDerecha(Nodo derecha) {
            this.derecha = derecha;
        }
    }
