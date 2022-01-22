package es.davidabellannavarro.springbootmysql.habilidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 22/01/2022
 * @github https://github.com/Naabda/
 */

@Service
public class HabilidadService {
    @Autowired
    private HabilidadRepository repository;

    public List<Habilidad> listAll() {
        return (List<Habilidad>) repository.findAll();
    }

    public void save(Habilidad habilidad) {
        repository.save(habilidad);
    }

    public Habilidad getHabilidad(Integer id) throws HabilidadNotFoundException {
        Optional<Habilidad> habilidad = repository.findById(id);
        if (habilidad.isPresent())
            return habilidad.get();

        throw new HabilidadNotFoundException("Habilidad no encontrada.");
    }

    public void borrar(Integer id) throws HabilidadNotFoundException {
        Long count = repository.countById(id);
        if (count == null || count == 0)
            throw new HabilidadNotFoundException("Habilidad no encontrada.");

        repository.deleteById(id);
    }
}
