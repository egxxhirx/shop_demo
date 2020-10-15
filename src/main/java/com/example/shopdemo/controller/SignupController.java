package com.example.shopdemo.controller;

import com.example.shopdemo.entity.Customer;
import com.example.shopdemo.form.CustomerForm;
import com.example.shopdemo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value="/signup")
    public String getSignup(Model model, CustomerForm customerForm) {
        model.addAttribute("welcomeMessage", "共通のヘッダです ");
        model.addAttribute("url1", "/login");
        model.addAttribute("message1", "ログイン");
        model.addAttribute("url2", "/signup");
        model.addAttribute("message2", "新規会員登録");
        return "signup";
    }

    @RequestMapping(value="customer", method = RequestMethod.POST)
    String create (@Validated CustomerForm form, BindingResult bindingResult) {
      if (bindingResult.hasErrors()) {
        return "signup";
      }
    
      Customer customer = new Customer();
      customer.setEmail(form.getEmail());
      customerService.create(customer, form.getPassword());
      return "redirect:/login";
    }
}