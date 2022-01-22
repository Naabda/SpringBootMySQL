package es.davidabellannavarro.springbootmysql.habilidad;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 22/01/2022
 * @github https://github.com/Naabda/SpringBootMySQL
 */

import org.springframework.data.repository.CrudRepository;

/**
 * The interface Habilidad repository.
 */
public interface HabilidadRepository extends CrudRepository<Habilidad, Integer> {

    /**
     * Count by id long.
     *
     * @param id the id
     * @return the long
     */
    public Long countById(Integer id);
}
