
package modelo;


public class Comprador {
    final private String nombre;
    final private int id;
    final private int telefono;
    final private String direccion;
    final private Auto autoVendido;

    public Comprador(String nombre, int id, int telefono, String direccion, Auto autoVendido) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
        this.autoVendido = autoVendido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Auto getAutoVendido() {
        return autoVendido;
    }

    
    
    
}
