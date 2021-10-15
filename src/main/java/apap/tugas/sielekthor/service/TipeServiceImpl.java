package apap.tugas.sielekthor.service;


import apap.tugas.sielekthor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import apap.tugas.sielekthor.repository.TipeDb;
import java.util.List;

public class TipeServiceImpl {
    @Autowired
    TipeDb tipeDb;

    @Override
    public void addTipe(TipeModel tipeModel) {
        tipeDb.save(tipeModel);
    }

    @Override
    public List<TipeModel> getAlTipe() { return tipeDb.findAll(Sort.by(Sort.Direction.ASC, "namaTipe")); }

    @Override
    public TipeModel getTipeById(Long id){
        return tipeDb.findById(id).get();
    }

    @Override
    public TipeModel deleteTipe(TipeModel tipe) {
        tipeDb.delete(tipe);

        return tipe;
    }
}
