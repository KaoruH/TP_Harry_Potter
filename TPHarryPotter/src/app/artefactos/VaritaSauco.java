package app.artefactos;

import app.interfaces.*;

public class VaritaSauco extends Varita implements IReliquiaMuerte {

    public VaritaSauco(String nombre, double amplificadorDeDanio, double amplificadorDeCuración) {
        super(nombre, amplificadorDeDanio, amplificadorDeCuración);
    }

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

}