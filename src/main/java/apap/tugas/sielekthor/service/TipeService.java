package apap.tugas.sielekthor.service;


import apap.tugas.sielekthor.model.TipeModel;

import java.util.List;

public interface TipeService {
    void addTipe(TipeModel tipeModel);
    TipeModel updateTipe(TipeModel tipeModel);
    TipeModel deleteTipe(TipeModel tipeModel);
    List<TipeModel> getAllTipe();
    TipeModel getByTipeBarang(Long id);
}
