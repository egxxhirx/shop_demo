package com.example.shopdemo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.shopdemo.entity.Customer;
import com.example.shopdemo.form.CustomerForm;
import com.example.shopdemo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {

  @Autowired
  CustomerService customerService;

  @ModelAttribute
  public void addAttributes(Model model) {
    model.addAttribute("url1", "/login");
    model.addAttribute("message1", "ログイン");
    model.addAttribute("url2", "/signup");
    model.addAttribute("message2", "新規会員登録");
  }

  @GetMapping(value = "/signup")
  public String getSignup(CustomerForm customerForm) {

    return "signup";
  }

  @RequestMapping(value = "customer", method = RequestMethod.POST)
  String create(@Validated @ModelAttribute CustomerForm form, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      List<String> errorList = new ArrayList<String>();
      for(ObjectError error : bindingResult.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      
      model.addAttribute("validationMessage", errorList);
      return "signup";
    }
    

    Customer customer = new Customer();
    customer.setEmail(form.getEmail());
    customerService.add(customer, form.getPassword());
    return "redirect:/login";
  }
}