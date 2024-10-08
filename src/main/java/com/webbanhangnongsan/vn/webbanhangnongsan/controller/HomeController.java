package com.webbanhangnongsan.vn.webbanhangnongsan.controller;

import com.webbanhangnongsan.vn.webbanhangnongsan.dto.ProductResponse;
import com.webbanhangnongsan.vn.webbanhangnongsan.entity.Product;
import com.webbanhangnongsan.vn.webbanhangnongsan.entity.User;
import com.webbanhangnongsan.vn.webbanhangnongsan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DecimalFormat;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/index")
    public String index(Model model, User user) {
        checkLogin(model, user);
        getData(model);
        return "web/index";
    }

    public void getData(Model model) {
        List<Product> getTop8Products = productRepository.getTop8Products();
        model.addAttribute("getTop8Products", getTop8Products);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        for (Product product : getTop8Products) {
            product.setFormattedPrice(decimalFormat.format(product.getPrice()));
        }
    }

    public void checkLogin(Model model, User user) {
        // Kiem tra xem nguoi dung da dang nhap hay chua
        if(user != null && user.getName() != null) {
            model.addAttribute("isLoggedIn", true);
            model.addAttribute("username", user.getName());
        }
        else {
            model.addAttribute("isLoggedIn", false);
        }
    }
}
