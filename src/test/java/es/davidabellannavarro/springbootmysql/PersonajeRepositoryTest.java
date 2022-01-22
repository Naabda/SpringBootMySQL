package es.davidabellannavarro.springbootmysql;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 21/01/2022
 * @github https://github.com/Naabda/SpringBootMySQL
 */

import es.davidabellannavarro.springbootmysql.personaje.Personaje;
import es.davidabellannavarro.springbootmysql.personaje.PersonajeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.Optional;

/**
 * The type Personaje repository test.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PersonajeRepositoryTest {

    // Enlazamos con el repositorio.
    @Autowired private PersonajeRepository repo;

    /**
     * Test add new. Método para testear la insercción de un nuevo objeto en la BD.
     */
    @Test
    public void testAddNew() {
        // Creamos un objeto.
        Personaje personaje = new Personaje();
        // Añadimos los atributos al objeto.
        personaje.setNombre("TestPrueba4");
        personaje.setClase("prueba");
        personaje.setVida_max(100);
        personaje.setEnergia_max(1000);
        personaje.setVida_actual(100);
        personaje.setEnergia_actual(1000);
        personaje.setMonedas(5000);
        personaje.setNpc(false);
        personaje.setHostil(false);

        // Llamamos al método guardar del repositorio. Y recogemos el objeto guardado.
        Personaje personajeGuardado = repo.save(personaje);

        // Testeamos que no es nulo.
        Assertions.assertThat(personajeGuardado).isNotNull();
        // Testeamos que su id es mayor que cero, para saber que tiene un id.
        Assertions.assertThat(personajeGuardado.getId()).isGreaterThan(0);
    }

    /**
     * Test list all.
     */
    @Test
    public void testListAll() {
        // Llamamos al método que nos devuelve todos los objetos de la BD del repositorio.
        Iterable<Personaje> personajes = repo.findAll();
        // Testeamos que la lista tenga un tamaño mayor que cero.
        Assertions.assertThat(personajes).hasSizeGreaterThan(0);
        // Iteramos la lista extraída de la BD.
        for(Personaje p: personajes)
            // Mostramos los objetos.
            p.visualizar();
    }

    /**
     * Test update.
     */
    @Test
    public void testUpdate() {
        // Asignamos un id.
        Integer persanajeId = 9;
        // Instanciamos un objeto opcional y llamamos al método del repositorio encontrar por id.
        Optional<Personaje> optionalPersonaje = repo.findById(persanajeId);
        // Obtenemos el objeto.
        Personaje personaje = optionalPersonaje.get();
        // Le cambiamos un atributo.
        personaje.setNombre("pruebaUpdate");
        // Método guardar del repositorio y le pasamos el objeto.
        repo.save(personaje);
        // Buscamos y obtenemos por id el objeto actualizado de la base de datos.
        Personaje updatePersonaje = repo.findById(persanajeId).get();
        // Testeamos que el atributo del objeto es igual al que le hemos actualizado.
        Assertions.assertThat(updatePersonaje.getNombre().equals("pruebaUpdate"));
    }

    /**
     * Test get.
     */
    @Test
    public void testGet() {
        // Asignamos un id.
        Integer personajeId = 11;
        // Instanciamos un objeto opcional y llamamos al método del repositorio encontrar por id.
        Optional<Personaje> optionalPersonaje = repo.findById(personajeId);
        // Testeamos que exite el objeto.
        Assertions.assertThat(optionalPersonaje).isPresent();
        // Imprimimos el objeto que obtenemos.
        System.out.println(optionalPersonaje.get());
    }

    /**
     * Test delete.
     */
    @Test
    public void testDelete() {
        // Asignamos un id.
        Integer personajeId = 11;
        // Llamamos al método borrar por id del repositorio y le pasamos el id.
        repo.deleteById(personajeId);
        // Buscamos el objeto que se ha intentado borrar.
        Optional<Personaje> optionalPersonaje = repo.findById(personajeId);
        // Testeamos que el objeto no existe.
        Assertions.assertThat(optionalPersonaje).isNotPresent();
    }
}
