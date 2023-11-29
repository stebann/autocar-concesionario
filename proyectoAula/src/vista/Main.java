package vista;

import controlador.AdminMenu;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        AdminMenu objeto = new AdminMenu();

        boolean salir = true;

        while (salir) {
            System.out.println("------------------------");
            System.out.println("        AUTOCAR        ");
            System.out.println("------------------------");
            System.out.println("\n       BIENVENIDO\n");
            System.out.println("1. Inventario");
            System.out.println("2. Ventas");
            System.out.println("3. Contabilidad");
            System.out.println("4. SALIR");
            System.out.print("\nDigite su opcion: ");

            try {
                int op = sc.nextInt();

                switch (op) {
                    case 1 -> {
                        objeto.inventarioMenu();
                    }
                    case 2 -> {
                        objeto.VentasMenu();
                    }
                    case 3 -> {
                        objeto.ContabilidadMenu();
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

}
