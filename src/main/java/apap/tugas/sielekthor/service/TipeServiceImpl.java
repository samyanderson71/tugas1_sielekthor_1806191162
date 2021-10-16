package apap.tugas.sielekthor.service;


import apap.tugas.sielekthor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import apap.tugas.sielekthor.repository.TipeDb;
import java.util.List;

@Service
@Transactional
public class TipeServiceImpl implements TipeService {
    @Autowired
    TipeDb tipeDb;

    @Override
    public TipeModel addTipe(TipeModel tipeModel) {
        return tipeDb.save(tipeModel);
    }
    @Override
    public TipeModel getTipeById(Long id){
        return tipeDb.findById(id).get();
    }

    @Override
    public List<TipeModel> getAllTipe() {
        return tipeDb.findAll(Sort.by(Sort.Direction.ASC, "namaTipe"));
    }


    @Override
    public TipeModel deleteTipe(TipeModel tipe) {
        tipeDb.delete(tipe);

        return tipe;
    }
}
