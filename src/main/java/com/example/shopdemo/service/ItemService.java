package com.example.shopdemo.service;

import java.util.Date;
import java.util.List;

import com.example.shopdemo.entity.CartItem;
import com.example.shopdemo.entity.Color;
import com.example.shopdemo.entity.Material;
import com.example.shopdemo.entity.Method;
import com.example.shopdemo.form.CartItemForm;
import com.example.shopdemo.repository.CartItemRepository;
import com.example.shopdemo.repository.ColorRepository;
import com.example.shopdemo.repository.MaterialRepository;
import com.example.shopdemo.repository.MethodRepository;

// import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
        Date now = new Date();

        CartItem cartItem = new CartItem();
        cartItem.setCustomerId(cartItemForm.getCustomerId());
        System.out.println(cartItemForm.getCustomerId());
        cartItem.setMaterialId(cartItemForm.getMaterialId());
        cartItem.setColorId(cartItemForm.getColorId());
        cartItem.setMethodId(cartItemForm.getMethodId());
        cartItem.setQuantity(cartItemForm.getQuantity());
        cartItem.setCreatedDate(now);
        cartItem.setUpdatedDate(now);
        cartItemRepository.save(cartItem);
    }
}