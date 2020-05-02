package app;

public class App {
    public static void main(String[] args) throws Exception {

        JuegoHP juego = new JuegoHP();

        juego.inicializarBaseJuegoHP();

        // cambiamos el "inicializarApertura" de JuegoHP para acá? (partes y llamamos
        // las partes de acá)
        // o llamamos la este método de acá en lugar de ponerlo en
        // "InicializarBaseJuegoHP"?
        // E

        juego.inicializarPrimerBloque();

        juego.recibirObjetivo();
        
    }
}