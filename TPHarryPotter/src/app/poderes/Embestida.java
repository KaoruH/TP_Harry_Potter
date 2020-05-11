package app.poderes;

public class Embestida extends Poder{

    public Embestida(String nombre, int ataqueMaximo, int ataqueMinimo) {
        super(nombre);
        this.ataqueMaximo = ataqueMaximo;
        this.ataqueMinimo = ataqueMinimo;
    }

    private int ataqueMaximo;

    private int ataqueMinimo;

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
    
}