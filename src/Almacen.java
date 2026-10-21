import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Clase Almacen que gestiona una colección de productos mediante LinkedList,
 * delegando la búsqueda al módulo BusquedaBinaria y utilizando Comparable para ordenamiento.
 */
public class Almacen {

    // Atributos del diagrama de clases
    private LinkedList<Producto> listaProductos;
    private Producto objetoProducto;
    private Scanner entrada;

    // Constructor
    public Almacen() {
        listaProductos = new LinkedList<>();
        entrada = new Scanner(System.in);
    }

    // 1. Método para agregar un producto a la lista
    public void agregarProducto() {
        System.out.println("\n--- AGREGAR PRODUCTO ---");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = entrada.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(entrada.nextLine());

        objetoProducto = new Producto(nombre, precio);
        listaProductos.add(objetoProducto);
        System.out.println("-> Producto agregado exitosamente.");
    }

    // 2. Método para mostrar todos los productos de la lista
    public void visualizarListaProductos() {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        if (listaProductos.isEmpty()) {
            System.out.println("El almacén está vacío.");
            return;
        }

        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println((i + 1) + ". " + listaProductos.get(i));
        }
    }

    // 3. Método para ordenar los productos por precio (Comparable / Collections.sort)
    public void ordenarListaProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("\nNo hay productos para ordenar.");
            return;
        }

        // Ordenamiento natural utilizando compareTo implementado en Producto
        Collections.sort(listaProductos);
        System.out.println("\n-> Lista de productos ordenada por precio (ascendente).");
        visualizarListaProductos();
    }

    // 4. Método para buscar un producto por precio mediante la clase BusquedaBinaria
    public void buscarProducto() {
        if (listaProductos.isEmpty()) {
            System.out.println("\nNo hay productos en el almacén.");
            return;
        }

        // Condición para la búsqueda binaria: la lista debe estar ordenada
        Collections.sort(listaProductos);

        System.out.println("\n--- BÚSQUEDA BINARIA POR PRECIO ---");
        System.out.print("Ingrese el precio a buscar: ");
        double precioBuscado = Double.parseDouble(entrada.nextLine());

        // Se delega la búsqueda a la clase especializada BusquedaBinaria
        int posicion = BusquedaBinaria.buscar(listaProductos, precioBuscado, 0, listaProductos.size() - 1);

        if (posicion != -1) {
            Producto encontrado = listaProductos.get(posicion);
            System.out.println("-> ¡Producto encontrado en la posición " + posicion + "!");
            System.out.println("   " + encontrado);
        } else {
            System.out.println("-> No se encontró ningún producto con el precio $" + precioBuscado);
        }
    }

    // Menú interactivo de opciones
    public void visualizarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n==================================");
            System.out.println("        SISTEMA DE ALMACÉN        ");
            System.out.println("==================================");
            System.out.println("1. Agregar producto");
            System.out.println("2. Visualizar lista de productos");
            System.out.println("3. Ordenar productos por precio");
            System.out.println("4. Buscar producto por precio (Búsqueda Binaria)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    visualizarListaProductos();
                    break;
                case 3:
                    ordenarListaProductos();
                    break;
                case 4:
                    buscarProducto();
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        almacen.visualizarMenu();
    }
}
