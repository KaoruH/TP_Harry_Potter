package app;

import java.util.*;

import app.artefactos.*;
import app.interfaces.*;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.*;
//import app.transportes.*; TODO

public class JuegoHP {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static Scanner teclado = new Scanner(System.in);

    private List<Wizard> brujosAElegir = new ArrayList<>();
    private List<Hechizo> hechizosRecibir = new ArrayList<>();
    private List<Mascota> mascotas = new ArrayList<>();
    private Wizard brujoElegido;
    private List<Hechizo> hechizosDanioBajo = new ArrayList<>();
    private List<Hechizo> hechizosDanioMedio = new ArrayList<>();

    // Ver si debo crear siempre una nueva variable (int, string) para cada método o
    // si puedo reutilizarlas

    public void inicializarJuego() {
        this.inicializarBrujosBloque1();
        this.inicializarMascotas();
        this.inicializarBienvenida();
        this.inicializarHechizosARecibir();
        this.recibirObjetivo();
        this.inicializarHechizosDanioBajo();
        this.inicializarHechizosMedioDanio();
        this.inicializarBloques();
    }

    public void inicializarBloques() { // TODO inicializar bloques
        for (int i = 1; i <= 4; i++) {

            inicializarBloqueArmazon(i);
        }
    }

    // public void inicializarSegunBloque() {
    // this.caminoHogwardsExpreso();

    // }

    public void inicializarBloqueArmazon(int numeroBloque) { // TODO Bloque armazon

        switch (numeroBloque) {

            case 1:

                inicializarSubbloques(1, 3);

                break;

            case 2:

                inicializarSubbloques(4, 6);

                break;

            case 3:

                inicializarSubbloques(7, 9);

                break;

            case 4:

                inicializarSubbloques(10, 12);

                break;

            default:
                break;

        }
    }

    public void inicializarSubbloques(int primer, int ultimo) { // TODO subbloques

        for (int i = primer; i <= ultimo; i++) {

            inicializarSubbloqueArmazon(i);

        }

    }

    public void inicializarSubbloqueArmazon(int numeroSubbloque) { // TODO subbloque armazon

        int a = aperturaSubbloque(numeroSubbloque);

        if (this.brujoElegido.tomarDecision(a)) {

            decision1Subbloque(numeroSubbloque);

        } else {

            decision2Subbloque(numeroSubbloque);

        }

        finalSubbloque(numeroSubbloque);

    }

    public int aperturaSubbloque(int numeroSubbloque) { // TODO apertura subbloque

        switch (numeroSubbloque) {
            case 1:

                System.out.println(".");
                System.out.println(".");
                System.out.println(".");
                System.out.println(" ");
                System.out.println("Estás dentro de tu casa y tenés que sair.");
                System.out.println(" ");
                System.out.println("Por donde quieres salir? Insira 1 para puerta y 2 por la ventana.");

                return teclado.nextInt();

            case 2:

                System.out.println("_______________________________________________________________________");
                System.out.println(" ");
                System.out.println("Ahora que saliste, tenés que llegar a la estación King's Cross.");
                System.out.println(" ");
                System.out.println(
                        "Cómo quieres llegar a la estación? Insira 1 para caminar y 2 para llamar al Autobús noctámbulo");

                return teclado.nextInt();

            case 3:

                System.out.println("_______________________________________________________________________");
                System.out.println(" ");
                System.out.println("Ahora falta poco! Sólo tenés que llegar hasta el Expreso de Hogwarts");
                System.out.println(" ");
                System.out.println("Qué prefieres hacer: insira 1 para ir directamente a la plataforma 9 3/4 o");
                System.out.println("2 para pasear un poco?");

                return teclado.nextInt();

            case 4:

                return teclado.nextInt();

            case 5:

                return teclado.nextInt();

            case 6:

                return teclado.nextInt();

            case 7:

                return teclado.nextInt();

            case 8:

                return teclado.nextInt();

            case 9:

                return teclado.nextInt();

            case 10:

                return teclado.nextInt();

            case 11:

                return teclado.nextInt();

            case 12:

                return teclado.nextInt();

            default:
                return 1;
        }

    }

    public void decision1Subbloque(int numeroSubbloque) {

        Hechizo hechizo;

        switch (numeroSubbloque) {
            case 1:

                System.out.println("Saliste por la puerta principal sin grandes problemas.");

                break;

            case 2:

                System.out.println("Caminaste, caminaste, caminaste...");
                System.out.println(" ");
                System.out.println(" [ Perdiste 5 puntos de vida por el cansancio ] ");
                System.out.println(" ");

                calcularPuntosVida(this.brujoElegido, -5);

                System.out.println("Cansado, te detuviste para descansar un poco y");
                System.out.println("al mirar hacia un lado y algo inesperado ocurrió.");
                System.out.println(" ");

                hechizo = hechizoRandomSegunPersonaje(this.brujoElegido, hechizosRecibir);

                procesarAprender(this.brujoElegido, hechizo);
                System.out.println(" ");

                System.out.println("Eventualmente llegaste a la estación King's Cross");

                break;

            case 3:

                System.out.println("Sin desvíos para ti ya veo. Re responsable! Esto pide una recompensa:");
                System.out.println(" ");

                hechizo = hechizoRandomSegunPersonaje(this.brujoElegido, hechizosRecibir);

                procesarAprender(this.brujoElegido, hechizo);

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            case 7:

                break;

            case 8:

                break;

            case 9:

                break;

            case 10:

                break;

            case 11:

                break;

            case 12:

                break;

            default:
                break;
        }

    }

