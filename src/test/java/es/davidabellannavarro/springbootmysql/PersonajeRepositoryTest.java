package es.davidabellannavarro.springbootmysql;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 21/01/2022
 * @github https://github.com/Naabda/
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

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PersonajeRepositoryTest {

    @Autowired
    private PersonajeRepository repo;

    @Test
    public void testAddNew() {
        Personaje personaje = new Personaje();
        personaje.setNombre("TestPrueba4");
        personaje.setClase("prueba");
        personaje.setVida_max(100);
        personaje.setEnergia_max(1000);
        personaje.setVida_actual(100);
        personaje.setEnergia_actual(1000);
        personaje.setMonedas(5000);
        personaje.setNpc(false);
        personaje.setHostil(false);

        Personaje personajeGuardado = repo.save(personaje);

        Assertions.assertThat(personajeGuardado).isNotNull();
        Assertions.assertThat(personajeGuardado.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll() {
        Iterable<Personaje> personajes = repo.findAll();
        Assertions.assertThat(personajes).hasSizeGreaterThan(0);

        for(Personaje p: personajes)
            p.visualizar();
    }

    @Test
    public void testUpdate() {
        Integer persanajeId = 9;
        Optional<Personaje> optionalPersonaje = repo.findById(persanajeId);
        Personaje personaje = optionalPersonaje.get();
        personaje.setNombre("pruebaUpdate");
        repo.save(personaje);

        Personaje updatePersonaje = repo.findById(persanajeId).get();
        Assertions.assertThat(updatePersonaje.getNombre().equals("pruebaUpdate"));
    }

    @Test
    public void testGet() {
        Integer personajeId = 11;
        Optional<Personaje> optionalPersonaje = repo.findById(personajeId);
        Assertions.assertThat(optionalPersonaje).isPresent();
        System.out.println(optionalPersonaje.get());
    }

    @Test
    public void testDelete() {
        Integer personajeId = 11;
        repo.deleteById(personajeId);

        Optional<Personaje> optionalPersonaje = repo.findById(personajeId);
        Assertions.assertThat(optionalPersonaje).isNotPresent();
    }
}
