package apap.tugas.sielekthor.repository;

import apap.tugas.sielekthor.model.TipeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TipeDb extends JpaRepository<TipeModel, Long>{
    Optional<TipeModel> findByIdTipe(Long idTipe);
    Optional<TipeModel> findByNamaTipe(String namaTipe);

}