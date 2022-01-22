package es.davidabellannavarro.springbootmysql.personaje;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 20/01/2022
 * @github https://github.com/Naabda/SpringBootMySQL
 */
import es.davidabellannavarro.springbootmysql.habilidad.Habilidad;
import javax.persistence.*;

/**
 * The type Personaje.
 */
@Entity
@Table(name = "personajes")
public class Personaje {
    // Atributos.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String nombre;
    @Column(nullable = false, length = 20)
    private String clase;
    @Column(nullable = false)
    private int vida_max;
    @Column(nullable = false)
    private int energia_max;
    @Column(name = "vida_actual")
    private int vida_actual;
    @Column(name = "energia_actual")
    private int energia_actual;
    private int monedas;
    private boolean npc;
    private boolean hostil;
    private int numequipo = 0;
    private int numhab = 0;

    /**
     * Constructores.
     */
    // Constructor.
    public Personaje() {
        this.nombre = "";
        this.clase = "";
        this.vida_max = 0;
        this.energia_max = 0;
        this.vida_actual = 0;
        this.energia_actual = 0;
        this.monedas = 0;
        this.npc = false;
        this.hostil = false;
    }

    /**
     * Instantiates a new Personaje.
     *
     * @param nombre         the nombre
     * @param clase          the clase
     * @param vida_max       the vida max
     * @param energia_max    the energia max
     * @param vida_actual    the vida actual
     * @param energia_actual the energia actual
     * @param monedas        the monedas
     */
    // Constructor sobrecargado.
    public Personaje(String nombre, String clase, int vida_max, int energia_max, int vida_actual, int energia_actual, int monedas) {
        this.nombre = nombre;
        this.clase = clase;
        this.vida_max = vida_max;
        this.energia_max = energia_max;
        this.vida_actual = vida_actual;
        this.energia_actual = energia_actual;
        this.monedas = monedas;
    }

    /**
     * Instantiates a new Personaje.
     *
     * @param personaje the personaje
     */
    // Constructor copia.
    public Personaje(Personaje personaje) {
        this.nombre = personaje.nombre;
        this.clase = personaje.clase;
        this.vida_max = personaje.vida_max;
        this.energia_max = personaje.energia_max;
        this.vida_actual = personaje.vida_actual;
        this.energia_actual = personaje.energia_actual;
        this.monedas = personaje.monedas;
    }

    // Métodos para comparar

    /**
     * Métodos.  @param personaje the personaje
     *
     * @return the boolean
     */
    public boolean esIgual(Personaje personaje) {
        boolean salida = false;

        if(this.nombre.equals(personaje.nombre))
            salida = true;
        return salida;
    }

    @Override
    public boolean equals(Object per_entrada) {
        boolean salida = false;
        Personaje personaje = (Personaje) per_entrada;

        if(this.nombre.equals(personaje.nombre))
            salida = true;
        return salida;
    }

    // Métodos para mostrar

    /**
     * Visualizar.
     */
    public void visualizar() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Clase: "+clase);
        System.out.println("Vida_max: "+vida_max);
        System.out.println("Energia_max: "+energia_max);
        System.out.println("Vida_actual: "+vida_actual);
        System.out.println("Energia_actual: "+energia_actual);
        System.out.println("Monedas: "+monedas);

        System.out.print("NPC: ");
        if(npc == true)
            System.out.print("si");
        else
            System.out.print("no");

