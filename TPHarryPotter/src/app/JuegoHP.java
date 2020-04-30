package app;

import java.util.*;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.*;

public class JuegoHP {

    public static Scanner teclado = new Scanner(System.in);

    private List<Wizard> brujos = new ArrayList<>();
    private List<Mascota> mascotas = new ArrayList<>();
    private Wizard brujoElegido;

    public void inicializarJuegoHP() {
        this.inicializarBrujosBloque1();
        this.inicializarMascotas();
        this.inicializarArtefactos();
        this.inicializarApertura();
    }

    // Esto carga los brujos del primer bloque a la lista de brujos del juego

    public void inicializarBrujosBloque1() {

        Poder poderInicial = new Expelliarmus("Expelliarmus", false, 10);

        poderInicial.setDescripcion(
                "También conocido como el encantamiento desarmador, es un encantamiento defensivo que fuerza a la víctima a soltar lo que sea que esté sujetando.");


        Wizard brujo = new Wizard("Harry Potter", 17, false, poderInicial);

        Hechizo hechizo = this.castearPoderAHechizo(poderInicial);

        brujo.getHechizos().add(hechizo);
        this.getBrujos().add(brujo);

        poderInicial = new WingardumLeviosa("Wingwardum Leviosa", false, 10);
        poderInicial.setDescripcion("Es un encantamiento usado para hacer que los objetos vuelen o leviten.");

        brujo = new Wizard("Hermione Granger", 17, false, poderInicial);

        hechizo = this.castearPoderAHechizo(poderInicial);
        brujo.getHechizos().add(hechizo);
        this.getBrujos().add(brujo);

        poderInicial = new VulneraSanetur("Vulnera Sanentur", false, 10);

        brujo = new Wizard("Ronald Weasley", 17, false, poderInicial);

        hechizo = this.castearPoderAHechizo(poderInicial);
        brujo.getHechizos().add(hechizo);
        this.getBrujos().add(brujo);

    }

    // Esto exibe en pantalla la apertura del juego donde se elige un personaje y una mascota

    public void inicializarApertura() {

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("!! Bienvenido al mundo TP_Harry_Potter by Iya y Tati !!");
        System.out.println("Recién transmigraste a este mundo mágico, pero no tema, buena suerte!");
        System.out.println("_______________________________________________________________________");
        this.eligirUnPersonaje();
        System.out.println(" ");
        System.out.println("*Recibiste una carta de Hogwarts*");
        System.out.println("'Hogwarts? O-M-G! HOGWARTS!! Recibí una carta de Hogwarts!' - exclama vós.");
        System.out.println(" ");
        System.out.println("Curioso como sos, la abres inmediatamente.");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("'Estimad@ " + this.getBrujoElegido().getNombre() + ", nos complace");
        System.out.println("informarle que ha sido aceptado en Hogwarts School of Witchcraft and Wizardry.");
        System.out.println("Venga!'");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Mientras lee, otra carta se desliza del sobre.");
        System.out.println(" ");
        System.out.println("*Recibiste una carta de Hagrid*");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("'Querid@ " + this.getBrujoElegido().getNombre() + ", se suponía que debía guiarte a Hogwarts, pero tuve");
        System.out.println("una pequeña emergencia. Ya compré todos sus materiales y los");
        System.out.println("envié a Hogwarts. En cuanto a su mascota, al final de esa carta");
        System.out.println("puede elegirla. Tu poder inicial también se activará para ayudarte");
        System.out.println("a llegar al Hogwarts Express con seguridad.");
        System.out.println("_______________________________________________________________________");
        System.out.println("*Tu poder inicial, " + this.brujoElegido.getPoderInicial().getNombre() + " está activado*");
        System.out.println("Bonus: "); // TODO Completar
        System.out.println("Descripción:" + this.brujoElegido.getPoderInicial().getDescripcion());
        this.eligirUnaMascota();
        this.mostrarStatus();
        
    }

    // Esto carga las mascotas eligibles en bloque uno

    public void inicializarMascotas(){

        Mascota mascota = new Buho("Edwiges", 2, 10, 5);

        this.mascotas.add(mascota);

        mascota = new Gato("Crookshanks", 3, 5, 10);

        this.mascotas.add(mascota);

        mascota = new Rata("Scabbers", 35, 0, 5);

        this.mascotas.add(mascota);

        mascota = new Sapo("Trevor", 2, 7, 7);

        this.mascotas.add(mascota);
        
    }

    // Esto carga todos los Artefactos ---

    public void inicializarArtefactos(){
        //TODO
    }

    // Esto Elige un personaje en el primer bloque

    public void eligirUnPersonaje(){

        System.out.println(" ");
        System.out.println("En primer lugar, elige un personage (1, 2 o 3):");
        
        int contador = 0;

        for (Wizard brujo : brujos) {
            contador++;

            System.out.println((contador + " " + brujo.getNombre()));
            
        }
        int a;

        a = teclado.nextInt();
        
        this.setBrujoElegido(this.brujos.get(a - 1));

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Tu personaje eligido es " + this.getBrujoElegido().getNombre());
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");

    }

    // Esto Elige una mascota en el primer bloque

    public void eligirUnaMascota(){

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

    public void mostrarStatus(){

        System.out.println("Tu status actual es:");
        System.out.println("_______________________________________________________________________");
        System.out.println(" ");
        System.out.println("Nombre: " + this.brujoElegido.getNombre());
        System.out.println("Edad: " + this.brujoElegido.getEdad());
        System.out.println("Hechizos:");
        mostrarHechizosBrujo();
        System.out.println("Brujo Oscuro: " + transformarTrueEnSiYFalseEnNo(this.brujoElegido.getMagoOscuro()));
        System.out.println("Mascota: " + this.brujoElegido.getMascota().getNombre());

        System.out.println("_______________________________________________________________________");
        System.out.println(" ");

        //TODO poner Artefacto y ver que falta
    }

    // Esto convierte true para si y false para no

    public String transformarTrueEnSiYFalseEnNo(boolean valor){

        if(valor == true){
            return "SI";
        } else{
            return "NO";
        }

    }

    // Esto lista los hechizos del brujo

    public void mostrarHechizosBrujo(){

        int contador = 0;

        for (Hechizo hechizo : this.brujoElegido.getHechizos()) {
            contador++;

            System.out.println((contador + " " + hechizo.getNombre()));
            
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

    // GETTERS AND SETTERS

    public List<Wizard> getBrujos() {
        return brujos;
    }

    public void setBrujos(List<Wizard> brujos) {
        this.brujos = brujos;
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