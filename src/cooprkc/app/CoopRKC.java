package cooprkc.app;

import cooprkc.servicio.GestorSocios;
import java.util.Scanner;

public class CoopRKC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorSocios gestor = new GestorSocios();
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar socio");
            System.out.println("2. Mostrar socios");
            System.out.println("3. Filtrar socios por saldo");
            System.out.println("4. Mostrar suma total de saldos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> gestor.registrarSocio();
                case 2 -> gestor.listarSocios();
                case 3 -> {
                    System.out.print("Ingrese el saldo mínimo a filtrar: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    gestor.filtrarPorSaldo(valor);
                }
                case 4 -> gestor.sumaTotalSaldos();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}
