package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.Poder;
import app.poderes.hechizos.*;

public class Elfo extends Criatura implements IHaceHechizo {

    public Elfo(String nombre, int salud) {
        super(nombre, salud);

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
    public void setPoder(Poder poder) { // El elfo no tiene "Poder"... Tenemos que crear uno? si

    }

    @Override
    public void aprender(Hechizo h) { // Está igual que en Wizard

        this.hechizos.add(h);

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) { // Está igual que en Wizard

        int b;
        int c = hechizo.getNivelDanio();

        if (personaje instanceof Wizard && ((Wizard) personaje).getArtefacto() != null) {

            b = (int) Math.round(c - (c * ((Wizard) personaje).getArtefacto().getAmplificadorDeCuración()));

        } else if (personaje instanceof Elfo && ((Elfo) personaje).getArtefacto() != null) {

            b = (int) Math.round(c - (c * ((Elfo) personaje).getArtefacto().getAmplificadorDeCuración()));

        }

        if (this.artefacto != null) {

            b = (int) Math.round(c + (c * this.artefacto.getAmplificadorDeDanio()));

        } else {
            b = c;
        }

        int a = personaje.getSalud() - b;

        if (a > 0) {

            personaje.setSalud(a);

        } else {

            personaje.setSalud(0);
        }

        a = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
        this.setEnergiaMagica(a);

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) { // Está igual que en Wizard

        for (Hechizo hechizo1 : this.hechizos) {

            if (hechizo1.getNombre().equals(hechizo)) {

                int b;
                int c = hechizo1.getNivelDanio();

                if (personaje instanceof Wizard && ((Wizard) personaje).getArtefacto() != null) {

                    b = (int) Math.round(c - (c * ((Wizard) personaje).getArtefacto().getAmplificadorDeCuración()));

                } else if (personaje instanceof Elfo && ((Elfo) personaje).getArtefacto() != null) {

                    b = (int) Math.round(c - (c * ((Elfo) personaje).getArtefacto().getAmplificadorDeCuración()));

                }

                if (this.artefacto != null) {

                    b = (int) Math.round(c + (c * this.artefacto.getAmplificadorDeDanio()));

                } else {

                    b = c;
                }

                int a = personaje.getSalud() - b;

                if (a > 0) {

                    personaje.setSalud(a);

                } else {

                    personaje.setSalud(0);
                }

                a = this.getEnergiaMagica() - hechizo1.getEnergiaMagica();
                this.setEnergiaMagica(a);

            }

        }

    }

    @Override
    public void curarse(Hechizo hechizo) {
        int a = this.getSalud() + hechizo.getNivelCuracion();

        if (a < 100) {

            this.setSalud(a);

        } else {

            this.setSalud(100);
        }

        a = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
        this.setEnergiaMagica(a);

    }

    @Override
    public void defenderse(Hechizo hechizo) {

        int a = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
        this.setEnergiaMagica(a);
    }

    @Override
    public void usarHechizoOcio(Hechizo hechizo) {

        int a = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
        this.setEnergiaMagica(a);
    }

}