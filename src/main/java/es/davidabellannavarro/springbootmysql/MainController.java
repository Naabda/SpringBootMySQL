package es.davidabellannavarro.springbootmysql;

/**
 * @author David Abellán Navarro
 * @project SpringBootMySQL
 * @course 2ºD.A.M.
 * @date 20/01/2022
 * @github https://github.com/Naabda/SpringBootMySQL
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The type Main controller.
 */
@Controller
public class MainController {

    /**
     * Show home page string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("")
    public String showHomePage(Model model) {
        System.out.println("main controller");
        model.addAttribute("cabecera", "Bienvenido a mi API SpringBoot con MySQL");
        return "index";
    }

}
