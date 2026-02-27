package general.service;

import general.domain.Categoria;
import general.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}