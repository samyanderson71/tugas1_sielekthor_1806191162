package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.model.TipeModel;

import java.util.List;

public interface PembelianService {
    void addPembelian(PembelianModel pembelianModel);
    PembelianModel deletePembelian(PembelianModel pembelianModel);
    PembelianModel getPembelianByNomorInvoice(String nomorInvoice);
    List<PembelianModel> getAllPembelian();
    PembelianModel getByIdPembelian(Long id);
    String randomString();
    List<PembelianModel> getStokBarangHabis(TipeModel tipe);
    List<PembelianModel> getPembelianMemberModelAndTipeModel(MemberModel MemberModel, TipeModel tipeModel);
    List<PembelianModel> getPembelianMemberModel(MemberModel MemberModel);
    List<PembelianModel> getPembelianTipeModel(TipeModel tipeModel);
    List<PembelianModel> getTotalPembelianMember();
}
