package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.model.TipeModel;
import apap.tugas.sielekthor.repository.BarangDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.repository.BarangDb;


import java.util.List;

@Service
@Transactional
public class BarangServiceImpl implements BarangService{

    @Autowired
    BarangDb barangDb;

    @Override
    public BarangModel addBarang(BarangModel barangModel) {
        return barangDb.save(barangModel);
    }

    @Override
    public List<BarangModel> getAllBarang() { return barangDb.findAll(Sort.by(Sort.Direction.ASC, "kodeBarang")); }


    @Override
    public BarangModel getBarangById(Long id){
        return barangDb.findById(id).get();
    }

    @Override
    public BarangModel updateBarang(BarangModel barang) {
        barangDb.save(barang);

        return barang;
    }

    @Override
    public BarangModel deleteBarang(BarangModel barang) {
        barangDb.delete(barang);

        return barang;
    }

    @Override
    public List<BarangModel> getBarangByStokAvailable(TipeModel tipe) {
        return barangDb.findByTipeModelAndStokGreaterThan(tipe, 0L);
    }

    @Override
    public List<BarangModel> getBarangByStokIsNotAvailable(TipeModel tipe) {
        return barangDb.findByTipeModelAndStokEquals(tipe, 0L);
    }

    @Override
    public List<BarangModel> getStokHabis() {
        return barangDb.findByStok(0l);
    }

}
