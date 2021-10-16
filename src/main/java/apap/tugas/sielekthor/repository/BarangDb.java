package apap.tugas.sielekthor.repository;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.model.TipeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BarangDb extends JpaRepository<BarangModel, Long>{
    Optional<BarangModel> findByIdBarang(Long idBarang);
    List<BarangModel> findByTipeModelAndStokEquals(TipeModel tipe, Long stok);
    List<BarangModel> findByTipeModelAndStokGreaterThan(TipeModel tipe, Long stok);
    List<BarangModel> findByStok(Long stok);
}