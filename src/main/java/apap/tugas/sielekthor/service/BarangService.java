package apap.tugas.sielekthor.service;

import java.util.List;
import apap.tugas.sielekthor.model.BarangModel;

public interface BarangService {
    void addBarang(BarangModel pilotModel);
    BarangModel updateBarang(BarangModel barangModel);
    BarangModel deleteBarang(BarangModel barangModel);
    BarangModel getBarangByStok(String nip);
    List<BarangModel> getAllBarang();
    BarangModel getByIdBarang(Long id);
}
