package general.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String contacto(Model model) {
        // para que el form cargue limpio
        model.addAttribute("enviado", false);
        return "contacto/form";
    }

    @PostMapping("/contacto/enviar")
    public String enviar(
            @RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam String mensaje,
            Model model
    ) {
        // NO guardamos en BD (según el curso), solo mostramos confirmación
        model.addAttribute("enviado", true);

        // opcional: mostrar un resumen en la misma vista
        model.addAttribute("nombre", nombre);
        model.addAttribute("correo", correo);

        return "contacto/form";
    }
}