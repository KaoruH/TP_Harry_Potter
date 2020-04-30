package app.poderes.hechizos;

import app.poderes.Poder; 

public class Hechizo extends Poder{


    public Hechizo(String nombre, boolean esOscuro, int energiaMagica) {
        super(nombre);
        this.esOscuro = esOscuro;
        this.energiaMagica = energiaMagica;  
    }

	private boolean esOscuro;
    private int nivelDanio;
    private int nivelCuracion;
    private int energiaMagica;

    public boolean getEsOscuro() {
        return esOscuro;
    }

    public void setEsOscuro(boolean esOscuro) {
        this.esOscuro = esOscuro;
    }

    public int getNivelDanio() {
        return nivelDanio;
    }

    public void setNivelDanio(int nivelDanio) {
        this.nivelDanio = nivelDanio;
    }

    public int getNivelCuracion() {
        return nivelCuracion;
    }

    public void setNivelCuracion(int nivelCuracion) {
        this.nivelCuracion = nivelCuracion;
    }

    public int getEnergiaMagica() {
        return energiaMagica;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    

}