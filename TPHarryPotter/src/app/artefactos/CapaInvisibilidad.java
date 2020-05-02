package app.artefactos;

import app.interfaces.*;

public class CapaInvisibilidad extends Artefacto implements IReliquiaMuerte {

    public CapaInvisibilidad(String nombre, double amplificadorDeDanio, double amplificadorDeCuración) {
        super(nombre, amplificadorDeDanio, amplificadorDeCuración);
    }

    @Override
    public boolean esReliquiaMuerte() {

        return true;
    }

}