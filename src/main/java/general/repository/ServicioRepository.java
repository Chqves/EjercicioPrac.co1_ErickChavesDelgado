package general.repository;

import general.domain.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
long countByCategoria_Id(Long categoriaId);
}