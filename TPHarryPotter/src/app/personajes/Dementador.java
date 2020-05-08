package app.personajes;

import java.util.ArrayList;
import java.util.List;

import app.artefactos.Artefacto;
import app.interfaces.IHaceHechizo;
import app.poderes.Poder;
import app.poderes.hechizos.Hechizo;

public class Dementador extends Criatura implements IHaceHechizo {

    public Dementador(String nombre, int salud) {
        super(nombre, salud);
        // TODO Auto-generated constructor stub
    }
    
    private List<Hechizo> hechizos = new ArrayList<>();

    @Override
    public int getEnergiaMagica() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setEnergiaMagica(int energiaMagica) {
        // TODO Auto-generated method stub

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
    public void atacar(Personaje personaje, String hechizo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void curarse(Hechizo hechizo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void defenderse(Hechizo hechizo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void usarHechizoOcio(Hechizo hechizo) {
        // TODO Auto-generated method stub

    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }
    
}