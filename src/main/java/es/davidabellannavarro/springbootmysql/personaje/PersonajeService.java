package es.davidabellannavarro.springbootmysql.personaje;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 22/01/2022
 * @github https://github.com/Naabda/
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    @Autowired private PersonajeRepository repository;

    public List<Personaje> listAll() {
        return (List<Personaje>) repository.findAll();
    }

    public void save(Personaje personaje) {
        repository.save(personaje);
    }

    public Personaje getPersonaje(Integer id) throws PersonajeNotFoundException {
        Optional<Personaje> personaje = repository.findById(id);
        if (personaje.isPresent())
            return personaje.get();

        throw new PersonajeNotFoundException("Personaje no encontrado.");
    }

    public void borrar(Integer id) throws PersonajeNotFoundException {
        Long count = repository.countById(id);
        if (count == null || count == 0)
            throw new PersonajeNotFoundException("Personaje no encontrado.");

        repository.deleteById(id);
    }
}
