package cooprkc.app;

import cooprkc.modelo.CuentaAhorros;
import cooprkc.modelo.Socio;
import cooprkc.servicio.Cooperativa;
import cooprkc.transacciones.Deposito;
import cooprkc.transacciones.Retiro;

import java.util.ArrayList;
import java.util.Scanner;

public class CoopRKC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Socio> socios = new ArrayList<>();

        System.out.println("=== Bienvenido a CoopRKC ===");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar socio");
            System.out.println("2. Mostrar socios");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese la edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer

                    System.out.print("Ingrese el documento: ");
                    String documento = scanner.nextLine();

                    Socio nuevoSocio = new Socio(nombre, edad, documento);
                    socios.add(nuevoSocio);

                    System.out.println("Socio agregado con éxito.");
                    break;

                case 2:
                    System.out.println("\n Lista de socios registrados:");
                    if (socios.isEmpty()) {
                        System.out.println("No hay socios registrados.");
                    } else {
                        for (Socio s : socios) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    continuar = false;
                    System.out.println("Saliendo de CoopRKC...");
                    break;

                default:
                    System.out.println(" Opción inválida, intente de nuevo.");
            }
        }

        scanner.close();
    }
}
