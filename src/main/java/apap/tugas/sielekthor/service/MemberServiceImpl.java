package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.MemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import apap.tugas.sielekthor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import apap.tugas.sielekthor.repository.MemberDb;
import java.util.List;

import java.util.List;

public class MemberServiceImpl {
    @Autowired
    MemberDb memberDb;

    @Override
    public void addMember(MemberModel memberModel) {
        memberDb.save(memberModel);
    }

    @Override
    public List<MemberModel> getAllMember() { return memberDb.findAll(Sort.by(Sort.Direction.ASC, "namaMember")); }

    @Override
    public MemberModel getMemberById(Long id){
        return memberDb.findById(id).get();
    }

    @Override
    public MemberModel updateMember(MemberModel member) {
        memberDb.save(member);

        return member;
    }

    @Override
    public MemberModel deleteMember(MemberModel member) {
        memberDb.delete(member);

        return member;
    }
}
