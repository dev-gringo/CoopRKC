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
        return String.format("CuentaAhorros [Número: %s | Saldo: $%,.2f | Interés: %.2f%%]",
                getNumeroCuenta(), saldo, interes * 100);
    }

}
