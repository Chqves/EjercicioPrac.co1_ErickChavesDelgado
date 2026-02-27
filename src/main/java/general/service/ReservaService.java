package general.service;

import general.domain.Reserva;
import general.repository.ReservaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    public Reserva getReserva(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public void save(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}