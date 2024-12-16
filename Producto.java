
/**
 * Write a description of class adc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Producto {
    private String nombre;
    private String codigo;
    private double precio;
    private int cantidad;
    public Producto(String nombre, String codigo, double precio, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public static List<Producto> leerProductosDesdeCSV(String rutaArchivo) throws IOException {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine(); // Leer la cabecera (Nombre, Código, Precio, Cantidad)
            while ((linea = br.readLine()) != null) { // Leer cada línea del archivo
                String[] partes = linea.split(","); // Dividir los valores por coma
                if (partes.length == 4) {
                    String nombre = partes[0].trim();
                    String codigo = partes[1].trim();
                    double precio = Double.parseDouble(partes[2].trim());
                    int cantidad = Integer.parseInt(partes[3].trim());
                    productos.add(new Producto(nombre, codigo, precio, cantidad));
                }        }
    
    return productos;
}

    }
    public String toString() {
        return nombre + ", " + codigo + ", " + precio + ", " + cantidad;
    }
}



