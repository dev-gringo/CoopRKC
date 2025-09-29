package cooprkc.servicio;

import cooprkc.modelo.*;
import cooprkc.transacciones.Deposito;
import cooprkc.transacciones.Retiro;
import cooprkc.transacciones.Transaccion;

import java.util.ArrayList;
import java.util.List;

public class GestorSocios {
    private final List<Socio> socios = new ArrayList<>();
    //registrar socios
    public void registrarSocio(Socio socio) {
        socios.add(socio);
    }

    // Listar socios completos
    public void listarSocios() {
        // Mostrar encabezado
        System.out.println("+----+-----------------+---------------+-----------+---------------+");
        System.out.println("| ID | Nombre          | Número Cuenta | Saldo     | Cédula        |");
        System.out.println("+----+-----------------+---------------+-----------+---------------+");

        // Mostrar cada socio
        socios.forEach(s -> System.out.println(s.toString()));

        // Línea final de la tabla
        System.out.print("+----+-----------------+---------------+-----------+---------------+");
    }


    // Filtrar por saldo mínimo (filter)
    public void filtrarPorSaldo(double saldoMinimo) {
        socios.stream()
                .filter(s -> s.getCuenta().getSaldo() >= saldoMinimo)
                .forEach(System.out::println);
    }

    // Sumar todos los saldos (reduce)
    public double sumaTotalSaldos() {
        return socios.stream()
                .map(s -> s.getCuenta().getSaldo())
                .reduce(0.0, Double::sum);
    }

    // Depósito usando la interfaz Transaccion
    public void depositar(int idSocio, double monto) {
        socios.stream()
                .filter(s -> s.getId() == idSocio)
                .findFirst()
                .ifPresent(s -> {
                    Transaccion deposito = new Deposito(s.getCuenta(), monto);
                    deposito.ejecutar();
                    System.out.println("hecho: " + deposito);
                });
    }

    //  Retiro usando la interfaz Transaccion
    public void retirar(int idSocio, double monto) {
        socios.stream()
                .filter(s -> s.getId() == idSocio)
                .findFirst()
                .ifPresent(s -> {
                    try {
                        Transaccion retiro = new Retiro(s.getCuenta(), monto);
                        retiro.ejecutar();
                        System.out.println("listo. " + retiro);
                    } catch (IllegalStateException e) {
                        System.out.println("Error en el retiro: " + e.getMessage());
                    }
                });
    }

    //  Aplicar interés a la cuenta de ahorro
    public void aplicarInteres(int idSocio) {
        socios.stream()
                .filter(s -> s.getId() == idSocio)
                .findFirst()
                .ifPresent(s -> {
                    if (s.getCuenta() instanceof CuentaAhorros ahorro) {
                        ahorro.aplicarInteres();
                        System.out.println("Se aplicó interés a la cuenta " + ahorro.getNumeroCuenta());
                    } else {
                        System.out.println("El socio no tiene cuenta de ahorro.");
                    }
                });
    }
}
