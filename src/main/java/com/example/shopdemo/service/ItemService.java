package com.example.shopdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.shopdemo.entity.CartItem;
import com.example.shopdemo.entity.Color;
import com.example.shopdemo.entity.ExtendedCartItem;
import com.example.shopdemo.entity.Material;
import com.example.shopdemo.entity.Method;
import com.example.shopdemo.form.CartItemForm;
import com.example.shopdemo.repository.CartItemRepository;
import com.example.shopdemo.repository.ColorRepository;
import com.example.shopdemo.repository.ExtendedCartItemRepository;
import com.example.shopdemo.repository.MaterialRepository;
import com.example.shopdemo.repository.MethodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> searchMaterialAll() {
        return materialRepository.findAll();
    }

    @Autowired
    private ColorRepository colorRepository;

    public List<Color> searchColorAll() {
        return colorRepository.findAll();
    }

    @Autowired
    private MethodRepository methodRepository;

    public List<Method> searchMethodAll() {
        return methodRepository.findAll();
    }

    @Autowired
    private CartItemRepository cartItemRepository;

    public void saveCartItem(CartItemForm cartItemForm) {

        CartItem cartItem = new CartItem();
        cartItem.setCustomerId(cartItemForm.getCustomerId());
        cartItem.setMaterialId(cartItemForm.getMaterialId());
        cartItem.setColorId(cartItemForm.getColorId());
        cartItem.setMethodId(cartItemForm.getMethodId());
        cartItem.setQuantity(cartItemForm.getQuantity());
    
        cartItemRepository.save(cartItem);
    }

    public Integer updateCartItem(CartItem cartItem) {

        return cartItemRepository.updateCartItem(cartItem.getQuantity(), cartItem.getId());
    } 

    @Autowired
    private ExtendedCartItemRepository extendedCartItemRepository;

    public List<ExtendedCartItem> searchCartItemAll(int customerId) {

        return extendedCartItemRepository.findByCustomerId(customerId);
    }
}