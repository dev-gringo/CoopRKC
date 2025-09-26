package cooprkc.modelo;

public class Socio {
    private String nombre;
    private int edad;
    private String documento;
    private double saldo; // 👈 Nuevo atributo

    public Socio(String nombre, int edad, String documento, double saldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.saldo = saldo;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getDocumento() { return documento; }
    public double getSaldo() { return saldo; }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nEdad: " + edad +
                "\nDocumento: " + documento +
                "\nSaldo: $" + saldo;
    }
}

