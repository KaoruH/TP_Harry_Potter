package app.transportes;

public class Transporte {

    public Transporte(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    private String nombre;

    private String tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}