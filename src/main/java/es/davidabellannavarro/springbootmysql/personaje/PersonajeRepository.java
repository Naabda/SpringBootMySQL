package es.davidabellannavarro.springbootmysql.personaje;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 21/01/2022
 * @github https://github.com/Naabda/
 */

import org.springframework.data.repository.CrudRepository;

public interface PersonajeRepository extends CrudRepository<Personaje, Integer> {

    public Long countById(Integer id);

}
