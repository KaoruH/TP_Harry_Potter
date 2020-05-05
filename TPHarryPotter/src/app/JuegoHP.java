package app;

import java.util.*;

import app.artefactos.*;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.*;
//import app.transportes.*; TODO

public class JuegoHP {

    public static Scanner teclado = new Scanner(System.in);

    private List<Wizard> brujosAElegir = new ArrayList<>();
    private List<Hechizo> hechizosRecibir = new ArrayList<>();
    private List<Mascota> mascotas = new ArrayList<>();
    private Wizard brujoElegido;

    // Ver si debo crear siempre una nueva variable (int, string) para cada método o
    // si puedo reutilizarlas

    public void inicializarApertura() {
        this.inicializarBrujosBloque1();
        this.inicializarMascotas();
        this.inicializarBienvenida();
    }

    public void inicializarPrimerBloque() {

        this.inicializarHechizosARecibir();
        this.recibirObjetivo();
        this.salirDeLaCasa();
        this.llegarALaEstacion();
        this.entrarEnElExpreso();
    }

    public void entrarEnElExpreso() {

        int a;

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Ahora falta poco! Sólo tenés que llegar hasta el Expreso de Hogwarts");
        System.out.println("Qué prefieres hacer: insira 1 para ir directamente a la plataforma 9 3/4 o");
        System.out.println("2 para pasear un poco?");
        a = teclado.nextInt();

        if (a == 1) {

            System.out.println("Sin desvíos para ti ya veo. Re responsable! Esto pide una recompensa:");

            Hechizo hechizo = seleccionarHechizoRandom();

            this.brujoElegido.aprender(hechizo);

        } else {

            System.out.println("Tomaste tu tiempo para conoscer a la estación King's Cross");
            System.out.println("y aprovechaste el paseo para comer algo.");
            System.out.println(" [ Recuperaste 5 puntos de vida ] ");

            int b = this.brujoElegido.getSalud() + 5;
            this.brujoElegido.setSalud(b);

            System.out.println("Y luego tomó tu camino hasta el expreso.");

        }

        System.out.println("Adentraste la pared de la plataforma 9 3/4 y caminaste en direción al expreso.");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(" [ !!!! ] ");
        System.out.println("Una figura se metío en tu frente");
        System.out.println("Monstruo: 'No te voy a dejar pasar. Órdenes de mi maestro.");

        Elfo monstruo = new Elfo("Monstruo", 80);
        monstruo.setEnergiaMagica(100);
        monstruo.getHechizos().add(seleccionarHechizoRandom());
        monstruo.getHechizos().add(seleccionarHechizoRandom());
        monstruo.getHechizos().add(seleccionarHechizoRandom());

        empezarLucha(monstruo);

    }

    public void empezarLucha(Personaje personaje) {

        int a;

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(" [ Iniciaste una lucha contra " + personaje.getNombre() + " ] ");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Insira 1 para ver tu status y 2 para eligir tu primera acción.");
        a = teclado.nextInt();
        if (a == 1) {

            mostrarStatus();

        }

        System.out.println("Insira 1 para usar un hechizo, 2 para usar su poder inicial o 3 para no hacer nada.");
        a = teclado.nextInt();
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        switch (a) { // TODO everything. Hay que separar en métodos menores, hay que arreglar los
                     // métodos de IHACEMAGIA...
            case 1:

                mostrarHechizosBrujo();
                System.out.println("Insira el número del hechizo que quiere usar:");
                a = teclado.nextInt();

                if (brujoElegido.getHechizos().get(a - 1) instanceof HechizoAtaque) {

                    brujoElegido.atacar(personaje, brujoElegido.getHechizos().get(a - 1));

                } else if (brujoElegido.getHechizos().get(a - 1) instanceof HechizoCuracion) {
                   // brujoElegido.curarse(brujoElegido.getHechizos().get(a - 1));
                } else if (brujoElegido.getHechizos().get(a - 1) instanceof HechizoDefensa) {

                } else {

                }

                break;

            case 2:

                break;

            case 3:

                break;

            default:
                break;
        }

    }

