package app.personajes;

import app.interfaces.*;

public class Criatura extends Personaje implements IEsMagico{

    public Criatura(String nombre, int salud) {
        super(nombre, salud);
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