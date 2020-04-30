package app.personajes;

public abstract class Personaje {

    public Personaje(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    private String nombre;

    private int salud = 100;

    private int edad;

    public boolean estaVivo(){
        //TODO
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   

    

}