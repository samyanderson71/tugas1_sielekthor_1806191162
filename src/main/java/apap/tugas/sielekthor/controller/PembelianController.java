package apap.tugas.sielekthor.controller;


import apap.tugas.sielekthor.model.*;
import apap.tugas.sielekthor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class PembelianController {
    @Qualifier("pembelianServiceImpl")
    @Autowired
    private PembelianService pembelianService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private TipeService tipeService;

    @Autowired
    private BarangService barangService;

    @GetMapping("/pembelian/add")
    public String addPembelianFormPage(Model model) {
        List<MemberModel> listMember = memberService.getAllMember();
        List<TipeModel> listTipe = tipeService.getAllTipe();

        model.addAttribute("pembelian", new PembelianModel());
        model.addAttribute("listTipe", listTipe);
        model.addAttribute("listMember", listMember);
        return "form-add-pembelian";
    }

    @PostMapping("/pembelian/add")
    public String addPembelianSubmit(
            @ModelAttribute PembelianModel pembelian,
            Model model
    ) {
        pembelianService.addPembelian(pembelian);
        model.addAttribute("nomorInvoice_pembelian", pembelian.getNomorInvoice());

        return "add-pembelian";
    }

    @GetMapping("/pembelian")
    private String viewAllPembelian(Model model) {
        List<PembelianModel> listPembelian = pembelianService.getAllPembelian();
        model.addAttribute("listPembelian", listPembelian);
        return "pembelian";
    }

    @GetMapping("/pembelian/{nomorInvoice}")
    public String viewDetailPembelian(

            @PathVariable(value = "nomorInvoice") String nomorInvoice,
            Model model
    ) {
        try{
            PembelianModel pembelianByNomorInvoice = pembelianService.getPembelianByNomorInvoice(nomorInvoice);
            PembelianModel pembelian = pembelianService.getPembelianByNomorInvoice(nomorInvoice);
            model.addAttribute("pembelian", pembelian);
            model.addAttribute("listPembelianBarang", pembelianByNomorInvoice);
            return "view-pembelian";
        } catch(NoSuchElementException e) {
            String message = "Proses view tidak dapat dilakukan karena Nomor Invoice yang diberikan tidak valid";
            model.addAttribute("message", message);
            return "error";
        }
    }
}