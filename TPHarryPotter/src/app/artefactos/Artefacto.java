package app.artefactos;

import app.interfaces.*;
import app.poderes.*;

public class Artefacto implements IEsMagico {

    public Artefacto(String nombre, double amplificadorDeDanio, double amplificadorDeCuración) {
        this.nombre = nombre;
        this.amplificadorDeDanio = amplificadorDeDanio;
        this.amplificadorDeCuración = amplificadorDeCuración;
    }

    private String nombre;

    private double amplificadorDeDanio;

    private double amplificadorDeCuración;

    private Poder poder;

    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAmplificadorDeDanio() {
        return amplificadorDeDanio;
    }

    public void setAmplificadorDeDanio(double amplificadorDeDanio) {
        this.amplificadorDeDanio = amplificadorDeDanio;
    }

    public double getAmplificadorDeCuración() {
        return amplificadorDeCuración;
    }

    public void setAmplificadorDeCuración(double amplificadorDeCuración) {
        this.amplificadorDeCuración = amplificadorDeCuración;
    }

    public Poder getPoder() {
        return poder;
    }

    public void setPoder(Poder poder) {
        this.poder = poder;
    }

    @Override
    public boolean esInvisibleAMuggles() {

        return false;
    }

    @Override
    public boolean esInvisible() {

        return false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}