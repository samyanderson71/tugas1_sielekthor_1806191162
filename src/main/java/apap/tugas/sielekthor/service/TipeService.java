package apap.tugas.sielekthor.service;


import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.model.TipeModel;

import java.util.List;

public interface TipeService {
    TipeModel addTipe(TipeModel tipeModel);
    TipeModel deleteTipe(TipeModel tipeModel);
    TipeModel getTipeById(Long id);
    List<TipeModel> getAllTipe();
}
