package app.transportes;

import app.interfaces.IEsMagico;

public class Escoba extends Transporte implements IEsMagico {

    public Escoba(String nombre, String tipo) {
        super(nombre, tipo);
    }

    @Override
    public boolean esInvisibleAMuggles() {

        return false;
    }

    @Override
    public boolean esInvisible() {

        return false;
    }

}