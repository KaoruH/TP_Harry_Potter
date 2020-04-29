package app.artefactos;

import app.interfaces.*;

public class Horrocrux extends Artefacto implements IReliquiaMuerte{

    @Override
    public boolean esReliquiaMuerte() {
        return false;
    }

}