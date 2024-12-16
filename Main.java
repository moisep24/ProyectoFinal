
/**
 * Write a description of class as here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Estructuras del programa
        ArbolAVL inventarioAVL = new ArbolAVL();
        ArbolBinario arbolBinarioProductos = new ArbolBinario();
        Pila ventas = new Pila();
        ColaDinamicaClientes colaClientes = new ColaDinamicaClientes();
        ListaProductosFavoritos favoritos = new ListaProductosFavoritos();
        Grafo grafoProductos = new Grafo();

        // Leer productos desde el archivo CSV
        String rutaArchivo = "C:\\Users\\moise\\productos_nombres_unicos.csv";
        List<Producto> listaProductos = new ArrayList<>();
        Producto[] productos = null;

        try {
            listaProductos = Producto.leerProductosDesdeCSV(rutaArchivo);
            productos = new Producto[listaProductos.size()];

            for (int i = 0; i < listaProductos.size(); i++) {
                productos[i] = listaProductos.get(i);
                inventarioAVL.insertar(productos[i]); // Insertar en árbol AVL
                arbolBinarioProductos.agregar(productos[i]); // Insertar en árbol binario
                grafoProductos.agregarNodo(productos[i].getNombre()); // Agregar al grafo
            }

            // Agregar ventas predefinidas a la pila
            if (productos.length >= 5) {
                ventas.push(new Venta(productos[0], 10, "2024-01-01"));
                ventas.push(new Venta(productos[1], 5, "2024-01-02"));
                ventas.push(new Venta(productos[2], 20, "2024-01-03"));
                ventas.push(new Venta(productos[3], 15, "2024-01-04"));
                ventas.push(new Venta(productos[4], 7, "2024-01-05"));
            }

            // Relación inicial de productos en el grafo
            if (productos.length > 1) {
                grafoProductos.agregarArista(productos[0].getNombre(), productos[1].getNombre());
                grafoProductos.agregarArista(productos[1].getNombre(), productos[2].getNombre());
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        // Menú interactivo
        int opcion = -1;
        do {
            try {
                System.out.println("\nMenú Principal");
                System.out.println("1. Mostrar inventario ordenado (Árbol AVL)");
                System.out.println("2. Ordenar productos por precio (QuickSort)");
                System.out.println("3. Buscar producto por código (Árbol Binario)");
                System.out.println("4. Registrar una venta(pila)");
                System.out.println("5. Mostrar todas las ventas registradas");
                System.out.println("6. Eliminar la venta más reciente");
                System.out.println("7. Agregar cliente a la fila(cola)");
                System.out.println("8. Atender al cliente más antiguo");
                System.out.println("9. Ver al cliente actual");
                System.out.println("10. Listar todos los clientes en la fila");
                System.out.println("11. Agregar producto a favoritos (inicio)(lista,liga)");
                System.out.println("12. Agregar producto a favoritos (final)");
                System.out.println("13. Eliminar producto de favoritos por código");
                System.out.println("14. Mostrar productos favoritos(lista,liga");
                System.out.println("15. Mostrar relaciones entre productos (grafo)");
                System.out.println("16. Agregar relación entre productos");
                System.out.println("17. Mostrar productos relacionados con uno específico");
                System.out.println("18. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.println("\nInventario en orden por código (Árbol AVL):");
                        inventarioAVL.codigoEnOrden();
                        break;
                    case 2:
                        QuickSort.ordenar(productos);
                        System.out.println("\nProductos ordenados por precio (de menor a mayor):");
                        for (Producto producto : productos) {
                            System.out.println(producto);
                        }
                        break;
                    case 3:
                        System.out.print("Introduce el código del producto que deseas buscar: ");
                        String codigoBuscado = scanner.nextLine().trim().toUpperCase();
                        Producto productoEncontrado = arbolBinarioProductos.buscar(codigoBuscado);
                        if (productoEncontrado != null) {
                            System.out.println("Producto encontrado: " + productoEncontrado);
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                        break;
                    case 4:
                        System.out.print("Introduce el índice del producto para registrar la venta (0-" + (productos.length - 1) + "): ");
                        int indiceProducto = scanner.nextInt();
                        System.out.print("Introduce la cantidad vendida: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        System.out.print("Introduce la fecha de la venta (YYYY-MM-DD): ");
                        String fecha = scanner.nextLine();

                        if (indiceProducto >= 0 && indiceProducto < productos.length) {
                            Venta nuevaVenta = new Venta(productos[indiceProducto], cantidad, fecha);
                            ventas.push(nuevaVenta);
                            System.out.println("Venta registrada exitosamente.");
                        } else {
                            System.out.println("Índice de producto no válido.");
                        }
                        break;
                    case 5:
                        if (ventas.estaVacia()) {
                            System.out.println("No hay ventas registradas.");
                        } else {
                            System.out.println("\nVentas registradas:");
                            ventas.imprimirVentas();
                        }
                        break;
                    case 6:
                        if (ventas.estaVacia()) {
                            System.out.println("No hay ventas para eliminar.");
                        } else {
                            try {
                                Venta ventaEliminada = ventas.pop();
                                System.out.println("Venta eliminada: " + ventaEliminada);
                            } catch (Exception e) {
                                System.out.println("Error al eliminar la venta: " + e.getMessage());
                            }
                        }
                        break;
                    case 7:
                        System.out.print("Introduce el nombre del cliente: ");
                        String nombreCliente = scanner.nextLine();
                        Cliente nuevoCliente = new Cliente(nombreCliente);
                        colaClientes.agregarCliente(nuevoCliente);
                        System.out.println("Cliente agregado a la fila.");
                        break;
                    case 8:
                        if (colaClientes.estaVacia()) {
                            System.out.println("No hay clientes en la fila.");
                        } else {
                            try {
                                Cliente clienteAtendido = colaClientes.atenderCliente();
                                System.out.println("Cliente atendido: " + clienteAtendido.getNombre());
                            } catch (Exception e) {
                                System.out.println("Error al atender cliente: " + e.getMessage());
                            }
                        }
                        break;
                    case 9:
                        if (colaClientes.estaVacia()) {
                            System.out.println("No hay clientes en la fila.");
                        } else {
                            try {
                                Cliente clienteActual = colaClientes.verPrimero();
                                System.out.println("Cliente actual: " + clienteActual.getNombre());
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        break;
                    case 10:
                        if (colaClientes.estaVacia()) {
                            System.out.println("No hay clientes en la fila.");
                        } else {
                            System.out.println("Clientes en la fila:");
                            colaClientes.listarClientes();
                        }
                        break;
                    case 11:
                        System.out.print("Introduce el índice del producto para agregar a favoritos (inicio): ");
                        int indiceFavoritoInicio = scanner.nextInt();
                        scanner.nextLine();
                        if (indiceFavoritoInicio >= 0 && indiceFavoritoInicio < productos.length) {
                            favoritos.agregarInicio(productos[indiceFavoritoInicio]);
                            System.out.println("Producto agregado a favoritos (inicio).");
                        } else {
                            System.out.println("Índice de producto no válido.");
                        }
                        break;
                    case 12:
                        System.out.print("Introduce el índice del producto para agregar a favoritos (final): ");
                        int indiceFavoritoFinal = scanner.nextInt();
                        scanner.nextLine();
                        if (indiceFavoritoFinal >= 0 && indiceFavoritoFinal < productos.length) {
                            favoritos.agregarUltimo(productos[indiceFavoritoFinal]);
                            System.out.println("Producto agregado a favoritos (final).");
                        } else {
                            System.out.println("Índice de producto no válido.");
                        }
                        break;
                    case 13:
                        System.out.print("Introduce el código del producto a eliminar de favoritos: ");
                        String codigoFavorito = scanner.nextLine().trim().toUpperCase();
                        if (favoritos.eliminarPorCodigo(codigoFavorito)) {
                            System.out.println("Producto eliminado de favoritos.");
                        } else {
                            System.out.println("Producto no encontrado en favoritos.");
                        }
                        break;
                    case 14:
                        System.out.println("Productos favoritos:");
                        favoritos.mostrarProductos();
                        break;
                    case 15:
                        System.out.println("\nRelaciones entre productos:");
                        System.out.println(grafoProductos);
                        break;
                    case 16:
                        System.out.print("Introduce el nombre del producto origen: ");
                        String productoOrigen = scanner.nextLine();
                        System.out.print("Introduce el nombre del producto relacionado: ");
                        String productoRelacionado = scanner.nextLine();
                        if (grafoProductos.agregarArista(productoOrigen, productoRelacionado)) {
                            System.out.println("Relación agregada exitosamente.");
                        } else {
                            System.out.println("Error: Uno o ambos productos no existen.");
                        }
                        break;
                    case 17:
                        System.out.print("Introduce el nombre del producto: ");
                        String productoBase = scanner.nextLine();
                        if (grafoProductos.existeVertice(productoBase)) {
                            NodoGrafo1 nodoProducto = grafoProductos.buscarNodo(productoBase);
                            System.out.println("Productos relacionados con " + productoBase + ":");
                            System.out.println(nodoProducto.getlistaAdyacencia2());
                        } else {
                            System.out.println("El producto no existe.");
                        }
                        break;
                    case 18:
                        System.out.println("Saliendo del programa. ¡Adiós!");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número válido.");
                scanner.nextLine();
            }
        } while (opcion != 18);

        scanner.close();
    }
}










