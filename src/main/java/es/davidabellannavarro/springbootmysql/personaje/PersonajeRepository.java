package es.davidabellannavarro.springbootmysql.personaje;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 21/01/2022
 * @github https://github.com/Naabda/SpringBootMySQL
 */

import org.springframework.data.repository.CrudRepository;

/**
 * The interface Personaje repository.
 */
public interface PersonajeRepository extends CrudRepository<Personaje, Integer> {

    /**
     * Count by id long.
     *
     * @param id the id
     * @return the long
     */
    public Long countById(Integer id);

}
