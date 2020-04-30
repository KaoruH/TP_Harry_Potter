package app.personajes;

import app.interfaces.*;

public class Criatura extends Personaje implements IEsMagico{

    public Criatura(String nombre, int edad) {
        super(nombre, edad);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean esInvisibleAMuggles() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean esInvisible() {
        // TODO Auto-generated method stub
        return false;
    }



}