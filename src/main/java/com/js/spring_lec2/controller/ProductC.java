package com.js.spring_lec2.controller;

import com.js.spring_lec2.service.ProductService;
import com.js.spring_lec2.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductC {

//     url - 조금이라도 이쁘게 만들기
//     ex)crud
//     product/all
//     product/detail
//     product/create
//     product/update
//     product/delete

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public String getAll(Model model) {
        List<ProductVO> products = productService.getProducts();
        System.out.println(products);
        model.addAttribute("products", products);
        return "product/products";
    }

    @PostMapping("/create")
    public String createProduct(ProductVO product) {
        productService.createProduct(product);
        return "redirect:/product/all";
    }

    @GetMapping("/detail")
    public String getProduct(@RequestParam int pk, Model model) {
        ProductVO product = productService.getOneProduct(pk);
        model.addAttribute("product", product);
        return "product/detail";
    }

    @PostMapping("/update")
    public String updateProduct(ProductVO product) {
        productService.updateProduct(product);
        return "redirect:/product/all";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int pk) {
        productService.deleteProduct(pk);
        return "redirect:/product/all";
    }

}
