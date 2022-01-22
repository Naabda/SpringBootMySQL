package es.davidabellannavarro.springbootmysql.habilidad;

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
 * The type Habilidad service.
 */
@Service
public class HabilidadService {

    // Enlazamos con el repositorio de Habilidad.
    @Autowired private HabilidadRepository repository;

    /**
     * List all list. Retorna una lista con todos los objetos de la base de datos.
     *
     * @return the list
     */
    public List<Habilidad> listAll() { return (List<Habilidad>) repository.findAll(); }

    /**
     * Save. Guarda un objeto recibido por parámetro en la base de datos.
     *
     * @param habilidad the habilidad
     */
    public void save(Habilidad habilidad) { repository.save(habilidad); }

    /**
     * Gets habilidad. Retorna la habilidad cuyo id es igual que el recibido por parámetro.
     *
     * @param id the id
     * @return the habilidad
     * @throws HabilidadNotFoundException the habilidad not found exception
     */
    public Habilidad getHabilidad(Integer id) throws HabilidadNotFoundException {
        // Es opcional porque puedo no encontrar un objeto con el mismo id.
        Optional<Habilidad> habilidad = repository.findById(id);
        // Si existe, se ha encontrado el objeto.
        if (habilidad.isPresent())
            // Retorna dicho objeto.
            return habilidad.get();

        // En caso de no encontrarse el objeto se lanza este mensaje.
        throw new HabilidadNotFoundException("Habilidad no encontrada.");
    }

    /**
     * Borrar, el objeto con id idéntico al recibido por parámetro.
     *
     * @param id the id
     * @throws HabilidadNotFoundException the habilidad not found exception
     */
    public void borrar(Integer id) throws HabilidadNotFoundException {
        // Buscamos cuantos objetos hay con el id recibido por parámetro.
        Long count = repository.countById(id);
        // Si es nulo o igual a cero.
        if (count == null || count == 0)
            // Lanzamos la excepción con este mensaje.
            throw new HabilidadNotFoundException("Habilidad no encontrada.");
        // Pasamos el id al método borrar por id del repositorio.
        repository.deleteById(id);
    }
}
