package es.davidabellannavarro.springbootmysql.personaje;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 22/01/2022
 * @github https://github.com/Naabda/SpringBootMySQL
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * The type Personaje service.
 */
@Service
public class PersonajeService {

    // Enlazamos con el repositorio de Habilidad.
    @Autowired private PersonajeRepository repository;

    /**
     * List all list. Retorna una lista con todos los objetos de la base de datos.
     *
     * @return the list
     */
    public List<Personaje> listAll() { return (List<Personaje>) repository.findAll(); }

    /**
     * Save. Guarda un objeto recibido por parámetro en la base de datos.
     *
     * @param personaje the personaje
     */
    public void save(Personaje personaje) { repository.save(personaje); }

    /**
     * Gets personaje. Retorna la habilidad cuyo id es igual que el recibido por parámetro.
     *
     * @param id the id
     * @return the personaje
     * @throws PersonajeNotFoundException the personaje not found exception
     */
    public Personaje getPersonaje(Integer id) throws PersonajeNotFoundException {
        // Es opcional porque puedo no encontrar un objeto con el mismo id.
        Optional<Personaje> personaje = repository.findById(id);
        // Si existe, se ha encontrado el objeto.
        if (personaje.isPresent())
            // Retorna dicho objeto.
            return personaje.get();

        // En caso de no encontrarse el objeto se lanza este mensaje.
        throw new PersonajeNotFoundException("Personaje no encontrado.");
    }

    /**
     * Borrar, el objeto con id idéntico al recibido por parámetro.
     *
     * @param id the id
     * @throws PersonajeNotFoundException the personaje not found exception
     */
    public void borrar(Integer id) throws PersonajeNotFoundException {
        // Buscamos cuantos objetos hay con el id recibido por parámetro.
        Long count = repository.countById(id);
        // Si es nulo o igual a cero.
        if (count == null || count == 0)
            // Lanzamos la excepción con este mensaje.
            throw new PersonajeNotFoundException("Personaje no encontrado.");

        // Pasamos el id al método borrar por id del repositorio.
        repository.deleteById(id);
    }
}
