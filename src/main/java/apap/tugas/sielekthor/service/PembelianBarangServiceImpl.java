package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import apap.tugas.sielekthor.repository.PembelianBarangDb;
import java.util.List;

@Service
@Transactional
public class PembelianBarangServiceImpl implements PembelianBarangService {
    @Autowired
    PembelianBarangDb pembelianBarangDb;

    @Override
    public PembelianBarangModel addPembelianBarang(PembelianBarangModel pembelianBarangModel) {
        return pembelianBarangDb.save(pembelianBarangModel);
    }

    @Override
    public PembelianBarangModel getPembelianBarangById(Long id){
        return pembelianBarangDb.findById(id).get();
    }


}

