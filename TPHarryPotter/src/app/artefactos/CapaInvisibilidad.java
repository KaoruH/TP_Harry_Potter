package app.artefactos;

import app.interfaces.*;

public class CapaInvisibilidad extends Artefacto implements IReliquiaMuerte{

    @Override
    public boolean esReliquiaMuerte() {

        return true;
    }

}