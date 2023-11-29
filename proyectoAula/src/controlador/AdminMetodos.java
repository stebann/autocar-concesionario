package controlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import modelo.Auto;
import modelo.Comprador;

public class AdminMetodos {

    Scanner sc = new Scanner(System.in);
    //autos
    List<Auto> autos = new ArrayList<>();
    //compradores
    List<Comprador> compradores = new ArrayList<>();

    int indiceReal;
    int autosVendidos = 0;
    int autos_inventario = 0;

    public void añadirAutos() {
        System.out.println("------------------------");
        System.out.println("      AGREGAR AUTO        ");
        System.out.println("------------------------");

        System.out.println("DATOS DEL AUTO:\n");
        System.out.print("Ingrese la marca: ");
        String marca = sc.nextLine();

        if (marca.isEmpty()) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: Ingrese un dato valido.\n");
            return;
        } else if (marca.matches(".*\\d.*")) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: Ingrese una marca valida\n");
            return;
        } else if (marca.length() < 2 || marca.length() > 15) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: La marca debe tener entre 2 y 15 caracteres\n");
            return;
        }

        System.out.print("Ingrese el color: ");
        String color = sc.nextLine();

        if (color.isEmpty()) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: Ingrese un dato valido.\n");
            return;
        } else if (color.matches(".*\\d.*")) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: Ingrese un color valido.\n");
            return;
        } else if (color.length() < 4 || color.length() > 15) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: El color debe tener entre 4 y 15 caracteres\n");
            return;
        }

        System.out.print("Ingrese el modelo: ");
        String modelo = sc.nextLine();

        if (modelo.isEmpty()) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: Ingrese un dato valido.\n");
            return;
        } else if (modelo.matches(".*\\d.*")) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: Ingrese un modelo valido\n");
            return;
        } else if (modelo.length() < 3 || modelo.length() > 20) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: El modelo debe tener entre 3 y 20 caracteres\n");
            return;
        }

        double km;
        try {
            System.out.print("Ingrese el kilometraje: ");
            km = sc.nextDouble();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: Ingresaste un valor no válido para el kilometraje. Debe ser numeros.\n");
            return;
        }

        String kmString = String.valueOf(km);

        assert km >= 0 : "ERROR: El kilometraje no puede ser negativo";

        if (kmString.length() < 1 || kmString.length() > 20) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: El kilometraje debe tener entre 1 y 20 caracteres\n");
            return;
        }

        double precio;
        try {
            System.out.print("Ingrese el precio: ");
            precio = sc.nextDouble();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: Ingresaste un valor no válido para el precio. Debe ser números.\n");
            return;
        }

        String precioString = String.valueOf(precio);

        assert precio >= 0 : "ERROR: El precio no puede ser negativo\n";

        if (precioString.length() < 2 || precioString.length() > 20) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: El precio debe tener entre 2 y 20 caracteres\n");
            return;
        }

        Auto auto = new Auto(marca, color, modelo, km, precio);
        autos.add(auto);
        autos_inventario++;

        System.out.println("------------------------");
        System.out.println("Auto agregado exitosamente");
    }

    public void mostrarAutos() {

        if (autos.isEmpty()) {
            System.out.println("------------------------");
            System.out.println("No hay autos disponibles.");
            return;
        }

        System.out.println("------------------------");
        System.out.println("    AUTOS DISPONIBLES    ");
        System.out.println("------------------------");

        for (Auto auto : autos) {
            System.out.println("Marca: " + auto.getMarca()
                    + "\nColor: " + auto.getColor()
                    + "\nModelo: " + auto.getModelo()
                    + "\nKilometraje: " + auto.getKm()
                    + "\nPrecio: $" + String.format("%.2f", auto.getPrecio()));
            System.out.println("");
        }
    }

    public void eliminarAutos() {

        if (autos.isEmpty()) {
            System.out.println("------------------------");
            System.out.println("No hay autos disponibles.");
            return;
        }

        System.out.println("------------------------");
        System.out.println("      ELIMINAR AUTO        ");
        System.out.println("------------------------");

        for (int i = 0; i < autos.size(); i++) {
            System.out.println((i + 1) + ". " + autos.get(i));
            System.out.println("");
        }
     

        int indiceAuto;
        try {
            System.out.print("Ingrese el número del auto (0 cancelar eliminación): ");
            indiceAuto = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: La entrada no es válida. Por favor, inténtalo de nuevo.\n");
            sc.nextLine(); 
            return;
        }

        if (indiceAuto == 0) {
            System.out.println("------------------------");
            System.out.println("Operacion Cancelada");
        } else if (indiceAuto >= 1 && indiceAuto <= autos.size()) {
            indiceReal = indiceAuto - 1;
            autos.remove(indiceReal);
            System.out.println("------------------------");
            System.out.println("Auto eliminado exitosamente");
        } else {
            System.out.println("------------------------");
            System.out.println("Número de auto inválido");
        }

    }

    public void venderAutos() {
        if (autos.isEmpty()) {
            System.out.println("------------------------");
            System.out.println("No hay autos disponibles.");
            return;
        }

        System.out.println("------------------------");
        System.out.println("        AUTOS:       ");
        System.out.println("------------------------");

        for (int i = 0; i < autos.size(); i++) {
            System.out.println((i + 1) + ". " + autos.get(i));
            System.out.println("");
        }

        int indiceAuto;
        try {
            System.out.print("Ingrese el número del auto que desea vender: ");
            indiceAuto = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("------------------------\n");
            System.out.println("ERROR: La entrada no es válida. Por favor, inténtalo de nuevo.\n");
            sc.nextLine(); 
            return;
        }
        

        if (indiceAuto >= 1 && indiceAuto <= autos.size()) {
            indiceReal = indiceAuto - 1;

            System.out.print("Nombre: ");
            String nombreComprador = sc.nextLine();
            

            if (nombreComprador.isEmpty()) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: Ingrese un dato valido.\n");
                return;
            } else if (nombreComprador.matches(".*\\d.*")) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: Ingrese un nombre valido.\n");
                return;
            } else if (nombreComprador.length() < 10) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: El nombre debe contener mas de 10 caracteres.\n");
                return;
            }

            int idComprador;
            try {
                System.out.print("ID del comprador: ");
                idComprador = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: Ingresaste un valor no válido para el ID. Deben ser números.\n");
                return;
            }

            String idString = String.valueOf(idComprador);

            assert idComprador >= 0 : "ERROR: ID no puede ser negativo";

            if (idString.length() > 10 && idString.length() < 8) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: El ID debe tener 10 caracteres\n");
                return;
            }

            int telefonoComprador;
            try {
                System.out.print("Teléfono: ");
                telefonoComprador = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: Ingresaste un valor no válido para el telefono. Deben ser números.\n");
                return;
            }

            String telString = String.valueOf(telefonoComprador);

            assert telefonoComprador >= 0 : "ERROR: El telefono no puede ser negativo";

            if (telString.length() != 10) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: El telefono debe contener 10 caracteres\n");
                return;
            }

            System.out.print("Dirección: ");
            String direccionComprador = sc.nextLine();

            if (direccionComprador.isEmpty()) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: Ingrese un dato valido.\n");
                return;
            } else if (direccionComprador.length() < 6 || direccionComprador.length() > 30) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: La direccion debe contener entre 6 y 30 caracteres.\n");
                return;
            }

            Auto autoVendido = autos.remove(indiceReal);
            Comprador comprador = new Comprador(nombreComprador, idComprador, telefonoComprador, direccionComprador, autoVendido);
            compradores.add(comprador);
            autosVendidos++;

            System.out.println("------------------------");
            System.out.println("Proceso completado: El auto ha sido vendido exitosamente.");

        } else {
            System.out.println("------------------------");
            System.out.println("Número de auto inválido");
        }
    }

    public void informeGeneral() {

        System.out.println("------------------------");
        System.out.println("        INFORME GENERAL:       ");
        System.out.println("------------------------\n");

        System.out.println("Cantidad de autos vendidos: " + autosVendidos);

        double totalIngresos = 0.0;

        // Calcular el total de ingresos por ventas
        for (int i = 0; i < autosVendidos; i++) {
            Comprador comprador = compradores.get(i);
            Auto auto = comprador.getAutoVendido();

            totalIngresos += auto.getPrecio();
        }

        double precioPromedio;

        if (autosVendidos > 0) {
            precioPromedio = totalIngresos / autosVendidos;
        } else {
            precioPromedio = 0.0;
        }

        System.out.println("Total de ingresos por ventas: $" + String.format("%.2f", totalIngresos));
        System.out.println("Precio promedio de venta: $" + String.format("%.2f", precioPromedio));
        System.out.println("--------");
        System.out.println("\nInformación de autos vendidos:");

        for (int i = 0; i < autosVendidos; i++) {
            Comprador comprador = compradores.get(i);
            Auto auto = comprador.getAutoVendido();

            System.out.println("");
            System.out.println("Auto " + (i + 1) + ":");
            System.out.println("Marca: " + auto.getMarca());
            System.out.println("Precio: $" + auto.getPrecio());
            System.out.println("Comprador: " + comprador.getNombre());
            System.out.println("ID: " + comprador.getId());
            System.out.println("Teléfono: " + comprador.getTelefono());
            System.out.println("Dirección: " + comprador.getDireccion());
            System.out.println();
        }
    }

}