    public void decision2Subbloque(int numeroSubbloque) {

        Hechizo hechizo;

        switch (numeroSubbloque) {
            case 1:

                System.out.println("Todas las ventanas de la planta baja estan cerradas y no abren.");
                System.out.println("Subiste al último piso y saltaste por la ventana;");
                System.out.println(" ");

                hechizo = hechizoRandomSegunPersonaje(this.brujoElegido, hechizosRecibir);

                procesarAprender(this.brujoElegido, hechizo);
                System.out.println(" ");

                System.out.println(" [ Perdiste 5 puntos de vida de vida al caer de la ventana ] ");

                calcularPuntosVida(this.brujoElegido, -5);

                System.out.println(" ");

                System.out.println("Saliste por ventana con relativo exito.");

                break;

            case 2:

                System.out.println(
                        "Estendiste tu varita en la acera y luego el Autobús noctámbulo llegó casi aplastando tu pie");
                System.out.println(" ");
                System.out.println(" [ Perdiste 5 puntos de vida en el recorrido ] ");
                System.out.println(" ");

                calcularPuntosVida(this.brujoElegido, -5);

                System.out.println("Llegaste a la estación King's Cross re rapido!");

                break;

            case 3:

                System.out.println("Tomaste tu tiempo para conoscer a la estación King's Cross");
                System.out.println("y aprovechaste el paseo para comer algo.");
                System.out.println(" ");
                System.out.println(" [ Recuperaste 5 puntos de vida ] ");
                System.out.println(" ");

                calcularPuntosVida(this.brujoElegido, 5);

                System.out.println("Y luego tomó tu camino hasta el expreso.");

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            case 7:

                break;

            case 8:

                break;

            case 9:

                break;

            case 10:

                break;

            case 11:

                break;

            case 12:

                break;

            default:
                break;
        }
    }

    public void finalSubbloque(int numeroSubbloque) {

        switch (numeroSubbloque) {
            case 1:
            case 2:

                continuar();

                break;

            case 3:

                System.out.println("Adentraste la pared de la plataforma 9 3/4 y caminaste en direción al expreso.");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");
                System.out.println(" [ !!!! ] Una figura se metío en tu frente");
                System.out.println(" ");
                System.out.println("Monstruo: 'No te voy a dejar pasar. Órdenes de mi maestro.");

                Elfo monstruo = new Elfo("Monstruo", 80);
                monstruo.setEnergiaMagica(100);
                for (int i = 0; i < this.brujoElegido.getHechizos().size(); i++) {
                    monstruo.getHechizos().add(hechizoRandomSegunPersonaje(monstruo, hechizosDanioBajo));

                }

                procesarLucha(monstruo, 1);

                break;

            case 4:
            case 5:

                continuar();

                break;

            case 6:

                Poder poder = new AbsorberFelicidad("Absorber felicidad", 20, 0);

                Dementor dementor = new Dementor("Dementor", 90, 90, true, poder);
                
                poder = new BesoDelDementor("Beso del Dementor", 30, 20);

                dementor.setUltimate(poder);

                procesarLucha(dementor, 2);

                break;

            case 7:
            case 8:

                continuar();

                break;

            case 9:

                break;

            case 10:
            case 11:

                continuar();

                break;

            case 12:

                break;

            default:
                break;
        }
    }

    // Va a correr el código de la lucha

    public void procesarLucha(Personaje personaje, int numeroBloque) {

        int a;

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(" [ Iniciaste una lucha contra " + personaje.getNombre() + " ] ");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Insira 1 para ver tu status y 2 para eligir tu primera acción.");
        a = teclado.nextInt();
        if (this.brujoElegido.tomarDecision(a)) {

            imprimirStatus();

        }

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");

        boolean turno1 = true;

        while (brujoElegido.getSalud() > 0 && personaje.getSalud() > 0) {

            Personaje atacante;
            Personaje defensor;
            Hechizo hechizo = this.hechizosRecibir.get(0);

            if (turno1) {

                atacante = this.brujoElegido;
                defensor = personaje;

                imprimirHechizosBrujo();
                System.out.println("Insira el número del hechizo que quiere usar:");
                a = teclado.nextInt();

                hechizo = this.brujoElegido.getHechizos().get(a - 1);

                procesarTipoHechizoLanzado(atacante, defensor, hechizo);

            } else {

                atacante = personaje;
                defensor = this.brujoElegido;

                if (personaje instanceof Wizard) {

                    Wizard brujo = (Wizard) personaje;

                    hechizo = seleccionarHechizoRandom(brujo.getHechizos());

                    procesarTipoHechizoLanzado(atacante, defensor, hechizo);

                } else if (personaje instanceof Elfo) {
                    Elfo elfo = (Elfo) personaje;

                    hechizo = seleccionarHechizoRandom(elfo.getHechizos());

                    procesarTipoHechizoLanzado(atacante, defensor, hechizo);

                } else if (personaje instanceof Dementor) { // TODO DEMENTOR
                    Dementor dementor = (Dementor) personaje;

                    procesarAtaqueDementor(dementor, defensor);

                }

            }

            if (!(hechizo instanceof HechizoDefensa)) {

                turno1 = !turno1;

            }

        }

        verificarQuienGanio(personaje, numeroBloque);

    }

