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
public class MemberController {
    @Qualifier("memberServiceImpl")
    @Autowired
    private MemberService memberService;

    @Autowired
    private PembelianService pembelianService;

    @GetMapping("/member/tambah")
    public String addMemberFormPage(Model model) {
        model.addAttribute("member", new MemberModel());
        return "form-add-member";
    }

    @PostMapping("/member/tambah")
    public String addMemberSubmit(
            @ModelAttribute MemberModel member,
            Model model
    ) {
        memberService.addMember(member);
        model.addAttribute("idMember", member.getIdMember());

        return "add-member";
    }

    @GetMapping("/member")
    private String viewAllMember(Model model) {
        List<MemberModel> listMember = memberService.getAllMember();
        model.addAttribute("listMember", listMember);
        return "barang";
    }

    @GetMapping("/member/ubah/{idMember}")
    public String ubahMember(
            @PathVariable(value = "idBarang") Long idMember,
            Model model
    ) {
        try{
            MemberModel member = memberService.getMemberByIdMember(idMember);
            model.addAttribute("member", member);
            return "form-ubah-member";
        } catch(NoSuchElementException e) {
            String message = "Proses ubah member tidak dapat dilakukan karena id yang diberikan tidak valid";
            model.addAttribute("message", message);
            return "error";
        }
    }

    @PostMapping(value = "/member/ubah")
    public String ubahMemberSubmit(
            @ModelAttribute MemberModel member,
            Model model
    ) {
        MemberModel updatedMember = memberService.updateMember(member);
        model.addAttribute("idMember", updatedMember.getIdMember());
        return "ubah-member";
    }

}
