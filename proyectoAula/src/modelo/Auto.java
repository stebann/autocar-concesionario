package modelo;

public class Auto {

    private final String marca;
    private final String color;
    private final String modelo;
    private final double km;
    private final double precio;
    

    public Auto(String marca, String color, String modelo, double km, double precio) {
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.modelo = modelo;
        this.km = km;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public String getModelo() {
        return modelo;
    }

    public double getKm() {
        return km;
    }

    public double getPrecio() {
        return precio;
    }

    
    @Override
    public String toString() {
        return "Marca: " + marca + "\n"
                + "Color: " + color + "\n"
                + "Modelo: " + modelo + "\n"
                + "Kilometraje: " + km + "\n"
                + "Precio: $" + precio;
    }

}