    // Imprime quien ganó la lucha

    public void verificarQuienGanio(Personaje personaje, int numeroBloque) {

        if (this.brujoElegido.getSalud() > 0) {

            imprimirQuienGanio(this.brujoElegido, personaje);

        } else {

            imprimirQuienGanio(personaje, this.brujoElegido);

            continuarODesistir(numeroBloque);
        }
    }

    // Imprime quien ganó y quien murrió

    public void imprimirQuienGanio(Personaje ganio, Personaje perdio) {

        System.out.println(" ");
        System.out.println(" [ " + perdio.getNombre() + " murrió ] ");
        System.out.println(" [ " + ganio.getNombre() + " ganó la lucha ] ");
        System.out.println(" ");

    }

    // Jugador elige Continuar o Desistir

    public void continuarODesistir(int numeroBloque) {

        System.out.println("Insira 1 para intentar novamiente o 2 para desistir.");
        int a = teclado.nextInt();

        if (this.brujoElegido.tomarDecision(a)) {

            reinicializarBloque(numeroBloque);

        } else {

            gameOver();

        }
    }

    // Reinicializa el Bloque en que el jugador murrió

    public void reinicializarBloque(int numeroDelBloque) { // TODO verificar numero de bloques total

        switch (numeroDelBloque) {
            case 1:

                inicializarBloqueArmazon(1);

                break;

            case 2:

                inicializarBloqueArmazon(2);

                break;

            case 3:

                break;

            case 4:

                break;

            default:
                break;
        }

    }

    // 1/1 segundo bloque

    public void caminoHogwardsExpreso() {
        // TODO historia segun bloque

        // tudo que estava aqui agora está em finalSubbloque o algo asi, case 6
    }

    // Verifica y responde según en tipo de hechizo lanzado

    public void procesarTipoHechizoLanzado(Personaje atacante, Personaje defensor, Hechizo hechizo) {

        if (hechizo instanceof HechizoAtaque) {

            procesarAtaque(atacante, defensor, hechizo);

        } else if (hechizo instanceof HechizoCuracion) {
            procesarCuracion(atacante, hechizo);

        } else if (hechizo instanceof HechizoDefensa) {
            procesarDefensa(atacante, defensor, hechizo);

        } else if (hechizo instanceof HechizoOcio) {
            procesarHechizoOcio(atacante, hechizo);

        }

    }

    // Una pausa breve para que no se llene la pantalla de texto de una sola vez

    public void continuar() {

        System.out.println(" ");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
        System.out.println(" ");
    }

    // Esto carga los brujos del primer bloque a la lista de brujos del juego

    public void inicializarBrujosBloque1() {

        Poder poderInicial = new ParseTongue("ParseTongue");
        poderInicial.setDescripcion("Puedes hablar la lengua de las cobras.");

        Wizard brujo = new Wizard("Harry Potter", 90, 100, false, poderInicial);
        brujo.setEdad(17);

        Varita varita = new VaritaAcebo("Varita de Harry", 0, 0);
        varita.setDescripcion("28cm, hecha de acebo, con una pluma de fénix en su centro.");

        brujo.setVarita(varita);
        this.getBrujos().add(brujo);

        poderInicial = new Invisibilidad("Invisibilidad");
        poderInicial.setDescripcion("Puedes quedar invisible");

        brujo = new Wizard("Hermione Granger", 90, 100, false, poderInicial);
        brujo.setEdad(17);

        varita = new VaritaVid("Varita de Hermione Granger", 0, 0);
        varita.setDescripcion("27,3cm, hecha de vid, con núcleo de fibra de corazón de dragón.");

        brujo.setVarita(varita);

        this.getBrujos().add(brujo);

        poderInicial = new Metamorfosis("Metamorfosis");
        poderInicial.setDescripcion("Puedes transformarse en un gato. Cuidado con los perros!");

        brujo = new Wizard("Ron Weasley", 90, 100, false, poderInicial);
        brujo.setEdad(17);

        varita = new VaritaSauce("Varita de Ronald", 0, 0);
        varita.setDescripcion("36 cm, hecha de sauce, con un núcleo de Pelo de Unicornio.");

        brujo.setVarita(varita);

        this.getBrujos().add(brujo);

    }

    // Esto exibe en pantalla la apertura del juego donde se elige un personaje y
    // una mascota

    public void inicializarBienvenida() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("!! Bienvenido al mundo TP_Harry_Potter by Iya y Tati !!");
        System.out.println("Recién transmigraste a este mundo mágico, pero no tema, buena suerte!");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        this.eligirUnPersonaje();

