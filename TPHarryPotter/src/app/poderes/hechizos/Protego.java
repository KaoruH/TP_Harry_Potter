package app.poderes.hechizos;

public class Protego extends HechizoDefensa{

    public Protego(String nombre, boolean esOscuro, int nivelCuracion, int energiaMagica){
        this.setNombre(nombre);
        this.setEsOscuro(esOscuro);
        this.setNivelCuracion(nivelCuracion);
        this.setEnergiaMagica(energiaMagica);

    }

}