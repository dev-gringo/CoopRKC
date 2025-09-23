package cooprkc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Socio {
    private String nombre;
    private String cedula;
    private List<Cuenta> cuentas;

    public Socio(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        // Validar que no exista el mismo número de cuenta
        boolean existe = cuentas.stream()
                .anyMatch(c -> c.getNumeroCuenta().equals(cuenta.getNumeroCuenta()));
        if (existe) {
            throw new IllegalArgumentException("El número de cuenta ya existe para este socio.");
        }
        cuentas.add(cuenta);
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", cuentas=" + cuentas +
                '}';
    }
}