        String a = this.getBrujoElegido().getNombre();

        Carta carta = new Carta("Carta de Hogwarts", "Hogwarts");
        carta.setContenido("\n'Estimad@ " + a
                + ", nos complace informarle que ha sido \naceptado en Hogwarts School of Witchcraft and Wizardry. Venga!'");

        this.entregarCarta(carta);

        carta = new Carta("Carta de Hagrid", "Hagrid");
        carta.setContenido("\n'Querid@ " + a
                + ", se suponía que debía guiarte a Hogwarts, pero tuve \nuna pequeña emergencia. Ya compré todos sus materiales y los envié a \nHogwarts. Cuanto a su mascota, podés elegirla al final de esta carta. Tu poder \ninicial también se confirmará para ayudarte a llegar al expreso de Hogwarts a salvo. \nPS: Te envio tu varita también.'");
        this.entregarCarta(carta);
        this.imprimirRecibirPrimerMision();
        this.confirmarPoderInicial();
        this.eligirUnaMascota();
        this.aplicarBonusMascota();
        this.imprimirStatus();
        System.out.println("Ahora estamos estamos listos! Adelante!");

        continuar();
    }

    // Esto carga las mascotas eligibles en bloque uno

    public void inicializarMascotas() {

        Mascota mascota = new Buho("Edwiges", 50, 10, 5);

        this.mascotas.add(mascota);

        mascota = new Gato("Crookshanks", 50, 5, 10);

        this.mascotas.add(mascota);

        mascota = new Rata("Scabbers", 50, 0, 5);

        this.mascotas.add(mascota);

        mascota = new Sapo("Trevor", 50, 7, 7);

        this.mascotas.add(mascota);

    }

    // Esto carga todos los Artefactos ---

    public void inicializarArtefactos() {

        /*
         * Yo adicioné las varitas a cada personaje... Si hay una lista de artefactos,
         * hay que adicionarlas en "inicializarBrujos" o algo asi
         * 
         * Artefacto artefacto = new Varita("Varita de Harry", 0.1, 0.1); artefacto.
         * setDescripcion("28cm, hecha de acebo, con una pluma de fénix en su centro.");
         * 
         * this.artefactos.add(artefacto);
         * 
         * artefacto = new Varita("Varita de Ronald", 0.1, 0.1); artefacto.
         * setDescripcion("36 cm, hecha de sauce, con un núcleo de Pelo de Unicornio.");
         * 
         * this.artefactos.add(artefacto);
         * 
         * artefacto = new Varita("Varita de Hermione", 0.1, 0.1); artefacto.
         * setDescripcion("27,3cm, hecha de vid, con núcleo de fibra de corazón de dragón."
         * );
         * 
         * this.artefactos.add(artefacto);
         */

        /*
         * Definir si se va a subir los conforme los bloques o si se sube todo a la vez.
         * Si se sube todo junto esto de abajo, entonces hay que cambiar el medoto
         * eligirVarita eligirunPersonaje...
         * 
         * Artefacto artefacto = new VaritaSauco("Varita de Saúco", 0.8, 0.1);
         * artefacto.setDescripcion(
         * "Fabricada de Saúco, mide treinta y cuatro centímetros y medio de largo y su núcleo es un pelo de cola de Thestral."
         * );
         * 
         * this.artefactos.add(artefacto);
         * 
         * artefacto = new PiedraResurreccion("Piedra de la resurreccion", 0, 0.3);
         * artefacto.setDescripcion(
         * "Tiene el poder de traer a la gente de vuelta de la muerte como espíritus definidos, no como personas vivas."
         * );
         * 
         * this.artefactos.add(artefacto);
         * 
         * artefacto = new CapaInvisibilidad("Capa de Invisibilidad", 0, 0.3);
         * artefacto.setDescripcion("Prenda mágica que hace invisible lo que cubre.");
         * 
         * this.artefactos.add(artefacto);
         */

    }

    // Esto Elige un personaje en el primer bloque

    public void eligirUnPersonaje() {

        System.out.println("En primer lugar, elige un personage (1, 2 o 3):");

        int contador = 0;

        for (Wizard brujo : brujosAElegir) {
            contador++;

            System.out.println((contador + " " + brujo.getNombre()));

        }
        int a;

        a = teclado.nextInt();

        this.setBrujoElegido(this.brujosAElegir.get(a - 1));

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Tu personaje eligido es " + this.getBrujoElegido().getNombre());

    }

    // Esto Elige una mascota en el primer bloque

    public void eligirUnaMascota() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Elige una mascota (1, 2, 3 o 4):");

        int contador = 0;

        for (Mascota mascota : mascotas) {
            contador++;

            System.out.println((contador + " " + mascota.getNombre()));

        }

        int a;

        a = teclado.nextInt();

        this.brujoElegido.setMascota(this.getMascotas().get(a - 1));

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Tu mascota eligida es " + this.brujoElegido.getMascota().getNombre());
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");

    }

    // Esto exibe en pantalla los datos del jugador

    public void imprimirStatus() {

        System.out.println(" [ Tu status actual es: ] ");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out
                .println("Nombre: " + this.brujoElegido.getNombre() + "     |   Edad: " + this.brujoElegido.getEdad());
        System.out.println("Puntos de vida: " + this.brujoElegido.getSalud() + "     |   Energia Mágica: "
                + this.brujoElegido.getEnergiaMagica());
        System.out.println("Hechizos:");
        imprimirHechizosBrujo();
        System.out.println("Brujo Oscuro: " + transformarTrueEnSiYFalseEnNo(this.brujoElegido.getMagoOscuro())
                + "     |   Mascota: " + this.brujoElegido.getMascota().getNombre());
        System.out.println("Varita: " + this.brujoElegido.getVarita().getDescripcion());
        if (this.brujoElegido.getArtefacto() != null) { // Hay que mejorar esta Linea. Duda cuanto a la responsabilidad
            System.out.println("Artefacto: " + this.brujoElegido.getArtefacto().getNombre());
        }
        if (this.brujoElegido.getEscoba() != null) { // Hay que mejorar esta Linea
            System.out.println("Escoba: " + this.brujoElegido.getEscoba().getNombre());
        }
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");

    }

    public void recibirObjetivo() {

        String a = this.getBrujoElegido().getNombre();

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("*Se Escucha algo raro*");
        System.out.println("Vos: ?? Que sonido es ese?");
        System.out.println("*Seguís el sonido*");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println("*Chocaste con un elfo*");

        continuar();

        System.out.println("Dobby: 'Hola, " + a + "! Perdoname! Me llamo Dobby,soy un elfo domestico.");
        System.out.println("No tengas miedo, no te quiero hacer mal. Supe que recibiste su carta de");
        System.out.println("Hogwards, pero tenga cuidado. Van acontecer cosas horribles por la");
        System.out.println("escuela y creo que eres la unica persona que puede salvar a Hogwards.'");

        continuar();

        System.out.println("Vos: 'cosas horribles? Solo yo? por que? Dobby?'");
        System.out.println("Dobby: 'Si! No tengo mucho tiempo. Solamente me escuche con");
        System.out.println("atención: tu objetivo es encontrar las  Reliquias de la Muerte");
        System.out.println("Para eso, va a tener que hacer amigos confiables y buscarlas.'");

        continuar();

        System.out.println("Vos: 'Calma! Hay que explicarme eso!'");
        System.out.println("Dobby: '" + a + ", escuchaste?");
        System.out.println("Cuidate! Y solo confies em Dumbledore! Él me envió acá-'");
        System.out.println("*El elfo dejate de subto*");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");

        continuar();

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("!! [ Recibiste la gran misión deste juego: encontrar las Reliquias de la Muerte! ] !!");
        System.out.println(" ");
        System.out.println("Dobby dejó un regalo para ayudarte a llegar a Hogwards");
        System.out.println(" ");

        Hechizo hechizo = new Obliviate("Obliviate", false, 5);
        hechizo.setDescripcion("Es un hechizo para borrar algo de la memória de um Wizard o Muggle");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(0);
        procesarAprender(this.brujoElegido, hechizo);

        play();
    }

    public void play() {
        System.out.println(" ");
        System.out.println(" [Ingrese 'play' para comenzar] ");
        teclado.next("play");
    }
    // Esto convierte true para si y false para no

    public String transformarTrueEnSiYFalseEnNo(boolean valor) {

        if (valor == true) {
            return "SI";
        } else {
            return "NO";
        }

    }

    // Esto lista los hechizos del brujo

    public void imprimirHechizosBrujo() {

        int contador = 0;

        if (this.brujoElegido.getHechizos() != null && this.brujoElegido.getArtefacto() != null) {
            for (Hechizo hechizo : this.brujoElegido.getHechizos()) {
                contador++;

                System.out.println(contador + " - " + hechizo.getNombre() + " | Nivel de daño: "
                        + hechizo.getNivelDanio() + " + " + this.brujoElegido.getArtefacto().getAmplificadorDeDanio()
                        + "%" + " | Nivel de cura: " + hechizo.getNivelCuracion() + " + "
                        + this.brujoElegido.getArtefacto().getAmplificadorDeCuración() + " | Energia mágica: "
                        + hechizo.getEnergiaMagica() + "% | Oscuro: "
                        + transformarTrueEnSiYFalseEnNo(hechizo.getEsOscuro()));

            }

        } else if (this.brujoElegido.getHechizos() != null) {

            for (Hechizo hechizo : this.brujoElegido.getHechizos()) {
                contador++;

                System.out.println(contador + " - " + hechizo.getNombre() + " | Nivel de daño: "
                        + hechizo.getNivelDanio() + " | Nivel de cura: " + hechizo.getNivelCuracion()
                        + " | Energia mágica: " + hechizo.getEnergiaMagica() + " | Oscuro: "
                        + transformarTrueEnSiYFalseEnNo(hechizo.getEsOscuro()));

            }
        }

    }

    // Aplica el bonus de energia magica y salud de las mascotas al personaje

    public void aplicarBonusMascota() {

        int a = this.brujoElegido.getEnergiaMagica() + this.brujoElegido.getMascota().getBonusEnergiaMagica();

        this.brujoElegido.setEnergiaMagica(a);

        a = this.brujoElegido.getSalud() + this.brujoElegido.getMascota().getBonusVida();

        this.brujoElegido.setSalud(a);

    }

    // Esto abre o no la carta de Hogwarts perfecto

    public void entregarCarta(Carta carta) {

        int numero;

        if (this.brujoElegido.recibirCarta()) {

            System.out.println("_______________________________________________________________________");
            System.out.println(" ");
            System.out.println(" [ Recibiste una carta de " + carta.getSender() + " ] ");

            System.out.println("_______________________________________________________________________");
            System.out.println(" ");
            System.out.println("Quieres leer la carta de " + carta.getSender() + "? Insira 1 para si y 2 para no.");

            numero = teclado.nextInt();

            if (this.brujoElegido.tomarDecision(numero)) {

                System.out.println(carta.getContenido());

            }

        }

    }

    // "Activa" y exibe en pantalla el poder inicial

    public void confirmarPoderInicial() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(
                "*Tu poder inicial, " + this.brujoElegido.getPoderInicial().getNombre() + ", está confirmado*");

    }

    // Recibe Primer mision

    public void imprimirRecibirPrimerMision() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("!! [ Recibiste tu primer misión menor: llegar al expreso de Hogwarts! ] !!");

    }

    // Carga todos los hechizos

    public void inicializarHechizosDanioBajo() {
        Hechizo hechizo = new Expelliarmus("Paralizante", false, 15); // ataque
        hechizo.setDescripcion("paralisa la victima");
        hechizo.setNivelDanio(25);
        hechizo.setNivelCuracion(0);
        this.hechizosDanioBajo.add(hechizo);

        hechizo = new WingardumLeviosa("Wingwardum Leviosa", false, 10); // ocio
        hechizo.setDescripcion("Es un encantamiento usado para hacer que los objetos vuelen o leviten.");
        hechizo.setNivelDanio(0);
        hechizo.setNivelCuracion(0);
        this.hechizosDanioBajo.add(hechizo);

        hechizo = new Stupefy("Confusion", false, 15); // ataque
        hechizo.setDescripcion("Confusion mental por un rato a la victima");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(10);
        this.hechizosDanioBajo.add(hechizo);

        hechizo = new Stupefy("Fecho explosivo", false, 15); // ataque
        hechizo.setDescripcion("Genera un fehco de luz como si fuera foguetes");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(20);
        this.hechizosDanioBajo.add(hechizo);

        hechizo = new Protego("Escudo de protecion", false, 10); // defensa
        hechizo.setDescripcion(
                "es un encantamiento que protege al lanzador con un escudo invisible que refleja hechizos y bloquea entidades física");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(0);
        this.hechizosDanioBajo.add(hechizo);

        hechizo = new Stupefy("Fecho de luz verde", false, 15); // ataque
        hechizo.setDescripcion("hace un fecho de luz de danio");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(15);
        this.hechizosDanioBajo.add(hechizo);

        hechizo = new Stupefy("Fecho de luz roja", false, 15); // ataque
        hechizo.setDescripcion("hace un fecho de luz de danio");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(15);
        this.hechizosDanioBajo.add(hechizo);

    }

    public void inicializarHechizosMedioDanio() {

        Hechizo hechizo = new Stupefy("Sugando vida", true, 25); // HACER RADOM DE DANIO
        hechizo.setDescripcion("Sugando felicidad");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(25);
        this.hechizosDanioMedio.add(hechizo);

    }

    public void inicializarHechizosMedioDanio2() {
        Hechizo hechizo = new Expelliarmus("Paralizante", false, 15); // ataque
        hechizo.setDescripcion("paralisa la victima");
        hechizo.setNivelDanio(25);
        hechizo.setNivelCuracion(0);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new WingardumLeviosa("Wingwardum Leviosa", false, 10); // ocio
        hechizo.setDescripcion("Es un encantamiento usado para hacer que los objetos vuelen o leviten.");
        hechizo.setNivelDanio(0);
        hechizo.setNivelCuracion(0);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new Stupefy("Confusion", false, 15); // ataque
        hechizo.setDescripcion("Confusion mental por un rato a la victima");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(10);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new Stupefy("Fecho explosivo", false, 15); // ataque
        hechizo.setDescripcion("Genera un fehco de luz como si fuera foguetes");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(20);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new Protego("Escudo de protecion", false, 10); // defensa
        hechizo.setDescripcion(
                "es un encantamiento que protege al lanzador con un escudo invisible que refleja hechizos y bloquea entidades física");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(0);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new Stupefy("Fecho de luz verde", false, 15); // ataque
        hechizo.setDescripcion("hace un fecho de luz de danio");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(15);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new Stupefy("Fecho de luz roja", false, 15); // ataque
        hechizo.setDescripcion("hace un fecho de luz de danio");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(15);
        this.hechizosDanioMedio.add(hechizo);

    }

    public void inicializarHechizosARecibir() {

        Hechizo hechizo = new Expelliarmus("Expelliarmus", false, 15); // ataque
        hechizo.setDescripcion(
                "También conocido como el encantamiento desarmador, es un encantamiento defensivo que fuerza a la víctima a soltar lo que sea que esté sujetando.");
        hechizo.setNivelDanio(25);
        hechizo.setNivelCuracion(0);
        this.hechizosRecibir.add(hechizo);

        hechizo = new WingardumLeviosa("Wingwardum Leviosa", false, 10);
        hechizo.setDescripcion("Es un encantamiento usado para hacer que los objetos vuelen o leviten.");
        hechizo.setNivelDanio(0);
        hechizo.setNivelCuracion(0);
        this.hechizosRecibir.add(hechizo);

        hechizo = new VulneraSanetur("Vulnera Sanentur", false, 25);
        hechizo.setDescripcion(
                "Hechizo sanador que parece una canción, y que corresponde al contrahechizo de la maldición sectumsempra.");
        hechizo.setNivelDanio(0);
        hechizo.setNivelCuracion(40);
        this.hechizosRecibir.add(hechizo);

        hechizo = new ArrestoMomentum("Arresto Momentum", false, 10);
        hechizo.setDescripcion(
                "Es un encantamiento que hace más lento o detiene el movimiento de un objeto o persona.");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(0);
        this.hechizosRecibir.add(hechizo);

        hechizo = new CaveInimicum("Cave Inimicum", false, 15);
        hechizo.setDescripcion("Se mantiene alejados a los enemigos");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(0);
        this.hechizosRecibir.add(hechizo);

        hechizo = new Protego("Protego", false, 10);
        hechizo.setDescripcion(
                "es un encantamiento que protege al lanzador con un escudo invisible que refleja hechizos y bloquea entidades física");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(0);
        this.hechizosRecibir.add(hechizo);

        hechizo = new SectumSepra("Sectum Sepra", true, 30);
        hechizo.setDescripcion(
                "su efecto es el equivalente al de un cuchillo invisible, acuchillando repetidamente y provocando heridas sangrantes en la piel en pocos segundos");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(40);
        this.hechizosRecibir.add(hechizo);

        hechizo = new Stupefy("Stupefy", false, 15);
        hechizo.setDescripcion("es un hechizo que deja inconsciente a la víctima y detiene objetos en movimiento.");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(25);
        this.hechizosRecibir.add(hechizo);

        hechizo = new Reparifors("Reparifors", false, 10);
        hechizo.setDescripcion(
                "es un hechizo curativo que cura pequeñas dolencias generadas por magia, como la parálisis y el envenenamiento. Puede ser usado contra Stupefy");
        hechizo.setNivelCuracion(20);
        hechizo.setNivelDanio(0);
        this.hechizosRecibir.add(hechizo);

        hechizo = new MaleficioCruciatus("Maleficio Cruciatus", true, 20);
        hechizo.setDescripcion("la maldición genera un dolor intenso y agónico en la víctima.");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(30);
        this.hechizosRecibir.add(hechizo);

        hechizo = new Incarcerous("Incarcerous", true, 20);
        hechizo.setDescripcion("la maldición genera un dolor intenso y agónico en la víctima.");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(30);
        this.hechizosRecibir.add(hechizo);

    }

    // Selecciona un hechizo aleatorio segun el personaje

    public Hechizo hechizoRandomSegunPersonaje(Personaje personaje, List<Hechizo> hechizo1) {

        Hechizo hechizo = seleccionarHechizoRandom(hechizo1);

        if (personaje instanceof Elfo) {
            Elfo perso = (Elfo) personaje;

            while (perso.getHechizos().contains(hechizo)) {

                hechizo = seleccionarHechizoRandom(hechizo1);

            }
        } else if (personaje instanceof Wizard) {
            Wizard perso = (Wizard) personaje;

            while (perso.getHechizos().contains(hechizo)) {

                hechizo = seleccionarHechizoRandom(hechizo1);

            }
        }

        return hechizo;
    }

    // selecciona el hechizo de hecho

    public Hechizo seleccionarHechizoRandom(List<Hechizo> hechizo1) {

        Random random = new Random();

        int numero = random.nextInt(hechizo1.size());

        return hechizo1.get(numero);

    }

    // Para procesar el ataque

    public void procesarAtaque(Personaje atacante, Personaje defensor, Hechizo hechizo) {

        if (atacante instanceof Wizard) {

            Wizard wizard = (Wizard) atacante;

            wizard.atacar(defensor, hechizo);

            imprimirHablaAtaque(wizard, defensor, hechizo);

        } else if (atacante instanceof Elfo) {

            Elfo elfo = (Elfo) atacante;

            elfo.atacar(defensor, hechizo);

            imprimirHablaAtaque(elfo, defensor, hechizo);
        }

    }

    public void imprimirHablaAtaque(Personaje atacante, Personaje defensor, Hechizo hechizo) {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(" [ " + atacante.getNombre() + " atacó " + defensor.getNombre() + " con el hechizo "
                + hechizo.getNombre() + " ] ");
        System.out.println(
                " [ " + atacante.getNombre() + " consumió " + hechizo.getEnergiaMagica() + " de energia mágica ] ");
        System.out.println(" [ La salud actual de " + defensor.getNombre() + " es de " + defensor.getSalud() + " ] ");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");

    }

    // Esto va a procesar la curación

    public void procesarCuracion(Personaje atacante, Hechizo hechizo) {

        if (atacante instanceof Wizard) {

            Wizard wizard = (Wizard) atacante;

            wizard.curarse(hechizo);

            imprimirHablaCuracion(wizard, hechizo);

        } else if (atacante instanceof Elfo) {

            Elfo elfo = (Elfo) atacante;

            elfo.curarse(hechizo);

            imprimirHablaCuracion(elfo, hechizo);
        }

    }

    public void imprimirHablaCuracion(Personaje personaje, Hechizo hechizo) {

        System.out.println(" ");
        System.out.println(" [ " + personaje.getNombre() + " usó el hechizo de curación " + hechizo.getNombre()
                + " y consumió " + hechizo.getEnergiaMagica() + " de energia mágica ] ");
        System.out.println(" [ La salud actual de " + personaje.getNombre() + " es de " + personaje.getSalud() + " ] ");
        System.out.println(" ");

    }

    public void procesarDefensa(Personaje atacante, Personaje defensor, Hechizo hechizo) {

        if (atacante instanceof Wizard) {

            Wizard wizard = (Wizard) atacante;

            wizard.defenderse(hechizo);

            imprimirHablaDefensa(wizard, defensor, hechizo);

        } else if (atacante instanceof Elfo) {

            Elfo elfo = (Elfo) atacante;

            elfo.defenderse(hechizo);

            imprimirHablaDefensa(elfo, defensor, hechizo);
        }

    }

    public void imprimirHablaDefensa(Personaje atacante, Personaje defensor, Hechizo hechizo) {

        System.out.println(" ");
        System.out.println(" [ " + atacante.getNombre() + " usó el hechizo de defensa " + hechizo.getNombre()
                + " y consumió " + hechizo.getEnergiaMagica() + " de energia mágica ] ");
        System.out.println(" ");
        System.out.println(" [ El ataque de " + defensor.getNombre() + " fue defendido ] ");
        System.out.println(" ");
    }

    public void procesarHechizoOcio(Personaje atacante, Hechizo hechizo) {

        System.out.println(" ");
        System.out.println(" [ " + atacante.getNombre() + " usó un hechizo de ócio " + hechizo.getNombre() + " ] ");
        System.out.println(" [ Todos os efectos extras de estos hechizos estan desactivados ] ");
        System.out.println(" ");
    }

    public void imprimirConversionMagoOscuro(String nombre) {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(" [ " + nombre
                + " usó un hechizo oscuro y se convertió en un mago oscuro y el daño se multiplicó por 2 en este ataque ] ");
        System.out.println("_______________________________________________________________________");

        System.out.println(" ");

    }

    // llama método aprender e imprime en la pantalla

    public void procesarAprender(IHaceHechizo iHaceHechizo, Hechizo hechizo) {

        iHaceHechizo.aprender(hechizo);

        System.out.println(" [ Aprendiste el hechizo " + hechizo.getNombre() + " ] ");
    }

    // Calcula el total de puntos de vida después de ganar o perder puntos

    public void calcularPuntosVida(Personaje personaje, int numero) {

        int b = personaje.getSalud() + numero;
        personaje.setSalud(b);
    }

    // Fin de juego cuando se muerre y desiste

    public void gameOver() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(" [ GAME OVER ] ");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
    }

    public void procesarAtaqueDementor(Dementor dementor, Personaje defensor){

        int a;

        if (dementor.getSalud() < 10 && defensor.getSalud() < 30) {

            a = dementor.atacar(defensor, dementor.getUltimate());
            
        } else {
            
            a = dementor.atacar(defensor, dementor.getPoderInicial());
        }

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(" [ " + dementor.getNombre() + " atacó " + defensor.getNombre() + " con el poder "
                + dementor.getPoderInicial().getNombre() + " ] ");
        System.out.println(
                " [ " + dementor.getNombre() + " consumió " + a + " de energia mágica ] ");
        System.out.println(" [ La salud actual de " + defensor.getNombre() + " es de " + defensor.getSalud() + " ] ");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");

    }

    // GETTERS AND SETTERS

    public List<Wizard> getBrujos() {
        return brujosAElegir;
    }

    public void setBrujos(List<Wizard> brujos) {
        this.brujosAElegir = brujos;
    }

    public Wizard getBrujoElegido() {
        return brujoElegido;
    }

    public void setBrujoElegido(Wizard brujoElegido) {
        this.brujoElegido = brujoElegido;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public List<Hechizo> getHechizosDanioBajo() {
        return hechizosDanioBajo;
    }

    public void setHechizosDanioBajo(List<Hechizo> hechizosDanioBajo) {
        this.hechizosDanioBajo = hechizosDanioBajo;
    }

    public List<Hechizo> getHechizosRecibir() {
        return hechizosRecibir;
    }

    public void setHechizosRecibir(List<Hechizo> hechizosRecibir) {
        this.hechizosRecibir = hechizosRecibir;
    }

}