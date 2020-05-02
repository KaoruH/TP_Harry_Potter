package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.Poder;
import app.poderes.hechizos.*;

public class Elfo extends Criatura implements IHaceMagia {

    public Elfo(String nombre, int edad) {
        super(nombre, edad);

    }

    private int energiaMagica = 150;

    private Artefacto artefacto;

    private List<Hechizo> hechizos = new ArrayList<>();

    public int getEnergiaMagica() {
        return energiaMagica;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    public Artefacto getArtefacto() {
        return artefacto;
    }

    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    @Override
    public Poder getPoderInicial() {

        return null; // Devuelve null porque el elfo no tiene PoderInicial y el método pide return
    }

    @Override
    public void setPoder(Poder poder) { // El elfo no tiene "Poder"... Tenemos que crear uno?

    }

    @Override
    public void aprender(Hechizo h) { // Está igual que en Wizard

        this.hechizos.add(h);

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) { // Está igual que en Wizard

        int b;
        int c = hechizo.getNivelDanio();

        if (this.artefacto != null) {

            b = (int) Math.round(c + (c * this.artefacto.getAmplificadorDeDanio()));
        } else {

            b = c;
        }

        int a = personaje.getSalud() - b;

        personaje.setSalud(a);

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) { // Está igual que en Wizard

        for (Hechizo hechizo1 : this.hechizos) {

            if (hechizo1.getNombre().equals(hechizo)) {

                int b;
                int c = hechizo1.getNivelDanio();

                if (this.artefacto != null) {

                    b = (int) Math.round(c + (c * this.artefacto.getAmplificadorDeDanio()));

                } else {

                    b = c;
                }

                int a = personaje.getSalud() - b;

                personaje.setSalud(a);

            }

            // TODO -- else { System.out.println("Este hechizo no fue encontrado");} -- Es
            // necesario?

        }

    }

}