        System.out.println();
        System.out.print("Hostil: ");
        if(hostil == true)
            System.out.print("si");
        else
            System.out.print("no");
        System.out.println();
        System.out.println();
    }

    /**
     * Visualizar basico.
     */
    public void visualizarBasico() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Clase: "+clase);
        System.out.println("Vida_max: "+vida_max);
        System.out.println("Energia_max: "+energia_max);
        System.out.println("Vida_actual: "+vida_actual);
        System.out.println("Energia_actual: "+energia_actual);
        System.out.println("Monedas: "+monedas);
        System.out.println();
        System.out.print("NPC: ");
        if(npc == true)
            System.out.print("si");
        else
            System.out.print("no");
        System.out.println();
        System.out.print("Hostil: ");
        if(hostil == true)
            System.out.print("si");
        else
            System.out.print("no");
        System.out.println();
    }

    //Metodo tiene.

    /**
     * Tiene habilidad boolean.
     *
     * @param habilidad the habilidad
     * @return the boolean
     */
    public boolean tiene_habilidad(Habilidad habilidad) {
        boolean salida = false;
        // Falta implementar.
        return salida;
    }

    /**
     * Add habilidad boolean.
     *
     * @param habilidad the habilidad
     * @return the boolean
     */
    public boolean addHabilidad(Habilidad habilidad) {
        boolean salida = false;
        boolean encontrado = false;
        // Falta implementar.
        return salida;
    }

    /**
     * Eliminar habilidad boolean.
     *
     * @param habilidad the habilidad
     * @return the boolean
     */
    public boolean eliminarHabilidad(Habilidad habilidad) {
        boolean salida = false;
        boolean encontrado = false;
        int pos = 0;
        // Falta implementar.
        return salida;
    }

    /** Override. */
    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clase='" + clase + '\'' +
                ", vida_max=" + vida_max +
                ", energia_max=" + energia_max +
                ", vida_actual=" + vida_actual +
                ", energia_actual=" + energia_actual +
                ", monedas=" + monedas +
                ", npc=" + npc +
                ", hostil=" + hostil +
                ", numequipo=" + numequipo +
                ", numhab=" + numhab +
                '}' + System.lineSeparator();
    }

    /**
     * Getters & Setters  @return the id
     */
    public Integer getId() { return id; }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) { this.id = id; }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() { return nombre; }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Gets clase.
     *
     * @return the clase
     */
    public String getClase() { return clase; }

    /**
     * Sets clase.
     *
     * @param clase the clase
     */
    public void setClase(String clase) { this.clase = clase; }

    /**
     * Gets vida max.
     *
     * @return the vida max
     */
    public int getVida_max() { return vida_max; }

    /**
     * Sets vida max.
     *
     * @param vida_max the vida max
     */
    public void setVida_max(int vida_max) { this.vida_max = vida_max; }

    /**
     * Gets energia max.
     *
     * @return the energia max
     */
    public int getEnergia_max() { return energia_max; }

    /**
     * Sets energia max.
     *
     * @param energia_max the energia max
     */
    public void setEnergia_max(int energia_max) { this.energia_max = energia_max; }

    /**
     * Gets vida actual.
     *
     * @return the vida actual
     */
    public int getVida_actual() { return vida_actual; }

    /**
     * Sets vida actual.
     *
     * @param vida_actual the vida actual
     */
    public void setVida_actual(int vida_actual) { this.vida_actual = vida_actual; }

    /**
     * Gets energia actual.
     *
     * @return the energia actual
     */
    public int getEnergia_actual() { return energia_actual; }

    /**
     * Sets energia actual.
     *
     * @param energia_actual the energia actual
     */
    public void setEnergia_actual(int energia_actual) { this.energia_actual = energia_actual; }

    /**
     * Gets monedas.
     *
     * @return the monedas
     */
    public int getMonedas() { return monedas; }

    /**
     * Sets monedas.
     *
     * @param monedas the monedas
     */
    public void setMonedas(int monedas) { this.monedas = monedas; }

    /**
     * Is npc boolean.
     *
     * @return the boolean
     */
    public boolean isNpc() { return npc; }

    /**
     * Sets npc.
     *
     * @param npc the npc
     */
    public void setNpc(boolean npc) { this.npc = npc; }

    /**
     * Is hostil boolean.
     *
     * @return the boolean
     */
    public boolean isHostil() { return hostil; }

    /**
     * Sets hostil.
     *
     * @param hostil the hostil
     */
    public void setHostil(boolean hostil) { this.hostil = hostil; }
}