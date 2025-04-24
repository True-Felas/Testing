package org.example;

import java.util.Scanner;

public class Metodos {
    private String usuario;
    private double saldo = 0.0;
    private boolean usuarioIntroducido = false;

    private final Scanner sc = new Scanner(System.in);

    public void introducirUsuario() {
        while (true) {
            System.out.print("Ingrese el nombre del usuario: ");
            this.usuario = sc.nextLine().trim();

            if (!usuario.isEmpty()) {
                this.usuarioIntroducido = true;
                System.out.println("Bienvenido, " + usuario + "!");
                break;
            } else {
                System.out.println("El nombre de usuario no puede estar vacío. Inténtelo nuevamente.");
            }
        }
    }

    public void introducirIngreso() {
        if (!usuarioIntroducido) {
            System.out.println("Debe introducir el nombre del usuario primero.");
            return;
        }

        double ingreso;
        while (true) {
            System.out.println(usuario + ", introduzca el monto de su ingreso:");
            System.out.println("Concepto disponible: Nómina");
            System.out.print("Ingrese la cantidad: ");

            try {
                String entrada = sc.nextLine().replaceAll("\\s++", "");
                ingreso = Double.parseDouble(entrada);

                if (ingreso > 0) {
                    this.saldo += ingreso;
                    System.out.println("Ingreso exitoso. Su saldo ahora es de: " + saldo + "€");
                    break;
                } else {
                    System.out.println("El monto del ingreso debe ser mayor a 0. Inténtelo nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, introduzca un número válido.");
            }
        }
    }

    public void introducirGasto() {
        if (!usuarioIntroducido) {
            System.out.println("Debe introducir el nombre del usuario primero.");
            return;
        }

        String tipoGasto;
        while (true) {
            System.out.println("\n" + usuario + ", seleccione el tipo de gasto:");
            System.out.println("1. Vacaciones");
            System.out.println("2. Alquiler");
            System.out.println("3. Vicios variados");
            System.out.print("Ingrese el número correspondiente: ");

            try {
                int opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        tipoGasto = "Vacaciones";
                        break;
                    case 2:
                        tipoGasto = "Alquiler";
                        break;
                    case 3:
                        tipoGasto = "Vicios variados";
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, introduzca un número válido.");
            }
        }

        double gasto;
        while (true) {
            System.out.println(usuario + ", introduzca el monto de su gasto (" + tipoGasto + "):");

            try {
                String entrada = sc.nextLine().replaceAll("\\s++", "");
                gasto = Double.parseDouble(entrada);

                if (gasto <= 0) {
                    System.out.println("El monto del gasto debe ser mayor a 0. Inténtelo nuevamente.");
                } else if (gasto > this.saldo) {
                    System.out.println("No puede realizar este gasto. El saldo es insuficiente (" + this.saldo + "€).");
                } else {
                    this.saldo -= gasto;
                    System.out.println("Gasto de " + tipoGasto + " registrado exitosamente. Su saldo ahora es de: " + saldo + "€");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, introduzca un número válido.");
            }
        }
    }

    public void mostrarSaldo() {
        if (!usuarioIntroducido) {
            System.out.println("Debe introducir el nombre del usuario primero.");
            return;
        }

        System.out.println(usuario + ", su saldo actual es de: " + saldo + "€");
    }
}