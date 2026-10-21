/**
 * Clase que representa un Producto en el almacén.
 * Implementa la interfaz Comparable para permitir el ordenamiento natural por precio.
 */
public class Producto implements Comparable<Producto> {
    // Atributos privados
    private String nombre;
    private double precio;

    // Constructor por defecto
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Métodos Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Criterio de ordenamiento natural por precio (Comparable)
    @Override
    public int compareTo(Producto otroProducto) {
        if (this.precio < otroProducto.precio) {
            return -1;
        } else if (this.precio > otroProducto.precio) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Producto [Nombre: " + nombre + ", Precio: $" + precio + "]";
    }
}
