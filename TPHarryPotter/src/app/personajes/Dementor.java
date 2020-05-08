package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;

public class Dementor extends Criatura implements IHaceMagia {

    public Dementor(String nombre, int salud, int energiaMagica, boolean magoOscuro, Poder poderInicial) {
        super(nombre, salud);
        this.energiaMagica = energiaMagica;
        this.magoOscuro = magoOscuro;
        this.poderInicial = poderInicial;
    }

    private List<Hechizo> hechizos = new ArrayList<>();

    private Poder poderInicial;

    private int energiaMagica;

    private boolean magoOscuro;

    private Artefacto artefacto;

    private Poder ultimate;

    @Override
    public int getEnergiaMagica() {
        return this.energiaMagica;
    }

    @Override
    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
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
        return this.artefacto;
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
        int energiaMagicaMaxima;
        int energiaMagicaMinima;

        if (poder instanceof AbsorberFelicidad) {
            AbsorberFelicidad absorberFelicidad = (AbsorberFelicidad) poder;

            ataqueMaximo = absorberFelicidad.getAtaqueMaximo();
            ataqueMinimo = absorberFelicidad.getAtaqueMinimo();
            energiaMagicaMaxima = absorberFelicidad.getEnergiaMagicaMaxima();
            energiaMagicaMinima = absorberFelicidad.getAtaqueMinimo();
            
        } else {
            BesoDelDementor besoDelDementor = (BesoDelDementor) poder;

            ataqueMaximo = besoDelDementor.getAtaqueMaximo();
            ataqueMinimo = besoDelDementor.getAtaqueMinimo();
            energiaMagicaMaxima = besoDelDementor.getEnergiaMagicaMaxima();
            energiaMagicaMinima = besoDelDementor.getAtaqueMinimo();
        }

        int a = (int) (Math.random() * ((ataqueMaximo - ataqueMinimo) + 1)) + ataqueMinimo;

        int b = personaje.getSalud() - a;

        personaje.setSalud(b);

        a = (int) (Math.random() * ((energiaMagicaMaxima - energiaMagicaMinima) + 1)) + energiaMagicaMinima;

        this.energiaMagica -= a;

        return a;
    }

    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

    public boolean isMagoOscuro() {
        return magoOscuro;
    }

    public void setMagoOscuro(boolean magoOscuro) {
        this.magoOscuro = magoOscuro;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto;
    }

    public Poder getUltimate() {
        return ultimate;
    }

    public void setUltimate(Poder ultimate) {
        this.ultimate = ultimate;
    }

}