package es.davidabellannavarro.springbootmysql.habilidad;

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
public class HabilidadesController {

    @Autowired
    private HabilidadService service;

    @GetMapping("/habilidades")
    public String mostrarListadoHabilidades(Model model) {
        List<Habilidad> habilidadList = service.listAll();
        model.addAttribute("cabecera", "Habilidades");
        model.addAttribute("habilidadList", habilidadList);
        return "habilidades";
    }

    @GetMapping("/habilidades/nueva")
    public String mostrarFormularioNuevaHabilidad(Model model) {
        model.addAttribute("habilidad", new Habilidad());
        model.addAttribute("cabecera", "NUEVA HABILIDAD");
        return "formulario_habilidades";
    }

    @PostMapping("/habilidades/guardar")
    public String guardarHabilidad(Habilidad habilidad, RedirectAttributes redirectAttributes) {
        service.save(habilidad);
        redirectAttributes.addFlashAttribute("mensaje", "Habilidad guardada con éxito.");
        return "redirect:/habilidades";
    }

    @GetMapping("/habilidades/editar/{id}")
    public String mostrarFormularioEditarHabilidad(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Habilidad habilidad = service.getHabilidad(id);
            model.addAttribute("habilidad", habilidad);
            model.addAttribute("cabecera", "EDITAR HABILIDAD " + habilidad.getNombre());
            return "formulario_habilidades";
        } catch (HabilidadNotFoundException e) {
            redirectAttributes.addFlashAttribute("mensaje", e.getMessage());
            return "redirect:/habilidades";
        }
    }

    @GetMapping("/habilidades/borrar/{id}")
    public String borrarHabilidad(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            service.borrar(id);
            redirectAttributes.addFlashAttribute("mensaje", "La habilidad se ha borrado correctamente.");
        } catch (HabilidadNotFoundException e) {
            redirectAttributes.addFlashAttribute("mensaje", e.getMessage());
        }
        return "redirect:/habilidades";
    }
}
