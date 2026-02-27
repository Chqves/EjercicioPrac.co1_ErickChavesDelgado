package general.service;

import general.domain.Categoria;
import general.repository.CategoriaRepository;
import general.repository.ServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public boolean delete(Long id) {
        if (servicioRepository.countByCategoria_Id(id) > 0) {
            return false;
        }
        categoriaRepository.deleteById(id);
        return true;
    }
}