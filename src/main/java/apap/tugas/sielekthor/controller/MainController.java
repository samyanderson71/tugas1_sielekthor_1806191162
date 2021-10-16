package apap.tugas.sielekthor.controller;

import apap.tugas.sielekthor.model.*;
import apap.tugas.sielekthor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private PembelianService pembelianService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private TipeService tipeService;

    @Autowired
    private BarangService barangService;

    @GetMapping("/")
    public String getHomePage(Model model) {

        return "home";
    }

    @GetMapping("/cari")
    public String getCariPage(Model model) {
        return "filter-pembelian";
    }

    @RequestMapping(value="/cari/pembelian")
    public String filterPembelian(
            @RequestParam(value = "idMember", required=false) Long idMember,
            @RequestParam(value = "isCash", required=false) Boolean isCash,
            Model model
    ) {
        List<MemberModel> listMember = memberService.getAllMember();
        List<TipeModel> listTipe = tipeService.getAllTipe();

        List<Boolean> listPembelian = null;
        MemberModel memberModel =new MemberModel();
        TipeModel tipeModel =new TipeModel();

        try {
            memberModel = memberService.getMemberByIdMember(idMember);
            tipeModel = tipeService.getTipeById(tipeModel.getIdTipe());

            listPembelian = pembelianService.getPembelianMemberModelAndIsCash(memberModel, isCash);
        } catch (Exception e) {
            try {
                memberModel = memberService.getMemberByIdMember(idMember);
                listPembelian = pembelianService.getPembelianMemberModel(memberModel);
            } catch (Exception i) {
                try {
                    tipeModel = tipeService.getTipeById(tipeModel.getIdTipe());
                    listPembelian = pembelianService.getPembelianIsCash(isCash);
                } catch (Exception a) {

                }
            }
        }

        model.addAttribute("listPembelian", listPembelian);
        model.addAttribute("listMember", listMember);
        model.addAttribute("listTipe", listTipe);
        model.addAttribute("memberModel", memberModel);
        model.addAttribute("tipeModel", tipeModel);
        return "filter-pembelian";
    }

//    @RequestMapping(value = "/barang/cari")
//    public String cariBarangStokHabis(
//            @RequestParam (value = "kodeBarang", required=false) String kodeBarang,
//            Model model
//    ) {
//        List<BarangModel> listBarang = barangService;
//
//        List<PembelianModel> listPembelian = null;
//        BarangModel barangModel =new BarangModel();
//
//        try {
//            barangModel = barangService.getBarangById(barangModel.getIdBarang());
//            listPembelian = pembelianService.getStokBarangHabis(listBarang);
//        } catch (Exception e) {
//
//        }
//
//        model.addAttribute("listPembelian", listPembelian);
//        model.addAttribute("listMember", listMember);
//        model.addAttribute("memberModel", memberModel);
//
//        return "barang-stok-habis";
//    }
//
//    @GetMapping(value = "/barang/cari")
//    public String cariTigaPenerbanganAwal(
//            Model model
//    ) {
//        List<MemberModel> listMember = memberService.getAllMaskapai();
//
//        List<PembelianModel> listPembelian = null;
//        MemberModel memberModel =new MemberModel();
//
//        try {
//            memberModel = memberService.getAllMaskapai().get(0);
//            listPembelian = pilotService.get3Penerbangans(memberModel);
//        } catch (Exception e) {
//
//        }
//
//        model.addAttribute("listPembelian", listPembelian);
//        model.addAttribute("listMember", listMember);
//        model.addAttribute("memberModel", memberModel);
//
//        return "topTigaPenerbangan";
//    }
//
//    @GetMapping("/cari/pilot/bulan/ini")
//    public String cariPenerbanganBulanIni(Model model) {
//
//        List<PembelianModel> listPembelian = null;
//        try{
//            listPembelian = pilotService.getThisMonthPenerbangan();
//        } catch (Exception e) {
//
//        }
//
//        model.addAttribute("listPembelian", listPembelian);
//
//        return "bonus";
//    }
}