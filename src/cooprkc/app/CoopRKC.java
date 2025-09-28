package cooprkc.app;

import cooprkc.modelo.*;
import cooprkc.servicio.GestorSocios;

import java.util.Scanner;

public class CoopRKC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorSocios gestor = new GestorSocios();

        int opcion;
        do {
            System.out.println("\n===== COOPERATIVA RKC =====");
            System.out.println("1. Registrar socio");
            System.out.println("2. Listar socios");
            System.out.println("3. Filtrar socios por saldo mínimo");
            System.out.println("4. Sumar saldos de todos los socios");
            System.out.println("5. Depositar dinero");
            System.out.println("6. Retirar dinero");
            System.out.println("7. Aplicar interés a cuenta de ahorro");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese nombre del socio: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese número de cuenta: ");
                    String numeroCuenta = sc.nextLine();

                    System.out.print("Ingrese saldo inicial: ");
                    double saldoInicial = sc.nextDouble();
                    sc.nextLine();

                    Socio socio = new Socio(nombre, new CuentaAhorros(numeroCuenta, saldoInicial));
                    gestor.registrarSocio(socio);

                    System.out.println("✅ Socio registrado con éxito.");
                }
                case 2 -> gestor.listarSocios();
                case 3 -> {
                    System.out.print("Ingrese el saldo mínimo: ");
                    double minimo = sc.nextDouble();
                    sc.nextLine();
                    gestor.filtrarPorSaldo(minimo);
                }
                case 4 -> {
                    double total = gestor.sumaTotalSaldos();
                    System.out.println("💰 La suma de todos los saldos es: " + total);
                }
                case 5 -> {
                    System.out.print("Ingrese ID del socio: ");
                    int idDeposito = sc.nextInt();
                    System.out.print("Ingrese monto a depositar: ");
                    double montoDeposito = sc.nextDouble();
                    sc.nextLine();
                    gestor.depositar(idDeposito, montoDeposito);
                }
                case 6 -> {
                    System.out.print("Ingrese ID del socio: ");
                    int idRetiro = sc.nextInt();
                    System.out.print("Ingrese monto a retirar: ");
                    double montoRetiro = sc.nextDouble();
                    sc.nextLine();
                    try {
                        gestor.retirar(idRetiro, montoRetiro);
                    } catch (Exception e) {
                        System.out.println("⚠️ " + e.getMessage());
                    }
                }
                case 7 -> {
                    System.out.print("Ingrese ID del socio: ");
                    int idInteres = sc.nextInt();
                    sc.nextLine();
                    gestor.aplicarInteres(idInteres);
                }
                case 0 -> System.out.println("👋 Saliendo del sistema...");
                default -> System.out.println("❌ Opción inválida, intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
