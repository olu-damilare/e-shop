package com.ecommerce.shop.web.controller;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    ProductService productServiceImpl;


    @GetMapping(value={"/","/index"})
    public String getIndex(Model model){
        List<Product> products = productServiceImpl.findAll();
        model.addAttribute("products", products);
        log.info("Product list contains -----> {}", products);

        return "index";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }

    @GetMapping("/products")
    public String getProduct(){
        return "product";
    }


    @GetMapping("/services")
    public String getServices(){
        return "services";
    }


    @GetMapping("/single")
    public String getSingle(){
        return "single";
    }

}
