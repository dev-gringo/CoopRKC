package cooprkc.transacciones;


import cooprkc.modelo.Cuenta;

public class Retiro implements Transaccion {
    private final Cuenta cuenta;
    private double monto;

    public Retiro(Cuenta cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        cuenta.retirar(monto);
    }

    @Override
    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Retiro de $" + monto + " de la cuenta " + cuenta.getNumeroCuenta();
    }
}
