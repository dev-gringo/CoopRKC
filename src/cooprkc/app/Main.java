package cooprkc.app;

import cooprkc.modelo.CuentaAhorros;
import cooprkc.modelo.Socio;
import cooprkc.servicio.Cooperativa;
import cooprkc.transacciones.Deposito;
import cooprkc.transacciones.Retiro;

public class Main {
    public static void main(String[] args) {
        Cooperativa coop = new Cooperativa();

        // Crear socios
        Socio s1 = new Socio("johan orrego", "1001845512");
        Socio s2 = new Socio("jorge jaramillo", "32287235");
        coop.registrarSocio(s1);
        coop.registrarSocio(s2);

        // Crear cuentas de ahorro
        CuentaAhorros c1 = new CuentaAhorros("C001", 0.05);
        CuentaAhorros c2 = new CuentaAhorros("C002", 0.03);
        s1.agregarCuenta(c1);
        s2.agregarCuenta(c2);

        // Operaciones
        new Deposito(c1, 1000000).ejecutar();
        new Retiro(c1, 200000).ejecutar();
        new Retiro(c2, 10000).ejecutar(); // debe dar error porque el saldo es 0
        c1.aplicarInteres();

        // Programación funcional
        System.out.println("\nListado de socios:");
        coop.getSocios().stream()
                .map(Socio::getNombre)
                .forEach(System.out::println);

        System.out.println("\n Cuentas con saldo mayor a 500000:");
        coop.getSocios().stream()
                .flatMap(s -> s.getCuentas().stream())
                .filter(c -> c.getSaldo() > 500000)
                .forEach(System.out::println);

        System.out.println("\n Total de dinero en la cooperativa:");
        double total = coop.getSocios().stream()
                .flatMap(s -> s.getCuentas().stream())
                .mapToDouble(c -> c.getSaldo())
                .reduce(0, Double::sum);
        System.out.println("Total = " + total);
    }
}
