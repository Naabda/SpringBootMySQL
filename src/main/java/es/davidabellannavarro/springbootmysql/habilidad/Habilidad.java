package es.davidabellannavarro.springbootmysql.habilidad;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 20/01/2022
 * @github https://github.com/Naabda/SpringBootMySQL
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

    /** Constructores. */

    //Constructor por defecto
    public Habilidad() {
        nombre = "";
        vida = 0;
        energia = 0;
        tipo = "";
    }

    // Constructor sobrecargado
    public Habilidad(String nombre, int vida, int energia, String tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.energia = energia;
        this.tipo = tipo;
    }

    // Constructor de copia
    public Habilidad(Habilidad habilidad) {
        this.nombre = habilidad.nombre;
        this.vida = habilidad.vida;
        this.energia = habilidad.energia;
        this.tipo = habilidad.tipo;
    }

    /** Métodos. */

    // Getters & Setters

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getVida() { return vida; }

    public void setVida(int vida) { this.vida = vida; }

    public int getEnergia() { return energia; }

    public void setEnergia(int energia) { this.energia = energia; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }
}