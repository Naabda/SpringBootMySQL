package es.davidabellannavarro.springbootmysql.personaje;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 22/01/2022
 * @github https://github.com/Naabda/SpringBootMySQL
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

/**
 * The type Personaje controller.
 */
@Controller
public class PersonajeController {

    // Enlazamos con el servicio de Personaje.
    @Autowired private PersonajeService service;

    /**
     * Mostrar personajes list string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/personajes")
    public String mostrarPersonajesList(Model model) {
        // Recibe la lista de Personajes a través del metodo listAll() de la clase servicio.
        List<Personaje> personajeList = service.listAll();
        // Añadimos al modelo la lista recibida de la base de datos.
        model.addAttribute("personajeList", personajeList);
        // Añadimos al modelo el atributo cabecera con el valor Personajes.
        model.addAttribute("cabecera", "Personajes");
        // Retornamos la vista.
        return "personajes";
    }

    /**
     * Mostrar formulario nuevo personaje string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/personajes/nuevo")
    public String mostrarFormularioNuevoPersonaje(Model model) {
        // Añadimos al modelo un objeto.
        model.addAttribute("personaje", new Personaje());
        // Añadimos al modelo el atributo cabecera con el valor nuevo personaje.
        model.addAttribute("cabecera", "NUEVO PERSONAJE");
        // Retornamos la vista.
        return "formulario_personaje";
    }

    /**
     * Guardar personaje string.
     *
     * @param personaje          the personaje
     * @param redirectAttributes the redirect attributes
     * @return the string
     */
    @PostMapping("/personajes/guardar")
    public String guardarPersonaje(Personaje personaje, RedirectAttributes redirectAttributes) {
        // Llamamos al método guardar del servicio y le pasamos el objeto recibido por parámetro para introducirlo en la BD.
        service.save(personaje);
        // Envíamos un mensaje a la vista.
        redirectAttributes.addFlashAttribute("mensaje", "Personaje guardado con éxito.");
        // Retornamos la vista con una redirección.
        return "redirect:/personajes";
    }

    /**
     * Mostrar formulario editar personaje string.
     *
     * @param id                 the id
     * @param model              the model
     * @param redirectAttributes the redirect attributes
     * @return the string
     */
    @GetMapping("/personajes/editar/{id}")
    public String mostrarFormularioEditarPersonaje(@PathVariable("id") Integer id,  Model model, RedirectAttributes redirectAttributes) {
        try {
            // Buscamos y recogemos un objeto habilidad a través del id recibido por parámetro.
            Personaje personaje = service.getPersonaje(id);
            // Añadimos el objeto al modelo.
            model.addAttribute("personaje", personaje);
            // Añadimos una cabecera al modelo.
            model.addAttribute("cabecera", "EDITAR PERSONAJE " + personaje.getNombre());
            // Retornamos la vista.
            return "formulario_personaje";
        // Si sucede una excepción la recogemos a través de una que hemos creado
        } catch (PersonajeNotFoundException e) {
            // Enviamos el error a la vista que nos redirigimos.
            redirectAttributes.addFlashAttribute("mensaje", e.getMessage());
            // Retornamos la vista con una redirección.
            return "redirect:/personajes";
        }
    }

    /**
     * Borrar personaje string.
     *
     * @param id                 the id
     * @param redirectAttributes the redirect attributes
     * @return the string
     */
    @GetMapping("/personajes/borrar/{id}")
    public String borrarPersonaje(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            // Borramos un objeto habilidad a través del método borrar del servicio pasandole el id recibido por parámetro.
            service.borrar(id);
            // Enviamos un mensaje a la vista.
            redirectAttributes.addFlashAttribute("mensaje", "El personaje se ha borrado correctamente.");
        } catch (PersonajeNotFoundException e) {
            // Enviamos un mensaje a la vista.
            redirectAttributes.addFlashAttribute("mensaje", e.getMessage());
        }
        // Retornamos la vista con una redirección.
        return "redirect:/personajes";
    }
}
