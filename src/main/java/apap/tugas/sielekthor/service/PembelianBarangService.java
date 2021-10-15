package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.PembelianBarangModel;

import apap.tugas.sielekthor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import apap.tugas.sielekthor.repository.MaskapaiDb;
import java.util.List

import java.util.List;

public interface PembelianBarangService {
    void addPembelianBarang(PembelianBarangModel pembelianBarangModel);
    PembelianBarangModel updatePembelianBarangModel(PembelianBarangModel pembelianBarangModel);
    PembelianBarangModel deletePembelianBarangModel(PembelianBarangModel pembelianBarangModel);
    PembelianBarangModel getPembelianBarangByStok(String nip);
    List<PembelianBarangModel> getAllPembelianBarang();
    PembelianBarangModel getByIdPembelianBarang(Long id);
}
