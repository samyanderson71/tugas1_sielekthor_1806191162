package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.MemberModel;

import java.util.List;

public interface MemberService {
    void addMember(MemberModel memberModel);
    MemberModel updateMember(MemberModel memberModel);
    MemberModel deleteMember(MemberModel memberModel);
    List<MemberModel> getAllMember();
    MemberModel getByIdMember(Long id);
}
