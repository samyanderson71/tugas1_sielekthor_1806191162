package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.*;

import java.util.List;

public interface PembelianService {
    void addPembelian(PembelianModel pembelianModel);
    PembelianModel deletePembelian(PembelianModel pembelianModel);
    PembelianModel getPembelianByNomorInvoice(String nomorInvoice);
    List<PembelianModel> getAllPembelian();
    PembelianModel getByIdPembelian(Long idPembelian);
    String checkNomorInvoice(PembelianModel pembelianModel);
    String randomString();
    List<Boolean> getPembelianMemberModelAndIsCash(MemberModel MemberModel, Boolean IsCash);
    List<Boolean> getPembelianMemberModel(MemberModel MemberModel);
    List<Boolean> getPembelianIsCash(Boolean isCash);
    List<PembelianModel> getTotalPembelianMember();
}
