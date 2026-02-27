package general.controllers;

import general.domain.Reserva;
import general.service.ReservaService;
import general.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.getReservas());
        return "reserva/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("servicios", servicioService.getServicios());
        return "reserva/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("reserva", reservaService.getReserva(id));
        model.addAttribute("servicios", servicioService.getServicios());
        return "reserva/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        reservaService.delete(id);
        return "redirect:/reservas";
    }
}