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
public class BarangController {
    @Qualifier("barangServiceImpl")
    @Autowired
    private BarangService barangService;

    @Autowired
    private PembelianService pembelianService;

    @Autowired
    private TipeService tipeService;

    @GetMapping("/barang/add")
    public String addBarangFormPage(Model model) {
        model.addAttribute("barang", new BarangModel());
        model.addAttribute("listTipe",tipeService.getAllTipe());
        return "form-add-barang";
    }

    @PostMapping("/barang/add")
    public String addBarangSubmit(
            @ModelAttribute BarangModel barang,
            Model model
    ) {
        barangService.addBarang(barang);
        model.addAttribute("kodeBarang", barang.getKodeBarang());

        return "add-barang";
    }

    @GetMapping("/barang")
    private String viewAllBarang(Model model) {
        List<BarangModel> listBarang = barangService.getAllBarang();
        model.addAttribute("listBarang", listBarang);
        return "barang";
    }

    @GetMapping("/barang/detail/{idBarang}")
    public String viewDetailBarang(
            @PathVariable(value = "idBarang") Long idBarang,
            Model model
    ) {
        try{
            BarangModel barang = barangService.getBarangById(idBarang);

            model.addAttribute("barang", barang);

            return "view-barang";
        } catch(NoSuchElementException e) {
            String messageBarang = "Proses view tidak dapat dilakukan karena id yang diberikan tidak valid";
            model.addAttribute("messageBarang", messageBarang);
            return "error";
        }
    }

    @GetMapping("/barang/ubah/{idBarang}")
    public String ubahBarang(
            @PathVariable(value = "idBarang") Long idBarang,
            Model model
    ) {
        try{
            BarangModel barang = barangService.getBarangById(idBarang);
            model.addAttribute("barang", barang);
            return "form-ubah-barang";
        } catch(NoSuchElementException e) {
            String message = "Proses ubah barang tidak dapat dilakukan karena id yang diberikan tidak valid";
            model.addAttribute("message", message);
            return "error";
        }
    }

    @PostMapping(value = "/barang/ubah")
    public String ubahBarangSubmit(
            @ModelAttribute BarangModel barang,
            Model model
    ) {
        BarangModel updatedBarang = barangService.updateBarang(barang);
        model.addAttribute("idBarang", updatedBarang.getIdBarang());
        model.addAttribute("listTipe",tipeService.getAllTipe());
        return "ubah-barang";
    }

}
