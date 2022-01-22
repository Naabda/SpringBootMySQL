package es.davidabellannavarro.springbootmysql.habilidad;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 22/01/2022
 * @github https://github.com/Naabda/
 */

import org.springframework.data.repository.CrudRepository;

public interface HabilidadRepository extends CrudRepository<Habilidad, Integer> {

    public Long countById(Integer id);
}
