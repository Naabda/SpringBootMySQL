package es.davidabellannavarro.springbootmysql.habilidad;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 20/01/2022
 * @github https://github.com/Naabda/SpringBootMySQL
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Habilidad.
 */
@Entity
public class Habilidad {

    // Atributos
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private int vida;
    private int energia;
    private String tipo;

    /**
     * Constructores.
     */
    //Constructor por defecto
    public Habilidad() {
        nombre = "";
        vida = 0;
        energia = 0;
        tipo = "";
    }

    /**
     * Instantiates a new Habilidad.
     *
     * @param nombre  the nombre
     * @param vida    the vida
     * @param energia the energia
     * @param tipo    the tipo
     */
    // Constructor sobrecargado
    public Habilidad(String nombre, int vida, int energia, String tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.energia = energia;
        this.tipo = tipo;
    }

    /**
     * Instantiates a new Habilidad.
     *
     * @param habilidad the habilidad
     */
    // Constructor de copia
    public Habilidad(Habilidad habilidad) {
        this.nombre = habilidad.nombre;
        this.vida = habilidad.vida;
        this.energia = habilidad.energia;
        this.tipo = habilidad.tipo;
    }

    // Getters & Setters

    /**
     * Métodos.  @return the id
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
     * Gets vida.
     *
     * @return the vida
     */
    public int getVida() { return vida; }

    /**
     * Sets vida.
     *
     * @param vida the vida
     */
    public void setVida(int vida) { this.vida = vida; }

    /**
     * Gets energia.
     *
     * @return the energia
     */
    public int getEnergia() { return energia; }

    /**
     * Sets energia.
     *
     * @param energia the energia
     */
    public void setEnergia(int energia) { this.energia = energia; }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public String getTipo() { return tipo; }

    /**
     * Sets tipo.
     *
     * @param tipo the tipo
     */
    public void setTipo(String tipo) { this.tipo = tipo; }
}