    public void llegarALaEstacion() {
        int a;

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Ahora que saliste, tenés que llegar a la estación King's Cross.");
        System.out.println(
                "Cómo quieres llegar a la estación? Insira 1 para caminar y 2 para llamar al Autobús noctámbulo");
        a = teclado.nextInt();

        if (a == 1) {

            System.out.println("Caminaste, caminaste, caminaste...");
            System.out.println(" ");
            System.out.println(" [ Perdiste 5 puntos de vida por el cansancio ] ");
            System.out.println(" ");

            int b = this.brujoElegido.getSalud() - 5;
            this.brujoElegido.setSalud(b);

            System.out.println("Cansado, te detuviste para descansar un poco y");
            System.out.println("al mirar hacia un lado y algo inesperado ocurrió.");
            System.out.println(" ");

            Hechizo hechizo = seleccionarHechizoRandom();

            this.brujoElegido.aprender(hechizo);
            System.out.println(" ");

            System.out.println("Eventualmente llegaste a la estación King's Cross");

        } else {

            System.out.println(
                    "Estendiste tu varita en la acera y luego el Autobús noctámbulo llegó casi aplastando tu pie");
            System.out.println(" ");
            System.out.println(" [ Perdiste 5 puntos de vida en el recorrido ] ");
            System.out.println(" ");
            int b = this.brujoElegido.getSalud() - 5;
            this.brujoElegido.setSalud(b);

            System.out.println("Llegaste a la estación King's Cross re rapido!");

        }

        System.out.println(" ");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
        System.out.println(" ");
    }

