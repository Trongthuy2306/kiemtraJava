package kiemtra.nguyentrongthuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kiemtra.nguyentrongthuy.entity.NhanVien;
import kiemtra.nguyentrongthuy.entity.PhongBan;
import kiemtra.nguyentrongthuy.service.*;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<NhanVien> nhanViens = nhanVienService.getAllNhanViens();
        model.addAttribute("nhanviens", nhanViens);
        model.addAttribute("title", "DANH SÁCH NHÂN VIÊN");
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNVForm(Model model) {
        List<PhongBan> phongBans = phongBanService.getAllPhongBans();
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("phongbans", phongBans);
        model.addAttribute("title", "Add Nhân Viên");
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNV(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult Result, Model model) {
        if (Result.hasErrors()) {
            model.addAttribute("phongbans", phongBanService.getAllPhongBans());
            model.addAttribute("nhanvien", nhanVien);
            model.addAttribute("title", "Add nhân viên");
            return "nhanvien/add";
        }

        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String editNVForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("title", "Edit nhân viên");
        model.addAttribute("phongbans", phongBanService.getAllPhongBans());
        NhanVien nhanVien = nhanVienService.getNhanVienByManv(id);
        if (nhanVien != null) {
            model.addAttribute("nhanvien", nhanVien);
            return "nhanvien/edit";

        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit/{id}")
    public String editNV( @PathVariable("id") String id,@Valid @ModelAttribute("book") NhanVien nhanVien,BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("phongbans", phongBanService.getAllPhongBans());
            model.addAttribute("nhanvien", nhanVien);
            model.addAttribute("title", "Edit nhân viên");
            return "nhanvien/edit";
        }
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanvien";
    }
}
