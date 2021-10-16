package apap.tugas.sielekthor.service;

import java.util.List;
import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.model.TipeModel;

public interface BarangService {
    BarangModel addBarang(BarangModel barangModel);
    BarangModel updateBarang(BarangModel barangModel);
    BarangModel deleteBarang(BarangModel barangModel);
    List<BarangModel> getBarangByStokAvailable(TipeModel tipe);
    List<BarangModel> getBarangByStokIsNotAvailable(TipeModel tipe);
    List<BarangModel> getAllBarang();
    BarangModel getBarangById(Long id);
    List<BarangModel> getStokHabis();

}
