package app.interfaces;

import app.artefactos.*;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.*;

public interface IHaceMagia {

    int getEnergiaMagica();

    void setEnergiaMagica(int energiaMagica);

    Poder getPoderInicial();

    void setPoder(Poder poder);

    Artefacto getArtefacto();

    void aprender(Hechizo h);

    void atacar(Personaje personaje, Hechizo hechizo);

    void atacar(Personaje personaje, String hechizo);


}