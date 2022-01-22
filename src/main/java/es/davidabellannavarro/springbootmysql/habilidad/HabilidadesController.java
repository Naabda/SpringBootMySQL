package es.davidabellannavarro.springbootmysql.habilidad;

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
 * The type Habilidades controller.
 */
@Controller
public class HabilidadesController {

    // Enlazamos con HabilidadService.
    @Autowired private HabilidadService service;

    /**
     * Mostrar listado habilidades string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/habilidades")
    public String mostrarListadoHabilidades(Model model) {
        // Recibe la lista de Habilidades a través del metodo listAll() de la clase servicio.
        List<Habilidad> habilidadList = service.listAll();
        // Añadimos al modelo el atributo cabecera con el valor Habilidades.
        model.addAttribute("cabecera", "Habilidades");
        // Añadimos al modelo la lista recibida de la base de datos.
        model.addAttribute("habilidadList", habilidadList);
        // Retornamos la vista.
        return "habilidades";
    }

    /**
     * Mostrar formulario nueva habilidad string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/habilidades/nueva")
    public String mostrarFormularioNuevaHabilidad(Model model) {
        // Añadimos al modelo un objeto.
        model.addAttribute("habilidad", new Habilidad());
        // Añadimos al modelo el atributo cabecera con el valor nueva habilidad.
        model.addAttribute("cabecera", "NUEVA HABILIDAD");
        // Retornamos la vista.
        return "formulario_habilidades";
    }

    /**
     * Guardar habilidad string.
     *
     * @param habilidad          the habilidad
     * @param redirectAttributes the redirect attributes
     * @return the string
     */
    @PostMapping("/habilidades/guardar")
    public String guardarHabilidad(Habilidad habilidad, RedirectAttributes redirectAttributes) {
        // Llamamos al método guardar del servicio y le pasamos el objeto recibido por parámetro para introducirlo en la BD.
        service.save(habilidad);
        // Envíamos un mensaje a la vista.
        redirectAttributes.addFlashAttribute("mensaje", "Habilidad guardada con éxito.");
        // Retornamos la vista con una redirección.
        return "redirect:/habilidades";
    }

    /**
     * Mostrar formulario editar habilidad string.
     *
     * @param id                 the id
     * @param model              the model
     * @param redirectAttributes the redirect attributes
     * @return the string
     */
    @GetMapping("/habilidades/editar/{id}")
    public String mostrarFormularioEditarHabilidad(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            // Buscamos y recogemos un objeto habilidad a través del id recibido por parámetro.
            Habilidad habilidad = service.getHabilidad(id);
            // Añadimos el objeto al modelo.
            model.addAttribute("habilidad", habilidad);
            // Añadimos una cabecera al modelo.
            model.addAttribute("cabecera", "EDITAR HABILIDAD " + habilidad.getNombre());
            // Retornamos la vista.
            return "formulario_habilidades";
        // Si sucede una excepción la recogemos a través de una que hemos creado.
        } catch (HabilidadNotFoundException e) {
            // Enviamos el error a la vista que nos redirigimos.
            redirectAttributes.addFlashAttribute("mensaje", e.getMessage());
            // Retornamos la vista con una redirección.
            return "redirect:/habilidades";
        }
    }

    /**
     * Borrar habilidad string.
     *
     * @param id                 the id
     * @param redirectAttributes the redirect attributes
     * @return the string
     */
    @GetMapping("/habilidades/borrar/{id}")
    public String borrarHabilidad(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            // Borramos un objeto habilidad a través del método borrar del servicio pasandole el id recibido por parámetro.
            service.borrar(id);
            // Enviamos un mensaje a la vista.
            redirectAttributes.addFlashAttribute("mensaje", "La habilidad se ha borrado correctamente.");
        } catch (HabilidadNotFoundException e) {
            // Enviamos un mensaje a la vista.
            redirectAttributes.addFlashAttribute("mensaje", e.getMessage());
        }
        // Retornamos la vista con una redirección.
        return "redirect:/habilidades";
    }
}
