package cooprkc.modelo;

public class Socio {
    private String nombre;
    private int edad;
    private String documento;

    public Socio(String nombre, int edad, String documento) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Socio {" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", documento='" + documento + '\'' +
                '}';
    }
}
