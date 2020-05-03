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
    //private List<Personaje> npcs = new ArrayList<>(); TODO
    private List<Mascota> mascotas = new ArrayList<>();
    private Wizard brujoElegido;

    // Ver si debo crear siempre una nueva variable (int, string) para cada método o
    // si puedo reutilizarlas

    public void inicializarApertura() {
        this.inicializarBrujosBloque1();
        this.inicializarMascotas();
        // this.inicializarArtefactos(); -- leer descripcion en método
        this.inicializarBienvenida();
        this.aplicarBonusMascota(); // TODO

    }

    public void inicializarPrimerBloque() {

        inicializarHistoriaPrimerBloque();

    }

    public void inicializarHistoriaPrimerBloque() {

        int a;

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        salirDeLaCasa();
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Ahora que saliste, tenés que llegar a la estación.");
        System.out.println("Cómo quieres llegar a la estación? Insira 1 para caminar y 2 para llamar al Autobús noctámbulo");
        a = teclado.nextInt();

        if (a == 2) {

            System.out.println("Caminaste por veinte minutos.");
            System.out.println(" [ Perdiste 5 puntos de vida ] ");

            int b = this.brujoElegido.getSalud() - 5; // crear método en wizard? sufrirDanio
            this.brujoElegido.setSalud(b);
            
            System.out.println("Cansado, te detuviste para descansar un poco y");
            System.out.println("al mirar hacia un lado, encontraste algo inesperado.");

            System.out.println(" [ Encontraste una escoba con tu nombre ] ");

            //Escoba escoba = new Escoba(nombre, tipo);  // crear lista y sacar random

            Hechizo hechizo = new ArrestoMomentum("Arresto Momentum", false, 5);
            hechizo.setDescripcion(
                    "Es un encantamiento que hace más lento o detiene el movimiento de un objeto o persona.");
            hechizo.setNivelCuracion(0);
            hechizo.setNivelDanio(0);

            this.brujoElegido.aprender(hechizo);

            System.out.println(" [ Aprendiste el hechizo " + hechizo.getNombre() + " ] ");
            System.out.println(" [ Usaste el hechizo " + hechizo.getNombre() + " y consumiste "
                    + hechizo.getEnergiaMagica() + " de energia mágica ] ");

            b = this.brujoElegido.getEnergiaMagica() - hechizo.getEnergiaMagica();
            this.brujoElegido.setEnergiaMagica(b);

        } else {

            System.out.println("Saliste por la puerta principal");

        }

    }

    public void salirDeLaCasa() {
        int a;

        System.out.println("Estás dentro de tu casa y tenés que sair.");
        System.out.println("Por donde quieres salir? Insira 1 para puerta y 2 por la ventana.");
        a = teclado.nextInt();
        if (a == 2) {

            System.out.println("Todas las ventanas de la planta baja estan cerradas y no abren.");
            System.out.println("Subiste al último piso y saltaste por la ventana;");

            Hechizo hechizo = new ArrestoMomentum("Arresto Momentum", false, 5);
            hechizo.setDescripcion(
                    "Es un encantamiento que hace más lento o detiene el movimiento de un objeto o persona.");
            hechizo.setNivelCuracion(0);
            hechizo.setNivelDanio(0);

            this.brujoElegido.aprender(hechizo);

            System.out.println(" [ Perdiste 5 puntos de vida ] ");

            int b = this.brujoElegido.getSalud() - 5; // crear método en wizard? sufrirDanio
            this.brujoElegido.setSalud(b);

            System.out.println(" [ Aprendiste el hechizo " + hechizo.getNombre() + " ] ");
            System.out.println(" [ Usaste el hechizo " + hechizo.getNombre() + " y consumiste "
                    + hechizo.getEnergiaMagica() + " de energia mágica ] ");

            b = this.brujoElegido.getEnergiaMagica() - hechizo.getEnergiaMagica();
            this.brujoElegido.setEnergiaMagica(b);

        } else {

            System.out.println("Saliste por la puerta principal sin grandes problemas.");

        }

    }

    // Esto carga los brujos del primer bloque a la lista de brujos del juego

    public void inicializarBrujosBloque1() {

        Poder poderInicial = new Expelliarmus("Expelliarmus", false, 10); // TODO chequear valores que se sacan

        poderInicial.setDescripcion(
                "También conocido como el encantamiento desarmador, es un encantamiento defensivo que fuerza a la víctima a soltar lo que sea que esté sujetando.");

        Wizard brujo = new Wizard("Harry Potter", 17, false, poderInicial);

        Hechizo hechizo = this.castearPoderAHechizo(poderInicial);

        hechizo.setNivelDanio(10); // TODO chequear valor de daño
        hechizo.setNivelCuracion(0);

        brujo.getHechizos().add(hechizo);

        Varita varita = new Varita("Varita de Harry", 0.1, 0.1);
        // TODO hay que definir si se hacen nuevos objetos o no de estas varitas
        // iya: creo que no, para no complexar más
        varita.setDescripcion("28cm, hecha de acebo, con una pluma de fénix en su centro.");

        brujo.setVarita(varita);

        this.getBrujos().add(brujo);

        poderInicial = new WingardumLeviosa("Wingwardum Leviosa", false, 10);
        poderInicial.setDescripcion("Es un encantamiento usado para hacer que los objetos vuelen o leviten.");

        brujo = new Wizard("Hermione Granger", 17, false, poderInicial);

        hechizo = this.castearPoderAHechizo(poderInicial);

        hechizo.setNivelDanio(5); // TODO
        hechizo.setNivelCuracion(0);

        brujo.getHechizos().add(hechizo);

        varita = new Varita("Varita de Ronald", 0.1, 0.1); // TODO
        varita.setDescripcion("36 cm, hecha de sauce, con un núcleo de Pelo de Unicornio.");

        brujo.setVarita(varita);

        this.getBrujos().add(brujo);

        poderInicial = new VulneraSanetur("Vulnera Sanentur", false, 10);
        poderInicial.setDescripcion(
                "Hechizo sanador que parece una canción, y que corresponde al contrahechizo de la maldición sectumsempra.");

        brujo = new Wizard("Ronald Weasley", 17, false, poderInicial);

        hechizo = this.castearPoderAHechizo(poderInicial);

        hechizo.setNivelDanio(0);
        hechizo.setNivelCuracion(10); // TODO

        brujo.getHechizos().add(hechizo);

        varita = new Varita("Varita de Ronald", 0.1, 0.1); // TODO
        varita.setDescripcion("36 cm, hecha de sauce, con un núcleo de Pelo de Unicornio.");

        brujo.setVarita(varita);

        this.getBrujos().add(brujo);

    }

    // Esto exibe en pantalla la apertura del juego donde se elige un personaje y
    // una mascota

    public void inicializarBienvenida() {

        String a = this.getBrujoElegido().getNombre();

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("!! Bienvenido al mundo TP_Harry_Potter by Iya y Tati !!");
        System.out.println("Recién transmigraste a este mundo mágico, pero no tema, buena suerte!");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        this.eligirUnPersonaje(); // De acá

        Carta carta = new Carta("Carta de Hogwarts", "Hogwarts");
        carta.setContenido(System.lineSeparator() + "'Estimad@ " + a + ", nos complace informarle que ha sido"
                + System.lineSeparator() + " aceptado en Hogwarts School of Witchcraft and Wizardry. Venga!'");

        this.entregarCarta(carta);

        carta = new Carta("Carta de Hagrid", "Hagrid");
        carta.setContenido(
                System.lineSeparator() + "'Querid@ " + a + ", se suponía que debía guiarte a Hogwarts, pero tuve"
                        + System.lineSeparator() + "una pequeña emergencia. Ya compré todos sus materiales y los"
                        + System.lineSeparator() + "envié a Hogwarts. Cuanto a su mascota, podés elegirla"
                        + System.lineSeparator() + "al final de esta carta. Tu poder inicial también se confirmará"
                        + System.lineSeparator() + "para ayudarte a llegar al expreso de Hogwarts a salvo.''");

        this.entregarCarta(carta);

        this.recibisteTuPrimerMision();
        this.confirmacionPoderInicial();
        this.eligirUnaMascota();
        this.mostrarStatus(); // hasta acá. Poner en App?
        System.out.println("Ahora estamos estamos listos! Adelante!");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
    }

    public void recibirObjetivo() {

        String a = this.getBrujoElegido().getNombre();

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("*Escuchas algo raro*");
        System.out.println("Vos: ?? Que sonido es ese?");
        System.out.println("*Seguís el sonido*");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println("*Chocaste con un elfo*");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
        System.out.println("Dobby: 'Hola, " + a + "! Perdoname! Me llamo Dobby,soy un elfo domestico.");
        System.out.println("No tengas miedo, no te quiero hacer mal. Supe que recibiste su carta de");
        System.out.println("Hogwards, pero tenga cuidado. Van acontecer cosas horribles por la");
        System.out.println("escuela y creo que eres la unica persona que puede salvar a Hogwards.'");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
        System.out.println("Vos: 'cosas horribles? Solo yo? por que? Dobby?'");
        System.out.println("Dobby: 'Si! No tengo mucho tiempo. Solamente me escuche con atención");
        System.out.println("Su objetivo es encontrar las 4 Reliquias de la Muerte");
        System.out.println("Para eso, va a tener que hacer amigos confiables y buscarlas.'");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
        System.out.println("Vos: 'Calma! Hay que explicarme eso!'");
        System.out.println("Dobby: '" + a + ", escuchaste?");
        System.out.println("Cuidate! Y solo confies em Dumbledore! Él me envió acá-'");
        System.out.println("*El elfo dejate de subto*");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(" [Ingrese 0 para continuar] ");
        teclado.next("0");
        System.out.println("Y ahora? Aceptas tu objectivo?");
        System.out.println(" [Ingrese '1' para aceptar el ojectivo] ");
        teclado.next("1");
    }

    // Esto carga las mascotas eligibles en bloque uno

    public void inicializarMascotas() {

        Mascota mascota = new Buho("Edwiges", 2, 10, 5);

        this.mascotas.add(mascota);

        mascota = new Gato("Crookshanks", 3, 5, 10);

        this.mascotas.add(mascota);

        mascota = new Rata("Scabbers", 35, 0, 5);

        this.mascotas.add(mascota);

        mascota = new Sapo("Trevor", 5, 7, 7);

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
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");

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
        System.out.println("Nombre: " + this.brujoElegido.getNombre());
        System.out.println("Edad: " + this.brujoElegido.getEdad());
        System.out.println("Hechizos:");
        mostrarHechizosBrujo();
        System.out.println("Brujo Oscuro: " + transformarTrueEnSiYFalseEnNo(this.brujoElegido.getMagoOscuro()));
        System.out.println("Mascota: " + this.brujoElegido.getMascota().getNombre());
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

        for (Hechizo hechizo : this.brujoElegido.getHechizos()) {
            contador++;

            System.out.println(contador + " - " + hechizo.getNombre() + " | Nivel de daño: " + hechizo.getNivelDanio()
                    + " | Nivel de cura: " + hechizo.getNivelCuracion());

        }

    }

    // Esto castea Poder a Hechizo

    public Hechizo castearPoderAHechizo(Poder poderInicial) {

        if (poderInicial instanceof Hechizo) {

            Hechizo hechizos = (Hechizo) poderInicial;

            return hechizos;
        }

        return null;

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

        this.brujoElegido.recibirCarta(carta); // TODO finalizar carta con metodo en wizard
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Quieres leer la carta de " + carta.getSender() + "? Insira 1 para si y 2 para no.");

        numero = teclado.nextInt();

        if (this.brujoElegido.tomarDecision(numero)) {

            System.out.println(carta.getContenido());

        }
    }

    // "Activa" y exibe en pantalla el poder inicial

    public void confirmacionPoderInicial() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println(
                "*Tu poder inicial, " + this.brujoElegido.getPoderInicial().getNombre() + ", está confirmado*");
        System.out.println("Daño: " + this.brujoElegido.getHechizos().get(0).getNivelDanio() + "  |  Curación: "
                + this.brujoElegido.getHechizos().get(0).getNivelCuracion());
        System.out.println("Descripción:" + this.brujoElegido.getPoderInicial().getDescripcion());
    }

    // Recibe Primer mision

    public void recibisteTuPrimerMision() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out
                .println("!! [ Recibiste tu primer misión: llegar vivo hasta llegar vivo al expreso de Hogwarts! ] !!");

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