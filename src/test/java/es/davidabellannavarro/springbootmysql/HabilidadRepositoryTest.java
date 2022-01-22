package es.davidabellannavarro.springbootmysql;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 22/01/2022
 * @github https://github.com/Naabda/
 */

import es.davidabellannavarro.springbootmysql.habilidad.Habilidad;
import es.davidabellannavarro.springbootmysql.habilidad.HabilidadRepository;
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
public class HabilidadRepositoryTest {

    @Autowired
    private HabilidadRepository repo;

    @Test
    public void testAddNew() {
        Habilidad habilidad = new Habilidad();
        habilidad.setNombre("TestPrueba4");
        habilidad.setVida(150);
        habilidad.setEnergia(150);
        habilidad.setTipo("magia");

        Habilidad habilidadGuardada = repo.save(habilidad);

        Assertions.assertThat(habilidadGuardada).isNotNull();
        Assertions.assertThat(habilidadGuardada.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll() {
        Iterable<Habilidad> habilidades = repo.findAll();
        Assertions.assertThat(habilidades).hasSizeGreaterThan(0);

        for(Habilidad p: habilidades)
            System.out.println(p.toString());
    }

    @Test
    public void testUpdate() {
        Integer habilidadId = 2;
        Optional<Habilidad> optionalHabilidad = repo.findById(habilidadId);
        Habilidad habilidad = optionalHabilidad.get();
        habilidad.setNombre("pruebaUpdate");
        repo.save(habilidad);

        Habilidad updateHabilidad = repo.findById(habilidadId).get();
        Assertions.assertThat(updateHabilidad.getNombre().equals("pruebaUpdate"));
    }

    @Test
    public void testGet() {
        Integer habilidadId = 1;
        Optional<Habilidad> optionalHabilidad = repo.findById(habilidadId);
        Assertions.assertThat(optionalHabilidad).isPresent();
        System.out.println(optionalHabilidad.get());
    }

    @Test
    public void testDelete() {
        Integer habilidadId = 11;
        repo.deleteById(habilidadId);

        Optional<Habilidad> optionalHabilidad = repo.findById(habilidadId);
        Assertions.assertThat(optionalHabilidad).isNotPresent();
    }
}
