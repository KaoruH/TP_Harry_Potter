package app.poderes;

public class AbsorberFelicidad extends Poder{

    public AbsorberFelicidad(String nombre, int ataqueMaximo, int ataqueMinimo) {
        super(nombre);
        this.ataqueMaximo = ataqueMaximo;
        this.ataqueMinimo = ataqueMinimo;
    }

    private int ataqueMaximo;

    private int ataqueMinimo;

    private int energiaMagicaMaxima;

    private int energiaMagicaMinima;

    public int getAtaqueMaximo() {
        return ataqueMaximo;
    }

    public void setAtaqueMaximo(int ataqueMaximo) {
        this.ataqueMaximo = ataqueMaximo;
    }

    public int getAtaqueMinimo() {
        return ataqueMinimo;
    }

    public void setAtaqueMinimo(int ataqueMinimo) {
        this.ataqueMinimo = ataqueMinimo;
    }

    public int getEnergiaMagicaMaxima() {
        return energiaMagicaMaxima;
    }

    public void setEnergiaMagicaMaxima(int energiaMagicaMaxima) {
        this.energiaMagicaMaxima = energiaMagicaMaxima;
    }

    public int getEnergiaMagicaMinima() {
        return energiaMagicaMinima;
    }

    public void setEnergiaMagicaMinima(int energiaMagicaMinima) {
        this.energiaMagicaMinima = energiaMagicaMinima;
    }
    
}