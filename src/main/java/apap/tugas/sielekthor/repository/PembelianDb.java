package apap.tugas.sielekthor.repository;

import apap.tugas.sielekthor.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface PembelianDb extends JpaRepository<PembelianModel, Long>{
    Optional<PembelianModel> findByIdPembelian(Long idPembelian);
    Optional<PembelianModel> findByNomorInvoice(String nomorInvoice);
    List<Boolean> findByMemberModelAndIsCash(MemberModel memberModel, Boolean isCash);
    List<Boolean> findByMemberModel(MemberModel memberModel);
    List<Boolean> findByIsCash(Boolean isCash);

//    @Query(
//            value =
//                    "SELECT p, COUNT(p.idPilot) as x " +
//                            "FROM PilotModel p, PilotPenerbanganModel q " +
//                            "WHERE q.pilotModel.idPilot = p.idPilot " +
//                            "AND p.maskapaiModel = ?1 " +
//                            "GROUP BY p.idPilot"
//    )


//    @Query(
//            value =
//                    "SELECT distinct p.pilotModel " +
//                            "from PilotPenerbanganModel p " +
//                            "where p.penerbanganModel.waktuPenerbangan >= ?1"
//    )
//    List<PilotModel> findByThisMonth(Date date);
}