package com.example.shopdemo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.shopdemo.entity.CartItem;
import com.example.shopdemo.entity.ExtendedCartItem;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class cartItemController {
    @Autowired
    ItemService itemService;

    @ModelAttribute
    public void addAttributes(@AuthenticationPrincipal CustomerDetails customer, Model model) {
        model.addAttribute("customerInfo", customer);
        model.addAttribute("url1", "/customer/index");
        model.addAttribute("message1", "注文履歴");
        model.addAttribute("url2", "/customer/cart");
        model.addAttribute("message2", "ショッピングカート");
    }

    @RequestMapping(value = "/customer/viewCartItems/{customerId}", method = RequestMethod.GET)
    public String viewCartItem(@PathVariable("customerId") int customerId, Model model, CartItemForm form) {

        List<ExtendedCartItem> cartItemList = itemService.searchCartItemAll(customerId);

        model.addAttribute("cartItems", cartItemList);
        model.addAttribute("column1", "作成サイズ");
        model.addAttribute("column2", "カラー");
        model.addAttribute("column3", "作成方法");
        model.addAttribute("column4", "数量");
        model.addAttribute("column5", "価格(税込)");
        return "cartitems";
    }

    @RequestMapping(value = "/customer/viewCartItems/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String cartItemAdd(@PathVariable("id") Integer id, @Validated @ModelAttribute CartItem cartItem,
            @AuthenticationPrincipal CustomerDetails customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "cartitems";
        }
        cartItem.setId(id);
        itemService.updateCartItem(cartItem);
        // int castomerId = customer.getId();
        // System.out.println(castomerId);
        // // redirectAttributes.addFlashAttribute("customerId", castomerId);
        return "cartitems";
    }
}