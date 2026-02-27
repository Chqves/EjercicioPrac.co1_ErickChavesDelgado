package general.controllers;

import general.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/")
public String inicio(Model model) {

    var servicios = servicioService.getServicios();

    if (servicios == null || servicios.isEmpty()) {
        model.addAttribute("destacado", null);
    } else {

        // Buscar el servicio con mayor precio
        var masCaro = servicios.get(0);

        for (var s : servicios) {
            if (s.getPrecio().compareTo(masCaro.getPrecio()) > 0) {
                masCaro = s;
            }
        }

        model.addAttribute("destacado", masCaro);
    }

    return "index";
}
}