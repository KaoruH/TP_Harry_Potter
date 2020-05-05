package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.transportes.*;

public class Wizard extends Persona implements IHaceMagia {

    public Wizard(String nombre, int salud, int energiaMagica, boolean magoOscuro, Poder poderInicial) {
        super(nombre, salud);
        this.energiaMagica = energiaMagica;
        this.magoOscuro = magoOscuro;
        this.poderInicial = poderInicial;
    }

    private int energiaMagica;  // max 150 - posible aumentar con artefactos/mascota:

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
    public void setPoder(Poder poder) { // cambia el poderInicial

        this.poderInicial = poder;

    }

    @Override
    public void aprender(Hechizo h) { // adiciona el hechizo a la lista de hechizos

        this.hechizos.add(h);

        System.out.println(" [ Aprendiste el hechizo " + h.getNombre() + " ] ");

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) { // toma la salud del personaje atacado y resta el nivel
                                                               // de danio del hechizo

        int b;
        int c = hechizo.getNivelDanio();

        if (this.artefacto != null) {

            b = (int) Math.round(c + (c * this.artefacto.getAmplificadorDeDanio()));
        } else {

            b = c;
        }

        int a = personaje.getSalud() - b;

        personaje.setSalud(a);

        a = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
        this.setEnergiaMagica(a);

        System.out.println(" [ Atacaste " + personaje.getNombre() + " y consumiste " + hechizo.getEnergiaMagica()
                + " de energia mágica ] ");
        System.out.println(" [ La salud actual de " + personaje.getNombre() + " es de " + personaje.getSalud() + " ] ");

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {

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

                a = this.getEnergiaMagica() - hechizo1.getEnergiaMagica();
                this.setEnergiaMagica(a);

                System.out.println(" [ Atacaste " + personaje.getNombre() + " y consumiste "
                        + hechizo1.getEnergiaMagica() + " de energia mágica ] ");
                System.out.println(
                        " [ " + personaje.getNombre() + " tiene " + personaje.getSalud() + " puntos de vida ] ");

            } else {

                System.out.println(" [ El ataque falló ] ");
            }

        }

    }

    public boolean recibirCarta() {

        return true;

    }

    public boolean tomarDecision(int a) {

        if (a == 1) {
            return true;
        } else {
            return false;
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

   /** @Override  TODO
    public void curarse(Hechizo hechizo) {

        int a = this.getSalud() + hechizo.getNivelCuracion();

        this.setSalud(a);

        a = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
        this.setEnergiaMagica(a);

    }

    @Override
    public void defenderse() {
        // TODO Auto-generated method stub

    }

    @Override
    public void usarHechizoOcio() {
        // TODO Auto-generated method stub

    }

    */

}