package hr.ja.cajger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "perica") String name,
                        Model model) {

        model.addAttribute("name", name + " evo ga još 2 4 89 sdsad");
        return "index";
    }

    @GetMapping("/sec")
    public String second() {
        return "second";
    }


}
