package app.interfaces;

import app.poderes.hechizos.Hechizo;

public interface IHaceHechizo extends IHaceMagia {
     
    void curarse(Hechizo hechizo);

    void defenderse();

    void usarHechizoOcio();

   

}