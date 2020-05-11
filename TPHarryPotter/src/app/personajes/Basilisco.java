package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;

public class Basilisco extends Criatura implements IHaceMagia {

    public Basilisco(String nombre, int salud, int energiaMagica, boolean magoOscuro) {
        super(nombre, salud);
        this.energiaMagica = energiaMagica;
        this.magoOscuro = magoOscuro;
    }

    private List<Hechizo> hechizos = new ArrayList<>();

    private int energiaMagica;

    private boolean magoOscuro;



    @Override
    public int getEnergiaMagica() {
        return energiaMagica;
    }

    @Override
    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;

    }

    @Override
    public Poder getPoderInicial() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPoder(Poder poder) {
        // TODO Auto-generated method stub

    }

    @Override
    public Artefacto getArtefacto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void aprender(Hechizo h) {
        // TODO Auto-generated method stub

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) { //TODO radom de hechizos de la lista danioMedio2
        // TODO Auto-generated method stub

    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public boolean isMagoOscuro() {
        return magoOscuro;
    }

    public void setMagoOscuro(boolean magoOscuro) {
        this.magoOscuro = magoOscuro;
    }



}