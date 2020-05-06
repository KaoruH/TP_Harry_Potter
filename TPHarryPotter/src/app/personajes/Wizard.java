package app.personajes;

import java.util.*;

import app.JuegoHP;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.transportes.*;

public class Wizard extends Persona implements IHaceHechizo {

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
    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) { // toma la salud del personaje atacado y resta el nivel
                                                               // de danio del hechizo

        int b;
        int c = hechizo.getNivelDanio();

        if (hechizo.getEsOscuro() && !this.getMagoOscuro()) {  // si el hechizo es oscuro, el brujo se convierte en oscuro y el daño *2 una vez

            this.setMagoOscuro(true);

            c *= 2;

            JuegoHP juego = new JuegoHP();

            juego.imprimirConversionMagoOscuro(this.getNombre()); // sacar duda si se puede llamar acá asi o si es mejor escribir otro metodo allá
            
        }

        if (personaje instanceof Wizard){ // Si el oponente tiene artefacto con amplificador curacion, se resta este del daño

            if (((Wizard) personaje).getArtefacto() != null) {

                b = (int) Math.round(c - (c * ((Wizard) personaje).getArtefacto().getAmplificadorDeCuración()));
                
            }
            
        } else if(personaje instanceof Elfo){

            if (((Elfo) personaje).getArtefacto() != null) {

                b = (int) Math.round(c - (c * ((Elfo) personaje).getArtefacto().getAmplificadorDeCuración()));
                
            }

        }

        if (this.artefacto != null) {

            b = (int) Math.round(c + (c * this.artefacto.getAmplificadorDeDanio()));
        } else {

            b = c;
        }


        int a = personaje.getSalud() - b;

        personaje.setSalud(a);

        a = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
        this.setEnergiaMagica(a);

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {

        for (Hechizo hechizo1 : this.hechizos) {

            if (hechizo1.getNombre().equals(hechizo)) {

                int b;
                int c = hechizo1.getNivelDanio();

                if (hechizo1.getEsOscuro() & !this.getMagoOscuro()) { // si el hechizo es oscuro, el brujo se convierte en oscuro y el daño *2 una vez

                    this.setMagoOscuro(true);

                    c *= 2;
                    
                }

                if (personaje instanceof Wizard){ // Si el oponente tiene artefacto con amplificador curacion, se resta este del daño

                    if (((Wizard) personaje).getArtefacto() != null) {
        
                        b = (int) Math.round(c - (c * ((Wizard) personaje).getArtefacto().getAmplificadorDeCuración()));
                        
                    }
                    
                } else if(personaje instanceof Elfo){
        
                    if (((Elfo) personaje).getArtefacto() != null) {
        
                        b = (int) Math.round(c - (c * ((Elfo) personaje).getArtefacto().getAmplificadorDeCuración()));
                        
                    }
        
                }

                if (this.artefacto != null) {

                    b = (int) Math.round(c + (c * this.artefacto.getAmplificadorDeDanio()));

                } else {

                    b = c;
                }

                int a = personaje.getSalud() - b;

                personaje.setSalud(a);

                a = this.getEnergiaMagica() - hechizo1.getEnergiaMagica();
                this.setEnergiaMagica(a);

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

   @Override
    public void curarse(Hechizo hechizo) {

        if (this.getSalud() <= 100){

            int a = this.getSalud() + hechizo.getNivelCuracion();

        this.setSalud(a);

        a = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
        this.setEnergiaMagica(a);

        }

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