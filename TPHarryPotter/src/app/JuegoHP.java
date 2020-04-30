package app;

import java.util.*;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.*;

public class JuegoHP {

    public static Scanner teclado = new Scanner(System.in);

    private List<Wizard> brujos = new ArrayList<>();
    private Wizard brujoElegido;

    public void inicializarBloque1() {
        this.inicializarBrujosBloque1();
        this.inicializarMascotas();
        this.inicializarApertura();
    }

    public void inicializarBrujosBloque1() {

        Poder poderInicial = new Expelliarmus("Expelliarmus", false, 10);

        poderInicial.setDescripcion(
                "También conocido como el encantamiento desarmador, es un encantamiento defensivo que fuerza a la víctima a soltar lo que sea que esté sujetando.");


        Wizard brujo = new Wizard("Harry Potter", 17, false, poderInicial);

        Hechizo hechizo = this.convertirPoderInicial(poderInicial);

        brujo.getHechizos().add(hechizo);
        this.getBrujos().add(brujo);

        poderInicial = new WingardumLeviosa("Wingwardum Leviosa", false, 10);
        poderInicial.setDescripcion("Es un encantamiento usado para hacer que los objetos vuelen o leviten.");

        brujo = new Wizard("Hermione Granger", 17, false, poderInicial);

        hechizo = this.convertirPoderInicial(poderInicial);
        brujo.getHechizos().add(hechizo);
        this.getBrujos().add(brujo);

        poderInicial = new VulneraSanetur("Vulnera Sanentur", false, 10);

        brujo = new Wizard("Ronald Weasley", 17, false, poderInicial);

        hechizo = this.convertirPoderInicial(poderInicial);
        brujo.getHechizos().add(hechizo);
        this.getBrujos().add(brujo);

    }

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
        System.out.println("  Curioso como sos, la abres inmediatamente.");
        System.out.println("'Estimad@ " + this.getBrujoElegido().getNombre() + ", nos complace");
        System.out.println("informarle que ha sido aceptado en Hogwarts School of Witchcraft and Wizardry.");
        System.out.println("Venga!'");
        System.out.println("  Mientras lee, otra carta se desliza del sobre.");
        System.out.println("*Recibiste una carta de Hagrid*");
        System.out.println("'Querido " + this.getBrujoElegido().getNombre() + ", se suponía que debía guiarte a Hogwarts, pero tuve");
        System.out.println("una pequeña emergencia. Ya compré todos sus materiales y los");
        System.out.println("envié a Hogwarts. En cuanto a su mascota, al final de esa carta");
        System.out.println("puede elegirla. Tu poder inicial también se activará para ayudarte");
        System.out.println("a llegar al Hogwarts Express con seguridad.");
        this.eligirUnaMascota();
        System.out.println("Tu poder inicial está activado");
        this.mostrarStatus();
        
        
        
    }

    public void inicializarMascotas(){

        //TODO
        
    }

    public void eligirUnPersonaje(){

        System.out.println(" ");
        System.out.println("En primer lugar, elige un personage (1, 2 o 3):");

        for(int i=0;i<this.brujos.size();i++){

            System.out.println((i + 1) + " " + this.brujos.get(i).getNombre());
        } 

        int a;

        a = teclado.nextInt();
        
        this.setBrujoElegido(this.brujos.get(a - 1));

    }

    public void eligirUnaMascota(){

        //TODO

    }

    public void mostrarStatus(){

        System.out.println("Tu status actual es:");

        //TODO
    }

    public Hechizo convertirPoderInicial(Poder poderInicial) {

        if (poderInicial instanceof Hechizo) {

            Hechizo hechizos = (Hechizo) poderInicial;

            return hechizos;
        }

        return null;

    }

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

}