package app.personajes;

public class Mascota extends Personaje {

    public Mascota(String nombre, int salud, int bonusVida, int bonusEnergiaMagica) {
        super(nombre, salud);
        this.bonusVida = bonusVida;
        this.bonusEnergiaMagica = bonusEnergiaMagica;
    }

    private int bonusVida; // cuanto add o saca de la vida del jugador
    private int bonusEnergiaMagica; // cuanto add o saca de la vida del jugador
    private String descripcion; // algo básico por add o saca ^ y personalidad?

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getBonusVida() {
        return bonusVida;
    }

    public void setBonusVida(int bonusVida) {
        this.bonusVida = bonusVida;
    }

    public int getBonusEnergiaMagica() {
        return bonusEnergiaMagica;
    }

    public void setBonusEnergiaMagica(int bonusEnergiaMagica) {
        this.bonusEnergiaMagica = bonusEnergiaMagica;
    }

}