package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;

public class Dementor extends Criatura implements IHaceMagia {

    public Dementor(String nombre, int salud, Poder poderInicial) {
        super(nombre, salud);
        this.poderInicial = poderInicial;
    }

    private List<Hechizo> hechizos = new ArrayList<>();

    private Poder poderInicial;

    private Poder ultimate;

    @Override
    public int getEnergiaMagica() {
        return 0;
    }

    @Override
    public void setEnergiaMagica(int energiaMagica) {
    }

    @Override
    public Poder getPoderInicial() {
        return this.poderInicial;
    }

    @Override
    public void setPoder(Poder poder) {
        this.poderInicial = poder;

    }

    @Override
    public Artefacto getArtefacto() {
        return null;
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

    public int atacar(Personaje personaje, Poder poder) {

        int ataqueMaximo;
        int ataqueMinimo;
        int a, b;

        if (poder instanceof AbsorberFelicidad) {
            AbsorberFelicidad absorberFelicidad = (AbsorberFelicidad) poder;

            ataqueMaximo = absorberFelicidad.getAtaqueMaximo();
            ataqueMinimo = absorberFelicidad.getAtaqueMinimo();
            
        } else {
            BesoDelDementor besoDelDementor = (BesoDelDementor) poder;

            ataqueMaximo = besoDelDementor.getAtaqueMaximo();
            ataqueMinimo = besoDelDementor.getAtaqueMinimo();
        }

        a = (int) (Math.random() * ((ataqueMaximo - ataqueMinimo) + 1)) + ataqueMinimo;

        b = personaje.getSalud() - a;

        personaje.setSalud(b);

        return a;
    }

    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public void setArtefacto(Artefacto artefacto) {
    }

    public Poder getUltimate() {
        return ultimate;
    }

    public void setUltimate(Poder ultimate) {
        this.ultimate = ultimate;
    }

}