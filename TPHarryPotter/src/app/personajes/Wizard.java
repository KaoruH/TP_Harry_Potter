package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.transportes.*;

public class Wizard extends Persona implements IHaceMagia{


    public Wizard(String nombre, int edad, boolean magoOscuro, Poder poderInicial) {
        super(nombre, edad);
        this.magoOscuro = magoOscuro;
        this.poderInicial = poderInicial;
    }

    private int energiaMagica = 100; //max 150 - posible aumentar con artefactos/mascota:

    private List<Hechizo> hechizos = new ArrayList<>();

    private Escoba escoba;

    private Poder poderInicial;

    private Artefacto artefacto;

    private boolean magoOscuro;

    private Mascota mascota;

    public int getEnergiaMagica() {
        return energiaMagica;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public Escoba getEscoba() {
        return escoba;
    }

    public void setEscoba(Escoba escoba) {
        this.escoba = escoba;
    }

    public Poder getPoderInicial() {
        return poderInicial;
    }

    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

    public Artefacto getArtefacto() {
        return artefacto;
    }

    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto;
    }

    public boolean getMagoOscuro() {
        return magoOscuro;
    }

    public void setMagoOscuro(boolean magoOscuro) {
        this.magoOscuro = magoOscuro;
    }

    @Override
    public void setPoder(Poder poder) {


    }

    @Override
    public void aprender(Hechizo h) {


    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {


    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {


    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    

}