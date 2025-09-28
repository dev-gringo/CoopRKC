package cooprkc.modelo;

public class CuentaAhorros extends Cuenta {
    private static final double INTERES = 0.02; // 2% de interés

    public CuentaAhorros(String numeroCuenta, double saldoInicial) {
        super(numeroCuenta);
        depositar(saldoInicial); // Así se carga el saldo inicial
    }

    public void aplicarInteres() {
        this.saldo += this.saldo * INTERES;
    }

    @Override
    public String toString() {
        return "CuentaAhorros {" +
                "Número='" + getNumeroCuenta() + '\'' +
                ", Saldo=" + saldo +
                '}';
    }
}
