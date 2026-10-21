import java.util.LinkedList;

/**
 * Clase encargada de implementar el algoritmo de Búsqueda Binaria de forma modular.
 */
public class BusquedaBinaria {

    /**
     * Realiza una búsqueda binaria recursiva en una lista de productos ordenada por precio.
     * 
     * @param lista         Lista de productos ordenada ascendentemente por precio.
     * @param precioBuscado El precio que se desea localizar.
     * @param inicio        Índice inicial del subrango de búsqueda.
     * @param fin           Índice final del subrango de búsqueda.
     * @return              El índice del producto en la lista si se encuentra, o -1 si no existe.
     */
    public static int buscar(LinkedList<Producto> lista, double precioBuscado, int inicio, int fin) {
        // Caso base: rango inválido, el elemento no existe en la lista
        if (inicio > fin) {
            return -1;
        }

        // Cálculo del punto medio para evitar desbordamiento
        int medio = inicio + (fin - inicio) / 2;
        double precioMedio = lista.get(medio).getPrecio();

        // Comparación con el elemento medio
        if (precioMedio == precioBuscado) {
            return medio; // Elemento encontrado
        } else if (precioBuscado < precioMedio) {
            // Llamada recursiva en el subconjunto izquierdo
            return buscar(lista, precioBuscado, inicio, medio - 1);
        } else {
            // Llamada recursiva en el subconjunto derecho
            return buscar(lista, precioBuscado, medio + 1, fin);
        }
    }
}
