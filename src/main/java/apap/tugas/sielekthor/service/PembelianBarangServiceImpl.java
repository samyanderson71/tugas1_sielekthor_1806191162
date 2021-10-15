package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import apap.tugas.sielekthor.repository.PembelianBarangDb;
import java.util.List;
public class PembelianBarangServiceImpl {
    @Autowired
    PembelianBarangDb pembelianBarangDb;

    @Override
    public void addPembelianBarang(PembelianBarangModel pembelianBarangModel) {
        pembelianBarangDb.save(pembelianBarangModel);
    }

    @Override
    public PembelianBarangModel getPembelianBarangById(Long id){
        return pembelianBarangDb.findById(id).get();
    }

    @Override
    public PembelianBarangModel updatePembelianBarang(PembelianBarangModel pembelianBarang) {
        pembelianBarangDb.save(pembelianBarang);

        return pembelianBarang;
    }

    @Override
    public PembelianBarangModel deletePembelianBarang(PembelianBarangModel pembelianBarang) {
        pembelianBarangDb.delete(pembelianBarang);

        return pembelianBarang;
    }

}

