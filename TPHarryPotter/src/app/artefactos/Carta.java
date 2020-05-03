package app.artefactos;

public class Carta extends Artefacto{

    public Carta(String nombre, double amplificadorDeDanio, double amplificadorDeCuración) {
        super(nombre, amplificadorDeDanio, amplificadorDeCuración);
        
    }

    public Carta(String nombre, String sender){
        super(nombre);
        this.sender = sender;
    }

    private String sender;

    private String contenido;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}