
/**
 * Write a description of class sa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuickSort {
    public static void ordenar(Producto[] productos) {
        quick(productos, 0, productos.length - 1);
    }
    private static void quick(Producto[] productos, int posI, int posD) {
        if (posI < posD) {
            int index = sort(productos, posI, posD);
            quick(productos, posI, index - 1);
            quick(productos, index, posD);
        }
    }
    private static int sort(Producto[] productos, int posI, int posD) {
    double pivote = productos[(posI + posD) / 2].getPrecio(); // Elegir el precio como pivote
    while (posI <= posD) {
        while (productos[posI].getPrecio() < pivote) // Comparar precios
            posI++;
        while (productos[posD].getPrecio() > pivote) // Comparar precios
            posD--;
        if (posI <= posD) {
            Producto aux = productos[posI];
            productos[posI] = productos[posD];
            productos[posD] = aux;
            posI++;
            posD--;
        }
    }
    return posI;
}
}


