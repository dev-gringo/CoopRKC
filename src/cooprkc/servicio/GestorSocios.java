package cooprkc.servicio;

import cooprkc.modelo.Socio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorSocios {
    private List<Socio> socios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Registrar socio
    public void registrarSocio() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese documento: ");
        String documento = scanner.nextLine();

        System.out.print("Ingrese saldo inicial: ");
        double saldo = Double.parseDouble(scanner.nextLine());

        socios.add(new Socio(nombre, edad, documento, saldo));
        System.out.println("Socio registrado con éxito.");
    }

    // Listar socios con Streams
    public void listarSocios() {
        System.out.println("\nLista de socios registrados:");
        socios.stream().forEach(s -> {
            System.out.println(s + "\n");
        });
    }

    // Filtrar socios con saldo mayor a un valor
    public void filtrarPorSaldo(double valor) {
        System.out.println("\nSocios con saldo mayor a $" + valor + ":");
        socios.stream()
                .filter(s -> s.getSaldo() > valor)
                .forEach(s -> System.out.println(s + "\n"));
    }

    // Suma total de saldos
    public void sumaTotalSaldos() {
        double total = socios.stream()
                .mapToDouble(Socio::getSaldo)
                .sum();
        System.out.println("\nSuma total de saldos en la cooperativa: $" + total);
    }
}
