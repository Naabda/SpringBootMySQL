package es.davidabellannavarro.springbootmysql;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 20/01/2022
 * @github https://github.com/Naabda/
 */

@Controller
public class MainController {

    @GetMapping("")
    public String showHomePage(Model model) {
        System.out.println("main controller");
        model.addAttribute("cabecera", "Bienvenido a mi APP SpringBoot con MySQL");
        return "index";
    }

}