    public void salirDeLaCasa() {
        int a;

        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(" ");
        System.out.println("Estás dentro de tu casa y tenés que sair.");
        System.out.println("Por donde quieres salir? Insira 1 para puerta y 2 por la ventana.");
        a = teclado.nextInt();
        if (a == 2) {

            System.out.println("Todas las ventanas de la planta baja estan cerradas y no abren.");
            System.out.println("Subiste al último piso y saltaste por la ventana;");

            Hechizo hechizo = seleccionarHechizoRandom();

            this.brujoElegido.aprender(hechizo);
            System.out.println(" ");

            System.out.println(" [ Perdiste 5 puntos de vida de vida al caer de la ventana ] ");

            int b = this.brujoElegido.getSalud() - 5; // crear método en wizard? sufrirDanio
            this.brujoElegido.setSalud(b);
            System.out.println(" ");

            System.out.println("Saliste por ventana con relativo exito.");

        } else {

            System.out.println("Saliste por la puerta principal sin grandes problemas.");

        }

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

        varita = new VaritaVid("Varita de Hermione Granger", 0, 0); // TODO
        varita.setDescripcion("27,3cm, hecha de vid, con núcleo de fibra de corazón de dragón.");

        brujo.setVarita(varita);

        this.getBrujos().add(brujo);

        poderInicial = new Metamorfosis("Metamorfosis");
        poderInicial.setDescripcion("Puedes transformarse en un gato. Cuidado con los perros!");

        brujo = new Wizard("Ron Weasley", 90, 100, false, poderInicial);
        brujo.setEdad(17);

        varita = new VaritaSauce("Varita de Ronald", 0, 0); // TODO
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
        this.recibisteTuPrimerMision();
        this.confirmacionPoderInicial();
        this.eligirUnaMascota();
        this.aplicarBonusMascota();
        this.mostrarStatus();
        System.out.println("Ahora estamos estamos listos! Adelante!");
        System.out.println(" ");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
        System.out.println(" ");
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

    public void mostrarStatus() {

        System.out.println(" [ Tu status actual es: ] ");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out
                .println("Nombre: " + this.brujoElegido.getNombre() + "     |   Edad: " + this.brujoElegido.getEdad());
        System.out.println("Puntos de vida: " + this.brujoElegido.getSalud() + "     |   Energia Mágica: "
                + this.brujoElegido.getEnergiaMagica());
        System.out.println("Hechizos:");
        mostrarHechizosBrujo();
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
        System.out.println(" ");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
        System.out.println(" ");
        System.out.println("Dobby: 'Hola, " + a + "! Perdoname! Me llamo Dobby,soy un elfo domestico.");
        System.out.println("No tengas miedo, no te quiero hacer mal. Supe que recibiste su carta de");
        System.out.println("Hogwards, pero tenga cuidado. Van acontecer cosas horribles por la");
        System.out.println("escuela y creo que eres la unica persona que puede salvar a Hogwards.'");
        System.out.println(" ");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
        System.out.println(" ");
        System.out.println("Vos: 'cosas horribles? Solo yo? por que? Dobby?'");
        System.out.println("Dobby: 'Si! No tengo mucho tiempo. Solamente me escuche con");
        System.out.println("atención: tu objetivo es encontrar las  Reliquias de la Muerte");
        System.out.println("Para eso, va a tener que hacer amigos confiables y buscarlas.'");
        System.out.println(" ");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
        System.out.println(" ");
        System.out.println("Vos: 'Calma! Hay que explicarme eso!'");
        System.out.println("Dobby: '" + a + ", escuchaste?");
        System.out.println("Cuidate! Y solo confies em Dumbledore! Él me envió acá-'");
        System.out.println("*El elfo dejate de subto*");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
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
        this.brujoElegido.aprender(hechizo);
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

    public void mostrarHechizosBrujo() {

        int contador = 0;

        if (this.brujoElegido.getHechizos() != null && this.brujoElegido.getArtefacto() != null) {
            for (Hechizo hechizo : this.brujoElegido.getHechizos()) {
                contador++;

                System.out.println(contador + " - " + hechizo.getNombre() + " | Nivel de daño: "
                        + hechizo.getNivelDanio() + " + " + this.brujoElegido.getArtefacto().getAmplificadorDeDanio()
                        + "%" + " | Nivel de cura: " + hechizo.getNivelCuracion() + " + "
                        + this.brujoElegido.getArtefacto().getAmplificadorDeCuración() + "%");

            }

        } else if (this.brujoElegido.getHechizos() != null) {

            for (Hechizo hechizo : this.brujoElegido.getHechizos()) {
                contador++;

                System.out.println(contador + " - " + hechizo.getNombre() + " | Nivel de daño: "
                        + hechizo.getNivelDanio() + " | Nivel de cura: " + hechizo.getNivelCuracion());

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

    public void confirmacionPoderInicial() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(
                "*Tu poder inicial, " + this.brujoElegido.getPoderInicial().getNombre() + ", está confirmado*");

    }

    // Recibe Primer mision

    public void recibisteTuPrimerMision() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("!! [ Recibiste tu primer misión menor: llegar al expreso de Hogwarts! ] !!");

    }

    // Carga todos los hechizos

    public void inicializarHechizosARecibir() {

        Hechizo hechizo = new Expelliarmus("Expelliarmus", false, 15);
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
        hechizo.setDescripcion(
                "Se mantiene alejados a los enemigos");
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
        hechizo.setDescripcion(
                "es un hechizo que deja inconsciente a la víctima y detiene objetos en movimiento.");
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
        hechizo.setDescripcion(
                "la maldición genera un dolor intenso y agónico en la víctima.");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(30);
        this.hechizosRecibir.add(hechizo);

        hechizo = new Incarcerous("Incarcerous", true, 20);
        hechizo.setDescripcion(
                "la maldición genera un dolor intenso y agónico en la víctima.");
        hechizo.setNivelCuracion(0);
        hechizo.setNivelDanio(30);
        this.hechizosRecibir.add(hechizo);


    }

    // Selecciona un hechizo aleatorio

    public Hechizo seleccionarHechizoRandom() {

        Random random = new Random();

        int numero = random.nextInt(hechizosRecibir.size());

        Hechizo hechizo = hechizosRecibir.get(numero);

        while (brujoElegido.getHechizos().contains(hechizo)) {

            numero = random.nextInt(hechizosRecibir.size());

            hechizo = hechizosRecibir.get(numero);

        }

        return hechizo;
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

}