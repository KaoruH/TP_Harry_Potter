package app.artefactos;

import app.interfaces.*;
import app.poderes.*;

public class Artefacto implements IEsMagico{

    private String nombre;

    private double amplificadorDeDanio;

    private double amplificadorDeCuración;

    private Poder poder;

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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean esInvisible() {
        // TODO Auto-generated method stub
        return false;
    }

}