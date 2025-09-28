package cooprkc.servicio;

import cooprkc.modelo.Socio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cooperativa {
    private List<Socio> socios = new ArrayList<>();

    // Registrar socio
    public void registrarSocio(Socio socio) {
        socios.add(socio);
    }

    // Listar todos los socios
    public List<Socio> listarSocios() {
        return socios;
    }

    // Filtrar socios con saldo mínimo
    public List<Socio> filtrarPorSaldo(double saldoMinimo) {
        return socios.stream()
                .filter(s -> s.getCuenta().getSaldo() >= saldoMinimo)
                .collect(Collectors.toList());
    }

    // Sumar todos los saldos
    public double sumarSaldos() {
        return socios.stream()
                .map(s -> s.getCuenta().getSaldo())
                .reduce(0.0, Double::sum);
    }
}
