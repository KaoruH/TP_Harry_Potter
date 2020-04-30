package app.personajes;

import app.interfaces.*;

public class Criatura extends Personaje implements IEsMagico{

    public Criatura(String nombre, int edad) {
        super(nombre, edad);
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