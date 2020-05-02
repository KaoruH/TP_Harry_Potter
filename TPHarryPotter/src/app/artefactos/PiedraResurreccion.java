package app.artefactos;

import app.interfaces.*;

public class PiedraResurreccion extends Artefacto implements IReliquiaMuerte {

    public PiedraResurreccion(String nombre, double amplificadorDeDanio, double amplificadorDeCuración) {
        super(nombre, amplificadorDeDanio, amplificadorDeCuración);
    }

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

}