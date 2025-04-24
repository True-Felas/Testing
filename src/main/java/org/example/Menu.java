package org.example;

import java.util.Scanner;

public class Menu {
    private final Metodos metodos;

    public Menu() {
        this.metodos = new Metodos();
    }

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Introduce nombre de usuario");
            System.out.println("2. Introducir ingresos");
            System.out.println("3. Introducir gasto");
            System.out.println("4. Mostrar saldo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        metodos.introducirUsuario();
                        break;
                    case 2:
                        metodos.introducirIngreso();
                        break;
                    case 3:
                        metodos.introducirGasto();
                        break;
                    case 4:
                        metodos.mostrarSaldo();
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija entre 1 y 5.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, introduzca un número entre 1 y 5.");
            }
        } while (opcion != 5);

        sc.close();
    }
}