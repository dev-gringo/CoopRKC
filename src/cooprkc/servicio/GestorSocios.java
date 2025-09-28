package cooprkc.servicio;

import cooprkc.modelo.Socio;
import cooprkc.modelo.CuentaAhorros;

import java.util.ArrayList;
import java.util.List;

public class GestorSocios {
    private List<Socio> socios = new ArrayList<>();

    public void registrarSocio(Socio socio) {
        socios.add(socio);
    }

    public void listarSocios() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios registrados.");
            return;
        }

        System.out.printf("%-5s %-15s %-15s %-10s%n", "ID", "Nombre", "Número Cuenta", "Saldo");
        System.out.println("---------------------------------------------------");

        socios.forEach(s -> System.out.printf(
                "%-5d %-15s %-15s %-10.2f%n",
                s.getId(),
                s.getNombre(),
                s.getCuenta().getNumeroCuenta(),
                s.getCuenta().getSaldo()
        ));
    }


    // FILTER
    public void filtrarPorSaldo(double saldoMinimo) {
        socios.stream()
                .filter(s -> s.getCuenta().getSaldo() >= saldoMinimo)
                .forEach(System.out::println);
    }

    // REDUCE
    public double sumaTotalSaldos() {
        return socios.stream()
                .map(s -> s.getCuenta().getSaldo())
                .reduce(0.0, Double::sum);
    }

    // Depósito
    public void depositar(int idSocio, double monto) {
        socios.stream()
                .filter(s -> s.getId() == idSocio)
                .findFirst()
                .ifPresent(s -> s.getCuenta().depositar(monto));
    }

    // Retiro con control de errores
    public void retirar(int idSocio, double monto) {
        socios.stream()
                .filter(s -> s.getId() == idSocio)
                .findFirst()
                .ifPresent(s -> s.getCuenta().retirar(monto));
    }

    // Aplicar interés a cuenta de ahorro
    public void aplicarInteres(int idSocio) {
        socios.stream()
                .filter(s -> s.getId() == idSocio)
                .findFirst()
                .ifPresent(s -> {
                    if (s.getCuenta() instanceof CuentaAhorros ahorro) {
                        ahorro.aplicarInteres();
                    } else {
                        System.out.println("El socio no tiene cuenta de ahorro.");
                    }
                });
    }
}
