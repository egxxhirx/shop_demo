package com.example.shopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
    //ログイン画面への遷移
    @GetMapping
    public String getLogin(Model model) {
        model.addAttribute("welcomeMessage", "共通のヘッダです ");
        model.addAttribute("url1", "/login");
        model.addAttribute("message1", "ログイン");
        model.addAttribute("url2", "/signup");
        model.addAttribute("message2", "新規会員登録");
        model.addAttribute("url3", "/resetPass");
        model.addAttribute("message3", "パスワードをわすれてしまった");
        return "login";
    }

    //ログイン成功時のメニュー画面への遷移
    @RequestMapping(value = "success")
    String postLogin() {
        System.out.println("Success!!!");
        return "redirect:/customer/index";
    }
}