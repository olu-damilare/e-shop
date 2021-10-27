package com.ecommerce.shop.web.controller;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

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


    @GetMapping("/single/{id}")
    public ModelAndView getSingle(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("single");
        Product product = productServiceImpl.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }



}
