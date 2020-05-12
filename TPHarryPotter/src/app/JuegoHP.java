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
    private List<Artefacto> contenedoArtefactos = new ArrayList<>();

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

            case 1: // bloque 1

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

            case 4: // bloque 2
                System.out.println("_______________________________________________________________________");
                System.out.println(" ");
                System.out.println("Felicitaciones! Lograste llegar al Tren Expreso de Hogward!");
                System.out.println(" !! Mision 1 concluída !!");
                System.out.println(" ");
                System.out.println("Subiste al Tren y luego fuiste encaminado a una cabine vacia");
                System.out.println("Mientras se acomodaba, llegaran 2 alumnos preguntando si podrían");
                System.out.println("quedarse con vos en la cabine.");
                System.out.println("Si querés aceptar la compañia ingrese 1 u 2 si querés decir que no.");

                return teclado.nextInt();

            case 5:
                System.out.println("_______________________________________________________________________");
                System.out.println(" ");
                System.out.println("Despues de conversar un montón con sus nuevos amigos");
                System.out.println("acostaran para dormir un poco y...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("!! El expresso para bruscamiente !!");
                System.out.println("...");
                System.out.println("...");
                System.out.println("Alumnos gritan y luego se callan!");
                System.out.println("...");
                continuar();
                System.out.println("Oyes bajito que alguien fugió de la prision Azkaban");
                System.out.println("y los Dementadores invadiran el expreso buscando a alguien");
                System.out.println("...");
                System.out.println("Todo está oscuro y frío!");
                System.out.println("..............'Auuuuuuuuuuuuu!'");
                System.out.println("Oíste lo que parece un perro en los vagones de carga");
                System.out.println("Ingrese 1 para ir hasta los vagones o 2 para quedar-se");

                return teclado.nextInt();

            case 6:

                System.out.println("_______________________________________________________________________");
                System.out.println(" ");
                System.out.println("El perro, se transforma en un brujo!");
                System.out.println("...");
                System.out.println("Piensas: 'que difícil está llegar en esta escuela!");
                System.out.println("Sería más uno a me impedir?' ");
                System.out.println("Para aproximarse y preguntar quien es, ingrese 1. Para salir corriendo, 2. ");

                return teclado.nextInt();

            case 7: // bloque 3
                System.out.println("_______________________________________________________________________");
                System.out.println(" ");
                System.out.println("***   Bienvenid@ a Hogwards!   ***");
                System.out.println("_______________________________________________________________________");
                System.out.println(" ");
                System.out.println("En su llegada mucho le ocorrurió");
                System.out.println("Vos y sus amigos ingresaron a la casa Grifindor");
                System.out.println("conoceron algunos de los profesores y partes del castillo");
                System.out.println("Todo parecia mágico... y era!");
                System.out.println(" ");
                System.out.println("Ingrese 1 para empezar las clases o 2 para pasear solo por el Castillo ");

                return teclado.nextInt();

            case 8:
                System.out.println(" ");
                System.out.println("En una de las clases ustedes escucharan hablar sobre");
                System.out.println("La camara secreta. Muchos alumnos hablavan cosas sobre ella");
                System.out.println("pero nadie sabia si era real o como accederla.");
                System.out.println("...");
                System.out.println("Ya escuchaste eso pero: sabes que eres curios@, no!? xD");
                continuar();
                imprimirRecibirSegundaMision();
                System.out.println(" ");
                imprimirBusquedaCamara1();
                return teclado.nextInt();

            case 9:
                System.out.println(" ");
                imprimirBusquedaCamara2();

                return teclado.nextInt();

            case 10:
                System.out.println("_______________________________________________________________________");
                System.out.println(" ");
                System.out.println("Sus días en Hogwards estan siendo increíbles");
                System.out.println("Pero no te puedes olvidar del objetivo. ");
                System.out.println(" ");
                System.out.println("Mientras las clases encuentras una puerta que todavia no habias visto");
                System.out.println("Ingrese 1 para esperar todos dormiren y adentrar a la puerta");
                System.out.println("u 2 para preguntar a Hagrid sobre la puerta.");

                return teclado.nextInt();

            case 11:
                System.out.println(" ");
                System.out.println("Sientes que el tiempo está se quedando corto");
                System.out.println("Tenés que encontrar la última reliquia.");
                System.out.println("...");
                System.out.println("Su mascota te trae una carta, pero dentro solo hay");
                System.out.println("una gran pluma negra con un poco de sangre.");
                System.out.println("Sabes lo que significa: los comensales estan llegando!");
                continuar();
                System.out.println(" ");
                System.out.println("Algo que estás evitando deve ser hecho:");
                System.out.println("Conversar con Albus Dumbledore.");
                System.out.println("...");
                System.out.println("Llegando a su mesa, Dumbledore te pregunta");
                System.out.println("Dumblendore: estás listo para confrontar los comensales? ");
                System.out.println("Ingrese 1 para sí, 2 para no. ");

                return teclado.nextInt();

            case 12:
            System.out.println(" ");
            System.out.println("Tenés dos cajas en la mesa");
            System.out.println("Respiras y las abre!");
            System.out.println("Una es una Varita linda, hecha de sauco. ");
            System.out.println(" La otra es un anillo con una piedra azul de energia impresionante.");
            System.out.println(" ");
            System.out.println("Ingrese 1 para elergir la Horrocrucx o ingrese 2 para la Varita de Sauco");
                return teclado.nextInt();

            default:
                return 1;
        }

    }

    public void decision1Subbloque(int numeroSubbloque) {

        Hechizo hechizo;
        String a = this.getBrujoElegido().getNombre();

        switch (numeroSubbloque) {
            case 1:

                System.out.println("Saliste por la puerta principal sin grandes problemas.");

                break;

            case 2:

                System.out.println("Caminaste, caminaste, caminaste...");

                procesarPuntosVida(this.brujoElegido, -5, "por el cansancio");

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
                System.out.println("Este fue el início de una gran amistad! Adelante en el tiempo");
                System.out.println("todos en Hogwards van a saber historias de 3 amigos en grandes aventuras");
                System.out.println("que estan por venir. Harry, Ron y Hermione, estes son ustedes.");

                break;

            case 5: 
                System.out.println("Como sos MUY CURIOS@, fuiste con sus amigos");
                System.out.println("en busca del sonido.");
                System.out.println(" ");
                continuar();
                System.out.println(" ");
                System.out.println("En uno de los vagones viste un perro cerca de ser atacado por un dementador");
                System.out.println("[!!!!] Tenés que ayudarlo!");

                Poder poder = new AbsorberFelicidad("Absorber felicidad", 20, 10);

                Dementor dementor = new Dementor("Dementor", 90, poder);

                poder = new BesoDelDementor("Beso del Dementor", 30, 20);

                dementor.setUltimate(poder);

                procesarLucha(dementor, 2);

                break;

            case 6:
                System.out.println("Para su surpresa, el brujo regala una gran sonrisa");
                System.out.println("Y se apresenta como Sirius Black,");
                System.out.println("el Canuto, ultimo heredero de la familia Black.");
                System.out.println("...Sí! El famoso Tio de Harry Potter!...");
                System.out.println(" ");

                break;

            case 7: 
                continuar();
                break;

            case 8:
                System.out.println(" ");
                System.out.println("Vos: 'Hola Hagrid!'");
                System.out.println("Hagrid: 'Hola," + a + "! Que haces aqui?'");
                System.out.println("Vos: 'Yo y mis amigos estamos buscando informaciones sobre");
                System.out.println("como encontrar la camara secreta. Pensé que podias ayudarnos!");
                System.out.println("Hagrid: 'Camara secreta? Hum... creo que no es una buena hora, " + a);
                System.out.println("tengo algunas cosas que cuidar.'");
                System.out.println("Vos: 'Pero Hagrid...'");
                System.out.println("Hagrid habla fuerte: '" + a + ", no te puedo ayudar con esto! Olvidate'");
                System.out.println("Parece que Hagrid no quier que la encontres.");
                System.out.println(" ");

                break;

            case 9:
                System.out.println(" ");
                System.out.println("Al entrar en el baño escuchas alguien llorando");
                System.out.println("Encontras uno de los fantasmas del castillo");
                System.out.println("Vos: 'Hola? Myrte?'");
                System.out.println("Myrtle la llorona: 'Que haces aqui, " + a + "? Me deje sola!!!'");
                System.out.println("Vos: 'Perdon, Myrte! No quiero molestarte, supe que tienes informaciones");
                System.out.println("de la camara secreta. Es verdad?'");
                System.out.println("Con un estrondoso grito, la llorona: 'SALGA AHORA! ME DEJE SOLA!!!");
                System.out.println(" ");
                continuar();
                System.out.println("Casi saliste, pero tornaste a preguntar brandamente.");
                System.out.println("Vos: 'Porque lloras? Quiero ayudarte!'");
                System.out.println("impresionante como las palabras que dijiste la dejaron amigable.");
                System.out.println(" ");
                continuar();
                System.out.println("La Myrtle contó toda la história");
                System.out.println("Desde entonces, ya supieron como abrir la Camara");
                System.out.println("Para ayudarla, prometiste matar la criatura que se esconde");
                System.out.println("en la Camara. La misma que mató la Myrtle.");
                System.out.println("[ Siga para abrir la Camara Secreta ] ");

                break;

            case 10:
                System.out.println(" ");
                System.out.println("Mientras todos durmian, hasta tus amigos ");
                System.out.println("saliste a ver que habia por atrás de la puerta");
                System.out.println(" ");
                System.out.println("No está trancada, entonces abres rápido y entras para no");
                System.out.println("avistaren vos en los pasillos tan tarde.");
                System.out.println("...");
                continuar();
                System.out.println(" ... ");
                System.out.println("Está todo oscuro, pero hay un viento caliente.");
                System.out.println("sigues... ");
                System.out.println(" !! ES UM GRAN PERRO CON 3 CABEZAS !! ");
                procesarPuntosVida(this.brujoElegido, -15, "por el perro te hacer una herida");
                System.out.println("Saliste corriendo, pusiste la capa de invisibilidad y");
                System.out.println("volviste a su habitacion");
                break;

            case 11:
                System.out.println(" ");
                System.out.println("Dumbledore: 'Humm!! Crees que estás list@," + a + ".");
                System.out.println("Que bueno, pues lo peor se aproxima. Te voy a explicarte!'");
                System.out.println(" ");
                System.out.println("Dumbledore te explicó toda la história de las Relíquias.");
                System.out.println("Te enseño un Hechizo");

                hechizo = hechizoRandomSegunPersonaje(this.brujoElegido, hechizosRecibir);

                procesarAprender(this.brujoElegido, hechizo);
                System.out.println(" ");
                System.out.println("Y te dijo que tenía la última Reliquia ");

                break;

            case 12:
            System.out.println(" ");
            System.out.println("Elegiste la Horrocrux");
            System.out.println("Pero esa relíquia no es una de las Reliquias de La muerte! ");
            System.out.println(" ");
            reinicializarBloque(5);

                break;

            default:
                break;
        }

    }

    public void decision2Subbloque(int numeroSubbloque) {

        Hechizo hechizo;
        String a = this.getBrujoElegido().getNombre();

        switch (numeroSubbloque) {

            case 1:

                System.out.println("Todas las ventanas de la planta baja estan cerradas y no abren.");
                System.out.println("Subiste al último piso y saltaste por la ventana;");
                System.out.println(" ");

                hechizo = hechizoRandomSegunPersonaje(this.brujoElegido, hechizosRecibir);

                procesarAprender(this.brujoElegido, hechizo);

                procesarPuntosVida(this.brujoElegido, -5, "al caer de la ventana");

                System.out.println("Saliste por ventana con relativo exito.");

                break;

            case 2:

                System.out.println(
                        "Estendiste tu varita en la acera y luego el Autobús noctámbulo llegó casi aplastando tu pie");

                procesarPuntosVida(this.brujoElegido, -5, "en el recorrido");

                System.out.println("Llegaste a la estación King's Cross re rapido!");

                break;

            case 3:

                System.out.println("Tomaste tu tiempo para conoscer a la estación King's Cross");
                System.out.println("y aprovechaste el paseo para comer algo.");

                procesarPuntosVida(this.brujoElegido, 5, "al comer");

                System.out.println("Y luego tomó tu camino hasta el expreso.");

                break;

            case 4:
                System.out.println("Mismo decindo que no, ellos quedaron");
                System.out.println("No habian más vacantes en otras cabines.");
                System.out.println("Y que bueno, pues");
                System.out.println("Este fue el início de una gran amistad! Adelante en el tiempo");
                System.out.println("todos en Hogwards van a saber historias de 3 amigos en grandes aventuras");
                System.out.println("que estan por venir. Harry, Ron y Hermione, estes son ustedes.");

                break;

            case 5:
                System.out.println("No sos nada destemino, eh!?");
                System.out.println("Pero sus amigos sí son y e llamaron para seguir el sonido");
                System.out.println("Como no quieres, te golpean la cabeza");
                System.out.println("Y te hacen ir así mismo!");

                procesarPuntosVida(this.brujoElegido, -10, "por ser tan medros@");

                continuar();
                System.out.println(" ");
                System.out.println("En uno de los vagones viste un perro cerca de ser atacado por un dementador");
                System.out.println("[!!!!] Tenés que ayudarlo!");

                Poder poder = new AbsorberFelicidad("Absorber felicidad", 20, 10);

                Dementor dementor = new Dementor("Dementor", 90, poder);

                poder = new BesoDelDementor("Beso del Dementor", 30, 20);

                dementor.setUltimate(poder);

                procesarLucha(dementor, 2);

                break;

            case 6:
                System.out.println("Agradezca siempre por haber hecho amigos tan valientes");
                System.out.println("Los dos te seguran a ver quien es el brujo misterioso");
                System.out.println("Que se apresenta como Sirius Black,");
                System.out.println("El Canuto, ultimo heredero de la familia Black.");
                System.out.println("...Sí! El famoso Tio de Harry Potter!...");

                break;

            case 7:
                System.out.println(" ");
                System.out.println("Ya empezaron las clases y tan temprano ya");
                System.out.println("quedaste conocid@ por perdese en las escaleras");
                System.out.println("Pero, por hacer amistad con algunos fantasmas del castillo");
                System.out.println("Uno de ellos te enseño un hechizo");

                hechizo = hechizoRandomSegunPersonaje(this.brujoElegido, hechizosRecibir);

                procesarAprender(this.brujoElegido, hechizo);

                break;

            case 8:
                System.out.println(" ");
                System.out.println("Muchos y muchos libros, pero solo uno habla de la camara");
                System.out.println("La página esta rota, pero hay algo que dice:");
                System.out.println("'... La camara protege un secreto mortal de quien la quier abrir.");
                System.out.println("El secreto es...'");
                System.out.println("...");
                System.out.println("No hay muchas informaciones utiles.");
                System.out.println("Quien será que está con la otra parte de la página?");
                System.out.println(" ");
                continuar();

                System.out.println("Leíste muchos libros");
                System.out.println("Por eso aprendiste un nuevo hechizo");
                System.out.println(" ");

                hechizo = hechizoRandomSegunPersonaje(this.brujoElegido, hechizosRecibir);

                procesarAprender(this.brujoElegido, hechizo);

                break;

            case 9:
                System.out.println(" ");
                System.out.println("Mismo no siendo un lugar mucho amigable, aqui estan!");
                System.out.println("Sientaste con tus amigos y pidieron unas cervezas amantegadas");
                System.out.println("Mientras piensan sobre lo que pueden hacer, alguén se aproxima...");
                System.out.println("...");
                continuar();
                System.out.println("Misterioso: 'Hola! Supe que buscan informaciones sobre la camara'");
                System.out.println("Vos: 'Si! Sabes de algo?' preguntas intentando identificar la persona");
                System.out.println("Misterioso: 'Sugiro que hablen con la Myrtle la llorona...'");
                System.out.println("Vos: 'pero...' lo misterioso no dejate terminar la frase");
                System.out.println("Misterioso: '...pero sean amigables y propongan ayuda!'");
                System.out.println("Habla las ultimas frases se levantando de la mesa para irse");
                System.out.println("Vos: 'Quien eres vos?'");
                System.out.println("Misterioso: 'Van y hablen con ella. Soy un amigo...'");
                continuar();
                System.out.println(" ");
                System.out.println("Que raro!!!!");
                System.out.println("Luego buscaron la Myrte en el baño feminino");
                System.out.println(" ");
                System.out.println("Vos: 'Hola? Myrte?'");
                System.out.println("Myrtle la llorona: 'Que haces aqui, " + a + "? Me deje sola!!!'");
                System.out.println("Vos: 'Perdon, Myrte! No quiero molestarte'");
                System.out.println("Vos: 'Porque lloras? Quiero ayudarte!'");
                System.out.println("impresionante como las palabras que dijiste la dejaron amigable.");
                System.out.println(" ");
                continuar();
                System.out.println("La Myrtle contó toda la história");
                System.out.println("Desde entonces, ya supieron como abrir la Camara");
                System.out.println("Para ayudarla, prometiste matar la criatura que se esconde");
                System.out.println("en la Camara. La misma que mató la Myrtle.");
                System.out.println("[ Siga para abrir la Camara Secreta ] ");

                break;

            case 10:
                System.out.println(" ");
                System.out.println("vos: 'Hola, Hagrid! Puedes me ayudar?'");
                System.out.println("Hagrid: 'Ya viene a me hacer preguntas que no puedo responder?'");
                System.out.println("Vos: 'Jajaja, es solo una curiosidad. Por favor!'");
                System.out.println("Hagrid: 'Dale!' ");
                System.out.println("Vos: 'Vi una puerta rara, en la torre norte, abajo de la clase de pociones");
                System.out.println("Sabes lo que hay ahí?'");
                continuar();
                System.out.println("Hagrid: 'Uh, que bueno que me preguntaste, " + a);
                System.out.println("Ahí está una de las criaturas que yá te habia dicho otro día,");
                System.out.println("una de esas que guarda las cosas de Dumbledore. Pero me parece que");
                System.out.println("lo que habia aí, recien fue retirado, solo hay la criatura.'");
                System.out.println(" ");
                System.out.println("[ Por no tener ido al peligro, aprendiste un nuevo hechizo con Hagrid ]");
                System.out.println(" ");

                hechizo = hechizoRandomSegunPersonaje(this.brujoElegido, hechizosRecibir);

                procesarAprender(this.brujoElegido, hechizo);
                break;

            case 11:
                System.out.println(" ");
                System.out.println("Dumbledore: '" + a + ", creo que no hay más tiempo!");
                System.out.println("Tu confronto con los comensales es inevitable!'");
                System.out.println(" ");
                System.out.println("Dumbledore te explicó toda la história de las Relíquias.");
                System.out.println("Te enseño un Hechizo");

                hechizo = hechizoRandomSegunPersonaje(this.brujoElegido, hechizosRecibir);

                procesarAprender(this.brujoElegido, hechizo);
                System.out.println(" ");
                System.out.println("Y te dijo que tenía la última Reliquia ");

                break;

            case 12:
            System.out.println(" ");
            System.out.println("Elegiste la Varita de Sauco");
            System.out.println("Felicitaciones! Esa es la última Reliquias de La muerte! ");
            System.out.println(" ");
            System.out.println(" !!!! Buena Suerte !!!!");
            System.out.println(" ");
            continuar();
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
                System.out.println("Monstruo: 'No te voy a dejar pasar. Órdenes de mi Dueño.");

                Elfo monstruo = new Elfo("Monstruo", 80, 100);
                for (int i = 0; i < this.brujoElegido.getHechizos().size(); i++) {
                    monstruo.getHechizos().add(hechizoRandomSegunPersonaje(monstruo, hechizosDanioBajo));

                }

                procesarLucha(monstruo, 1);

                break;

            case 4:
                llenarLosPuntos();
                System.out.println(" ");
                System.out.println("Por hacer amigos, aprendiste nuevas cosas");
                System.out.println(" ");
                Hechizo hechizo = new ExpectoPatronum("Expecto Patrono", false, 25);
                hechizo.setDescripcion("Entidad protetora en luz aparece");
                hechizo.setNivelDanio(35);
                hechizo.setNivelCuracion(0);
                procesarAprender(this.brujoElegido, hechizo);
                System.out.println(" ");
                continuar();
                break;

            case 5:

                continuar();

                break;

            case 6: 
                System.out.println("Sirius le regala una linda Capa");
                System.out.println(" ");

                Artefacto artefacto = new CapaInvisibilidad("Capa de invisibilidad", 0, 0.2);
                artefacto.setDescripcion("Deja invisible a quien usa");
                this.contenedoArtefactos.add(artefacto);
                continuar();

                break;

            case 7:
                llenarLosPuntos();

                break;

            case 8:
                System.out.println(" ");
                System.out.println("Parece que no lograste encontrar la Camara Secreta");

                procesarPuntosVida(this.brujoElegido, -10, "por el cansacio");

                continuar();
                break;

            case 9:
                System.out.println(" ");

                Poder poder = new Embestida("Embestida del Basilisco", 25, 15);
                Basilisco monstruo2 = new Basilisco("Basilisco", 90, poder);
                poder = new MiradaMortal("Mirada mortal del Basilisco", 30, 20);
                monstruo2.setUltimate(poder);
                for (int i = 0; i < this.brujoElegido.getHechizos().size(); i++) {
                    monstruo2.getHechizos().add(hechizoRandomSegunPersonaje(monstruo2, hechizosDanioMedio));

                }
                System.out.println("_______________________________________________________________________");
                System.out.println(" ");
                System.out.println(" !! Mision 2 concluída !!");
                System.out.println("La Myrtle se quedó feliz por cumpriren la promesa.");
                System.out.println("Tan feliz que no más lloró");
                System.out.println("Y le regalo una piedra valiosa");
                System.out.println(" ");

                artefacto = new PiedraResurreccion("Piedra de la resurreccion", 0, 0.3);
                artefacto.setDescripcion(
                        "Tiene el poder de traer a la gente de vuelta de la muerte como espíritus definidos, no como personas vivas.");
                this.contenedoArtefactos.add(artefacto);

                procesarLucha(monstruo2, 1);

                break;

            case 10:
                llenarLosPuntos();

                break;
            case 11:
            System.out.println(" ");
            System.out.println("É pone dos cajas en la mesa y explicate una cosa antes de");
            System.out.println("de dejarte sol@ en su oficina:");
            System.out.println("Dumbledore: 'Siempre creí que solo tu puedes hacer esto'");
            System.out.println("'Así, vas a tener que elegir cual es la relíquia que quieres'");
            System.out.println("'sí estás realmiente lis@, vas elegir la correcta!'");
            System.out.println(" ");

                continuar();

                break;

            case 12:
            System.out.println(" ");
            System.out.println("Los comensales Llegaron a Hogwads");
            System.out.println("Y Bellatrix Lestrange procura las relíquas, ");
            System.out.println(" ! Es la hora ! ");

            Poder poderInicial = new ParseTongue("Parse Tongue");
            poderInicial.setDescripcion("Puede Hablar la lenga de las cobras");
            Wizard bellatrix = new Wizard("Bellatrix", 100, 150, true, poderInicial);
            bellatrix.setEdad(39);
            this.getBrujos().add(bellatrix);
            for (int i = 0; i < this.brujoElegido.getHechizos().size(); i++) {
                bellatrix.getHechizos().add(hechizoRandomSegunPersonaje(bellatrix, hechizosRecibir));

            }

            procesarLucha(bellatrix, 1);
            

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

                if (defensor instanceof Dementor) {

                    imprimirExpectoPatronum();

                } else {

                    imprimirHechizosBrujo();
                }

                System.out.println("Insira el número del hechizo que quiere usar:");
                a = teclado.nextInt();

                hechizo = this.brujoElegido.getHechizos().get(a - 1);

                turno1 = procesarTipoHechizoLanzado(atacante, defensor, hechizo, turno1);

            } else {

                atacante = personaje;
                defensor = this.brujoElegido;

                if (personaje instanceof Wizard) {

                    Wizard brujo = (Wizard) personaje;

                    hechizo = seleccionarHechizoRandom(brujo.getHechizos());

                    turno1 = procesarTipoHechizoLanzado(atacante, defensor, hechizo, turno1);

                } else if (personaje instanceof Elfo) {
                    Elfo elfo = (Elfo) personaje;

                    hechizo = seleccionarHechizoRandom(elfo.getHechizos());

                    turno1 = procesarTipoHechizoLanzado(atacante, defensor, hechizo, turno1);

                } else {

                    procesarAtaquePoder(atacante, defensor);

                    turno1 = !turno1;
                }

            }

            // if (!(hechizo instanceof HechizoDefensa)) {

            // turno1 = !turno1;

            // }

        }

        verificarQuienGanio(personaje, numeroBloque);

    }

    public void imprimirExpectoPatronum() {

        for (Hechizo hechizo3 : this.brujoElegido.getHechizos()) {

            if (hechizo3 instanceof ExpectoPatronum) {

                int e = this.brujoElegido.getHechizos().indexOf(hechizo3) + 1;

                System.out.println(e + " - " + hechizo3.getNombre() + " | Nivel de daño: " + hechizo3.getNivelDanio()
                        + " | Nivel de cura: " + hechizo3.getNivelCuracion() + " | Energia mágica: "
                        + hechizo3.getEnergiaMagica() + " | Oscuro: "
                        + transformarTrueEnSiYFalseEnNo(hechizo3.getEsOscuro()));

            }

        }
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

        System.out.println("Insira 1 para intentar de nuevo o 2 para desistir.");
        int a = teclado.nextInt();

        if (this.brujoElegido.tomarDecision(a)) {

            reinicializarBloque(numeroBloque);

        } else {

            gameOver();

        }
    }

    // Reinicializa el Bloque en que el jugador murrió

    public void reinicializarBloque(int numeroDelBloque) {

        switch (numeroDelBloque) {
            case 1:

                llenarLosPuntos();
                inicializarBloqueArmazon(1);

                break;

            case 2:
                llenarLosPuntos();
                inicializarBloqueArmazon(2);

                break;

            case 3:

                llenarLosPuntos();
                inicializarBloqueArmazon(3);

                break;

            case 4:

                llenarLosPuntos();
                inicializarBloqueArmazon(4);

                break;

            default:
                break;
        }

    }

    public void llenarLosPuntos() {
        this.brujoElegido.setSalud(100);
        this.brujoElegido.setEnergiaMagica(100);

        System.out.println(" ");
        System.out.println(" [ Tus puntos de vida han sido restaurados a 100 y 100 ] ");
        System.out.println(" ");
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

        Hechizo hechizo = new Opugno("Opugno", false, 10);
        hechizo.setDescripcion("Hace con que objector cercanos ataquen el oponente.");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(15);
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

    // Recibe mision

    public void imprimirRecibirPrimerMision() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("!! [ Recibiste tu primer misión menor: llegar al expreso de Hogwarts! ] !!");

    }

    public void imprimirRecibirSegundaMision() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("!! [ Recibiste tu segunda misión menor: Encontrar la camara secreta! ] !!");

    }

    // Imprime busquedas

    public void imprimirBusquedaCamara1() {
        System.out.println("[ Ingrese el número del lugar que quieres buscar informaciones ]");
        System.out.println("1 - Casa de Hagrid");
        System.out.println("2 - Biblioteca");

    }

    public void imprimirBusquedaCamara2() {
        System.out.println("[ Ingrese el número del lugar que quieres buscar informaciones ]");
        System.out.println("1 - Baño feminino");
        System.out.println("2 - El Caldero Chorreante");
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
        Hechizo hechizo = new Expelliarmus("Paralizante", false, 15); // ataque
        hechizo.setDescripcion("paralisa la victima");
        hechizo.setNivelDanio(25);
        hechizo.setNivelCuracion(0);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new WingardumLeviosa("Vulto", false, 10); // ocio
        hechizo.setDescripcion("Hace sombras por todos los lados, confundindo la victma");
        hechizo.setNivelDanio(0);
        hechizo.setNivelCuracion(0);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new Stupefy("Rebatada", false, 10); // ataque
        hechizo.setDescripcion("Arrebata la victima");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(20);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new Stupefy("Rebatada dupla", false, 20); // ataque
        hechizo.setDescripcion("Arrebata la victima dos veces");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(30);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new Protego("Rechazo", false, 10); // defensa
        hechizo.setDescripcion("Rechaza hechizo");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(0);
        this.hechizosDanioMedio.add(hechizo);

        hechizo = new Stupefy("Jato de água", false, 15); // ataque
        hechizo.setDescripcion("hace un jato de água fuerte contra la victma");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(25);
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

        hechizo = new SectumSepra("Sectumsepra", true, 30);
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

        hechizo = new Glacius("Glacius", false, 15);
        hechizo.setDescripcion("Capaz de congelar varios centímetros cúbicos de agua sólida en cuestión de segundos.");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(20);
        this.hechizosRecibir.add(hechizo);

        hechizo = new Obliviate("Obliviate", false, 5);
        hechizo.setDescripcion("Es un hechizo para borrar algo de la memória de um Wizard o Muggle");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(0);
        this.hechizosRecibir.add(hechizo);
        

        hechizo = new PetrificusTotalus("Petrificus Totalus", false, 10);
        hechizo.setDescripcion("Paraliza al oponente.");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(15);
        this.hechizosRecibir.add(hechizo);

        hechizo = new Rictusempra("Rictusempra", false, 15);
        hechizo.setDescripcion("provoca en la víctima fuertes cosquillas, lo cual le genera un ataque de risa.");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(25);
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

    // Verifica y responde según en tipo de hechizo lanzado

    public boolean procesarTipoHechizoLanzado(Personaje atacante, Personaje defensor, Hechizo hechizo, boolean turno1) {

        if (atacante instanceof Wizard && ((Wizard) atacante).getEnergiaMagica() >= hechizo.getEnergiaMagica()) {
            Wizard wizard = (Wizard) atacante;

            if (hechizo instanceof HechizoAtaque) {

                wizard.atacar(defensor, hechizo);

                imprimirHablaAtaque(wizard, defensor, hechizo);

                return turno1 = !turno1;

            } else if (hechizo instanceof HechizoCuracion) {

                wizard.curarse(hechizo);

                imprimirHablaCuracion(wizard, hechizo);

                return turno1 = !turno1;

            } else if (hechizo instanceof HechizoDefensa) {

                wizard.defenderse(hechizo);

                imprimirHablaDefensa(wizard, defensor, hechizo);

                return turno1;

            } else if (hechizo instanceof HechizoOcio) {
                procesarHechizoOcio(atacante, hechizo);

                return turno1 = !turno1;
            }

        } else if (atacante instanceof Elfo && ((Elfo) atacante).getEnergiaMagica() >= hechizo.getEnergiaMagica()) {
            Elfo elfo = (Elfo) atacante;

            if (hechizo instanceof HechizoAtaque) {

                elfo.atacar(defensor, hechizo);

                imprimirHablaAtaque(elfo, defensor, hechizo);

                return turno1 = !turno1;

            } else if (hechizo instanceof HechizoCuracion) {

                elfo.curarse(hechizo);

                imprimirHablaCuracion(elfo, hechizo);

                return turno1 = !turno1;

            } else if (hechizo instanceof HechizoDefensa) {

                elfo.defenderse(hechizo);

                imprimirHablaDefensa(elfo, defensor, hechizo);

                return turno1;

            } else if (hechizo instanceof HechizoOcio) {
                procesarHechizoOcio(atacante, hechizo);

                return turno1 = !turno1;
            }

        } else if (((Elfo) atacante).getEnergiaMagica() <= 0) {

            imprimirHablaSinEnergiaMagica(atacante, hechizo);

            return turno1 = !turno1;
        }

        return turno1 = !turno1;

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

    public void imprimirHablaSinEnergiaMagica(Personaje personaje, Hechizo hechizo) {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(" [ " + personaje.getNombre() + " no tiene suficiente energia mágica para lanzar el hechizo "
                + hechizo.getNombre() + " ] ");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");

    }

    public void imprimirHablaCuracion(Personaje personaje, Hechizo hechizo) {

        System.out.println(" ");
        System.out.println(" [ " + personaje.getNombre() + " usó el hechizo de curación " + hechizo.getNombre()
                + " y consumió " + hechizo.getEnergiaMagica() + " de energia mágica ] ");
        System.out.println(" [ La salud actual de " + personaje.getNombre() + " es de " + personaje.getSalud() + " ] ");
        System.out.println(" ");

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

    public void procesarPuntosVida(Personaje personaje, int numero, String motivo) {

        if (numero < 0) {
            System.out.println(" ");
            System.out.println(" [ Perdiste " + numero + " puntos de vida " + motivo + " ] ");
            System.out.println(" ");
        } else {

            System.out.println(" ");
            System.out.println(" [ Ganaste " + numero + " puntos de vida " + motivo + " ] ");
            System.out.println(" ");
        }

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

    public void procesarAtaquePoder(Personaje atacante, Personaje defensor) {

        int a = 0;
        String nombreAtaque = " ";

        if (atacante instanceof Dementor) {
            Dementor dementor = (Dementor) atacante;

            if (atacante.getSalud() < 10 && defensor.getSalud() < 30) {

                a = dementor.atacar(defensor, dementor.getUltimate());

                nombreAtaque = dementor.getUltimate().getNombre();

            } else {

                a = dementor.atacar(defensor, dementor.getPoderInicial());

                nombreAtaque = dementor.getPoderInicial().getNombre();
            }

        } else if (atacante instanceof Basilisco) {
            Basilisco basilisco = (Basilisco) atacante;

            if (atacante.getSalud() < 10 && defensor.getSalud() < 30) {

                a = basilisco.atacar(defensor, basilisco.getUltimate());

                nombreAtaque = basilisco.getUltimate().getNombre();

            } else {

                a = basilisco.atacar(defensor, basilisco.getPoderInicial());

                nombreAtaque = basilisco.getPoderInicial().getNombre();
            }

        }

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(" [ " + atacante.getNombre() + " atacó " + defensor.getNombre() + " con el poder "
                + nombreAtaque + " ] ");
        System.out.println(" [ " + atacante.getNombre() + " consumió " + a + " de energia mágica ] ");
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