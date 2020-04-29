package app.artefactos;

import app.interfaces.*;

public class VaritaSauco extends Varita implements IReliquiaMuerte{

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

}