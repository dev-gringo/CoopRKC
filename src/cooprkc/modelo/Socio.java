package cooprkc.modelo;

public class Socio {
    private static int contador = 1;
    private final int id;
    private String nombre;
    private String cedula;   // 👈 nuevo campo
    private final Cuenta cuenta;

    public Socio(String nombre, String cedula, Cuenta cuenta) {
        this.id = contador++; // id autoincremental
        this.nombre = nombre;
        this.cedula = cedula;
        this.cuenta = cuenta;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    @Override
    public String toString() {
        return String.format(

                        "| %-2s | %-15s | %-13s | %-9.2f | %-13s |" ,

                id,
                nombre,
                cuenta.getNumeroCuenta(),
                cuenta.getSaldo(),
                cedula
        );
    }
}
