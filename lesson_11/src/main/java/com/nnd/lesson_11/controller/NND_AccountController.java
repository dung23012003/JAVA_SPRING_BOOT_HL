package com.nnd.lesson_11.controller;


import com.nnd.lesson_11.entity.NND_Account;
import com.nnd.lesson_11.service.NND_AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nnd-account")
public class NND_AccountController {

    @Autowired
    private NND_AccountService nndAccountService;

    // Hiển thị danh sách NND_Account
    @GetMapping("/list")
    public String listAccounts(Model model) {
        model.addAttribute("accounts", nndAccountService.getAllAccounts());
        return "nnd-account-list";
    }

    // Hiển thị form thêm mới NND_Account
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("account", new NND_Account());
        return "nnd-account-add";
    }

    // Xử lý thêm mới NND_Account
    @PostMapping("/add")
    public String addAccount(@ModelAttribute NND_Account account) {
        nndAccountService.addAccount(account);
        return "redirect:/nnd-account/list";
    }

    // Hiển thị form chỉnh sửa NND_Account
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        NND_Account account = nndAccountService.getAccountById(id);
        if (account != null) {
            model.addAttribute("account", account);
            return "nnd-account-edit";
        }
        return "redirect:/nnd-account/list";
    }

    // Xử lý cập nhật NND_Account
    @PostMapping("/edit/{id}")
    public String updateAccount(@PathVariable Long id, @ModelAttribute NND_Account account) {
        nndAccountService.updateAccount(id, account);
        return "redirect:/nnd-account/list";
    }

    // Xóa NND_Account
    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Long id) {
        nndAccountService.deleteAccount(id);
        return "redirect:/nnd-account/list";
    }
}