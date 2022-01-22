package es.davidabellannavarro.springbootmysql.personaje;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 22/01/2022
 * @github https://github.com/Naabda/
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PersonajeController {

    @Autowired
    private PersonajeService service;

    @GetMapping("/personajes")
    public String mostrarPersonajesList(Model model) {
        List<Personaje> personajeList = service.listAll();
        model.addAttribute("personajeList", personajeList);
        return "personajes";
    }

    @GetMapping("/personajes/nuevo")
    public String mostrarFormularioNuevoPersonaje(Model model) {
        model.addAttribute("personaje", new Personaje());
        model.addAttribute("cabecera", "NUEVO PERSONAJE");
        return "formulario_personaje";
    }

    @PostMapping("/personajes/guardar")
    public String guardarPersonaje(Personaje personaje, RedirectAttributes redirectAttributes) {
        service.save(personaje);
        redirectAttributes.addFlashAttribute("mensaje", "Personaje guardado con éxito.");
        return "redirect:/personajes";
    }

    @GetMapping("/personajes/editar/{id}")
    public String mostrarFormularioEditarPersonaje(@PathVariable("id") Integer id,  Model model, RedirectAttributes redirectAttributes) {
        try {
            Personaje personaje = service.getPersonaje(id);
            model.addAttribute("personaje", personaje);
            model.addAttribute("cabecera", "EDITAR PERSONAJE " + personaje.getNombre());
            return "formulario_personaje";
        } catch (PersonajeNotFoundException e) {
            redirectAttributes.addFlashAttribute("mensaje", e.getMessage());
            return "redirect:/personajes";
        }
    }

    @GetMapping("/personajes/borrar/{id}")
    public String borrarPersonaje(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            service.borrar(id);
            redirectAttributes.addFlashAttribute("mensaje", "El personaje se ha borrado correctamente.");
        } catch (PersonajeNotFoundException e) {
            redirectAttributes.addFlashAttribute("mensaje", e.getMessage());
        }
        return "redirect:/personajes";
    }
}
