package com.vdcom.vdcomtest.controllers;

import com.vdcom.vdcomtest.entity.Account;
import com.vdcom.vdcomtest.entity.utils.CSVHelper;
import com.vdcom.vdcomtest.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("/create-account");
    }

    @PostMapping("/create")
    public String createAccount(@ModelAttribute Account account) {
        accountService.create(account);
        return "redirect:/account/get-all";
    }

    @GetMapping("/get-all")
    public ModelAndView getAllAccounts(Model model) {
        List<Account> accountAll = accountService.getAll();
        model.addAttribute("accountAll", accountAll);
        return new ModelAndView("/get-all-accounts");
    }

    @GetMapping("/delete")
    public String deleteAccount(@RequestParam("id") int id) {
        accountService.deleteById(id);
        return "redirect:/account/get-all";
    }

    @GetMapping("/update")
    public ModelAndView showUpdate(@RequestParam("id") int id, Model model) {
        Optional<Account> isAccount = accountService.findById(id);
        Account account = isAccount.get();
        model.addAttribute("account", account);
        return new ModelAndView("/update-account");
    }

    @PostMapping("/update")
    public String updateAccount(@ModelAttribute Account account) {
        accountService.update(account);
        return "redirect:/account/get-all";
    }

    @PostMapping("/upload")
    public String uploadCsv(@RequestParam("file") MultipartFile file) {
        if (!CSVHelper.hasCSVFormat(file)) {
            return "redirect:/error";
        }
        try {
            List<Account> accounts = CSVHelper.csvToPersons(file.getInputStream());
            accounts.forEach(account ->
                    accountService.create(account));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "redirect:/account/get-all";
    }

}