package controlador;

import java.util.Scanner;

public class AdminMenu {

    Scanner sc = new Scanner(System.in);
    AdminMetodos adminMetodos = new AdminMetodos();

    public void inventarioMenu() {

        boolean salir = true;

        while (salir) {
            System.out.println("------------------------");
            System.out.println("        INVENTARIO        ");
            System.out.println("------------------------\n");
            System.out.println("1. Agregar auto");
            System.out.println("2. Eliminar auto");
            System.out.println("3. Autos disponibles");
            System.out.println("4. Regresar al menu anterior");
            System.out.print("\nDigite su opcion: ");

            try {
                int op = sc.nextInt();

                switch (op) {
                    case 1 -> {
                        adminMetodos.añadirAutos();
                    }
                    case 2 -> {
                        adminMetodos.eliminarAutos();
                    }
                    case 3 -> {
                        adminMetodos.mostrarAutos();
                    }
                    case 4 -> {
                        salir = false;
                    }
                    default -> {
                        System.out.println("------------------------\n");
                        System.out.println("ERROR: ELIJA UNA OPCIÓN VÁLIDA\n");
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: INGRESE UN DATO VALIDO\n");
                sc.next();
            }

        }
    }

    public void VentasMenu() {

        boolean salir = true;

        while (salir) {
            System.out.println("------------------------");
            System.out.println("        VENTAS        ");
            System.out.println("------------------------\n");
            System.out.println("1.- Vender auto");
            System.out.println("2.- Autos disponibles");
            System.out.println("3.- Regresar al menu anterior");
            System.out.print("\nDigite su opcion: ");

            try {
                int op = sc.nextInt();

                switch (op) {
                    case 1 -> {
                        adminMetodos.venderAutos();
                    }
                    case 2 -> {
                        adminMetodos.mostrarAutos();
                    }
                    case 3 -> {
                        salir = false;
                    }
                    default -> {
                        System.out.println("------------------------\n");
                        System.out.println("ERROR: ELIJA UNA OPCIÓN VÁLIDA\n");
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: INGRESE UN DATO VALIDO\n");
                sc.next();
            }

        }
    }

    public void ContabilidadMenu() {

        boolean salir = true;

        while (salir) {
            System.out.println("------------------------");
            System.out.println("        CONTABILIDAD        ");
            System.out.println("------------------------\n");
            System.out.println("1. Contabilidad general");
            System.out.println("2.- Regresar al menu anterior");
            System.out.print("\nDigite su opcion: ");

            try {
                int op = sc.nextInt();

                switch (op) {
                    case 1 -> {
                        adminMetodos.informeGeneral();
                    }
                    case 2 -> {
                        salir = false;
                    }
                    default -> {
                        System.out.println("------------------------\n");
                        System.out.println("ERROR: ELIJA UNA OPCIÓN VÁLIDA\n");
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("------------------------\n");
                System.out.println("ERROR: INGRESE UN DATO VALIDO\n");
                sc.next();
            }

        }
    }

    
    
    
}
