package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.transportes.*;

public class Wizard extends Persona implements IHaceMagia {

    public Wizard(String nombre, int edad, boolean magoOscuro, Poder poderInicial) {
        super(nombre, edad);
        this.magoOscuro = magoOscuro;
        this.poderInicial = poderInicial;
    }

    private int energiaMagica = 100; // max 150 - posible aumentar con artefactos/mascota:

    private List<Hechizo> hechizos = new ArrayList<>();

    private Escoba escoba;

    private Poder poderInicial;

    private Artefacto artefacto;

    private boolean magoOscuro;

    private Mascota mascota;

    private Varita varita;

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
    public void setPoder(Poder poder) { // puede servir para cambiar poder inicial? Si si, descomentar:

        // this.poderInicial = poder;

    }

    @Override
    public void aprender(Hechizo h) { // adiciona el hechizo a la lista de hechizos

        this.hechizos.add(h);

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) { // toma la salud del personaje atacado y resta el nivel
                                                               // de danio del hechizo

        int a = personaje.getSalud() - hechizo.getNivelDanio();

        personaje.setSalud(a);

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {

        for (Hechizo hechizo1 : this.hechizos) {

            if (hechizo1.getNombre().equals(hechizo)) {

                int a = personaje.getSalud() - hechizo1.getNivelDanio();

                personaje.setSalud(a);

            }

            // TODO -- else { System.out.println("Este hechizo no fue encontrado");} -- Es
            // necesario?

        }

    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Varita getVarita() {
        return varita;
    }

    public void setVarita(Varita varita) {
        this.varita = varita;
    }

}