package app.artefactos;

import app.interfaces.*;

public class PiedraResurreccion extends Artefacto implements IReliquiaMuerte{

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

}