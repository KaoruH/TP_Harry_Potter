package app.transportes;

import app.interfaces.IEsMagico;

public class TrenExpresoHowards extends Transporte implements IEsMagico {

    public TrenExpresoHowards(String nombre, String tipo) {
        super(nombre, tipo);
    }

    @Override
    public boolean esInvisibleAMuggles() {

        return true;
    }

    @Override
    public boolean esInvisible() {

        return false;
    }

}