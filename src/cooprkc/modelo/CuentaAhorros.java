package cooprkc.modelo;

public class CuentaAhorros extends Cuenta {
    private double interes; // porcentaje, ej: 0.05 = 5%

    public CuentaAhorros(String numeroCuenta, double interes) {
        super(numeroCuenta);
        this.interes = interes;
    }

    public void aplicarInteres() {
        saldo += saldo * interes;
    }

    @Override
    public String toString() {
        return "CuentaAhorros{" +
                "numeroCuenta='" + getNumeroCuenta() + '\'' +
                ", saldo=" + saldo +
                ", interes=" + interes +
                '}';
    }
}
