/**
 * Clase principal que contiene el punto de entrada (main) de la aplicación.
 * Se encarga de instanciar el almacén y lanzar el menú interactivo.
 */
public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        almacen.visualizarMenu();
    }
}
