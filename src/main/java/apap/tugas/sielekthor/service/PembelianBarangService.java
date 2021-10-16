package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.PembelianBarangModel;

import apap.tugas.sielekthor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import apap.tugas.sielekthor.repository.PembelianBarangDb;
import java.util.List;

import java.util.List;

public interface PembelianBarangService {
    PembelianBarangModel addPembelianBarang(PembelianBarangModel pembelianBarangModel);
    PembelianBarangModel getPembelianBarangById(Long id);
}
