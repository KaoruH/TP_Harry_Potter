package app.interfaces;

import app.artefactos.*;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.*;

public interface IHaceMagia {

    int getEnergiaMagica(); // Wizard y Elfo ya lo tienen como getter

    void setEnergiaMagica(int energiaMagica); // Wizard y Elfo ya lo tienen como setter

    Poder getPoderInicial(); // Wizard ya lo tienen como getter

    void setPoder(Poder poder);

    Artefacto getArtefacto(); // Wizard y Elfo ya lo tienen como getter

    void aprender(Hechizo h);

    void atacar(Personaje personaje, Hechizo hechizo);

    void atacar(Personaje personaje, String hechizo);

    void curarse(Hechizo hechizo);

    void defenderse();

    void usarHechizoOcio();

}