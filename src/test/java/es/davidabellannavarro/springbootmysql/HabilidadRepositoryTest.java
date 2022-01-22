package es.davidabellannavarro.springbootmysql;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 22/01/2022
 * @github https://github.com/Naabda/SpringBootMySQL
 */

import es.davidabellannavarro.springbootmysql.habilidad.Habilidad;
import es.davidabellannavarro.springbootmysql.habilidad.HabilidadRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.Optional;

/**
 * The type Habilidad repository test.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class HabilidadRepositoryTest {

    // Enlazamos con el repositorio.
    @Autowired private HabilidadRepository repo;

    /**
     * Test add new.
     */
    @Test
    public void testAddNew() {
        // Creamos un objeto.
        Habilidad habilidad = new Habilidad();
        // Añadimos los atributos al objeto.
        habilidad.setNombre("TestPrueba4");
        habilidad.setVida(150);
        habilidad.setEnergia(150);
        habilidad.setTipo("magia");

        // Llamamos al método guardar del repositorio. Y recogemos el objeto guardado.
        Habilidad habilidadGuardada = repo.save(habilidad);

        // Testeamos que no es nulo.
        Assertions.assertThat(habilidadGuardada).isNotNull();
        // Testeamos que su id es mayor que cero, para saber que tiene un id.
        Assertions.assertThat(habilidadGuardada.getId()).isGreaterThan(0);

    }

    /**
     * Test list all.
     */
    @Test
    public void testListAll() {
        // Llamamos al método que nos devuelve todos los objetos de la BD del repositorio.
        Iterable<Habilidad> habilidades = repo.findAll();
        // Testeamos que la lista tenga un tamaño mayor que cero.
        Assertions.assertThat(habilidades).hasSizeGreaterThan(0);
        // Iteramos la lista extraída de la BD.
        for(Habilidad p: habilidades)
            // Mostramos los objetos.
            System.out.println(p.toString());
    }

    /**
     * Test update.
     */
    @Test
    public void testUpdate() {
        // Asignamos un id.
        Integer habilidadId = 2;
        // Instanciamos un objeto opcional y llamamos al método del repositorio encontrar por id.
        Optional<Habilidad> optionalHabilidad = repo.findById(habilidadId);
        // Obtenemos el objeto.
        Habilidad habilidad = optionalHabilidad.get();
        // Le cambiamos un atributo.
        habilidad.setNombre("pruebaUpdate");
        // Método guardar del repositorio y le pasamos el objeto.
        repo.save(habilidad);
        // Buscamos y obtenemos por id el objeto actualizado de la base de datos.
        Habilidad updateHabilidad = repo.findById(habilidadId).get();
        // Testeamos que el atributo del objeto es igual al que le hemos actualizado.
        Assertions.assertThat(updateHabilidad.getNombre().equals("pruebaUpdate"));
    }

    /**
     * Test get.
     */
    @Test
    public void testGet() {
        // Asignamos un id.
        Integer habilidadId = 1;
        // Instanciamos un objeto opcional y llamamos al método del repositorio encontrar por id.
        Optional<Habilidad> optionalHabilidad = repo.findById(habilidadId);
        // Testeamos que exite el objeto.
        Assertions.assertThat(optionalHabilidad).isPresent();
        // Imprimimos el objeto que obtenemos.
        System.out.println(optionalHabilidad.get());
    }

    /**
     * Test delete.
     */
    @Test
    public void testDelete() {
        // Asignamos un id.
        Integer habilidadId = 11;
        // Llamamos al método borrar por id del repositorio y le pasamos el id.
        repo.deleteById(habilidadId);
        // Buscamos el objeto que se ha intentado borrar.
        Optional<Habilidad> optionalHabilidad = repo.findById(habilidadId);
        // Testeamos que el objeto no existe.
        Assertions.assertThat(optionalHabilidad).isNotPresent();
    }
}
