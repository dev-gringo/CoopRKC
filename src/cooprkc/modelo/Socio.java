package cooprkc.modelo;

public class Socio {
    private static int contador = 1;
    private final int id;
    private String nombre;
    private final Cuenta cuenta;

    public Socio(String nombre, Cuenta cuenta) {
        this.id = contador++; // id autoincremental
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    @Override
    public String toString() {
        return String.format(
                "+----+-----------------+---------------+-----------+\n" +
                        "| %-2s | %-15s | %-13s | %-9.2f |\n" +
                        "+----+-----------------+---------------+-----------+",
                id,
                nombre,
                cuenta.getNumeroCuenta(),
                cuenta.getSaldo()
        );
    }
}
