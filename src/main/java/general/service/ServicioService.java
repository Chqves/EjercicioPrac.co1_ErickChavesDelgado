package general.service;

import general.domain.Servicio;
import general.repository.ServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> getServicios() {
        return servicioRepository.findAll();
    }

    public Servicio getServicio(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public void save(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    public void delete(Long id) {
        servicioRepository.deleteById(id);
    }
}