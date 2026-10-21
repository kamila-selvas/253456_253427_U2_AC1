import java.util.LinkedList;

public class BusquedaBinaria {

    public static int buscar(LinkedList<Producto> lista, double precioBuscado, int inicio, int fin) {
        if (inicio > fin) {
            return -1;
        }

        int medio = inicio + (fin - inicio) / 2;
        double precioMedio = lista.get(medio).getPrecio();

        if (precioMedio == precioBuscado) {
            return medio;
        } else if (precioBuscado < precioMedio) {
            return buscar(lista, precioBuscado, inicio, medio - 1);
        } else {
            return buscar(lista, precioBuscado, medio + 1, fin);
        }
    }
}
