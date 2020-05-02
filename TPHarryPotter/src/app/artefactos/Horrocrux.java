package app.artefactos;

import app.interfaces.*;

public class Horrocrux extends Artefacto implements IReliquiaMuerte {

    public Horrocrux(String nombre, double amplificadorDeDanio, double amplificadorDeCuración) {
        super(nombre, amplificadorDeDanio, amplificadorDeCuración);

    }

    @Override
    public boolean esReliquiaMuerte() {
        return false;
    }

}