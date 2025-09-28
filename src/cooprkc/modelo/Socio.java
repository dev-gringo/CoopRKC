package cooprkc.modelo;

public class Socio {
    private static int contador = 1;
    private int id;
    private String nombre;
    private Cuenta cuenta;

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
        return "Socio {" +
                "ID=" + id +
                ", Nombre='" + nombre + '\'' +
                ", " + cuenta +
                '}';
    }
}
