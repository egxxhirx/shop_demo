package com.example.shopdemo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.shopdemo.entity.Color;
import com.example.shopdemo.entity.Material;
import com.example.shopdemo.entity.Method;
import com.example.shopdemo.form.CartItemForm;
import com.example.shopdemo.security.CustomerDetails;
import com.example.shopdemo.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
public class HomeController {
  @Autowired
  ItemService itemService;

  @ModelAttribute
  public void addAttributes(@AuthenticationPrincipal CustomerDetails customer, Model model) {
    model.addAttribute("customerInfo", customer);
    if (customer != null) {
      model.addAttribute("url1", "/customer/index");
      model.addAttribute("message1", "注文履歴");
      model.addAttribute("url2", "/customer/cart");
      model.addAttribute("message2", "ショッピングカート");
    } else {
      model.addAttribute("url1", "/login");
      model.addAttribute("message1", "ログイン");
      model.addAttribute("url2", "/signup");
      model.addAttribute("message2", "新規会員登録");
    }
  }

  @GetMapping(value = "customer/index")
  public String itemList(Model model, CartItemForm form) {
    List<Material> materialList = itemService.searchMaterialAll();
    List<Method> methodList = itemService.searchMethodAll();
    List<Color> colorList = itemService.searchColorAll();

    model.addAttribute("materialList", materialList);
    model.addAttribute("methodList", methodList);
    model.addAttribute("colorList", colorList);

    return "index";
  }

  @RequestMapping(value = "/customer/cart/add", method = RequestMethod.POST)
  public String cartItemAdd(@Validated @ModelAttribute CartItemForm cartItemForm, BindingResult result, Model model) {
    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "index";
    }
    // ユーザー情報の登録
    itemService.saveCartItem(cartItemForm);
    return "redirect:/customer/index";
  }
}
