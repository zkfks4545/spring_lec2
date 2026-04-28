package com.js.spring_lec2.controller;

import com.js.spring_lec2.service.ProductService;
import com.js.spring_lec2.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@Controller
public class ProductC2 {

    //     url - 조금이라도 이쁘게 만들기
//     ex)crud
//     product/all
//     product/detail
//     product/create
//     product/update
//     product/delete


    // 더 예쁘게 만들어보자 rest API

    //  GET    /products        : 전체 조회
    //  GET    /products/{id}   : 단일 조회
    //  POST   /products        :새 제품 생성
    //  PUT    /products/{id} : 수정
    //  DELETE /products/{id} : 삭제

    @Autowired  // DI 객체 만들고 넣어주기
    private ProductService productService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("products", productService.getProducts());
        return "product/products2";
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id, Model model){
        model.addAttribute("product", productService.getOneProduct(id));
        return "product/detail";
    }

    @PostMapping
    public String addProduct(ProductVO product) {
        productService.createProduct(product);
        return "redirect:/products";
    }

    @DeleteMapping()
    public String deleteProduct(@RequestParam int pk) {
        System.out.println("delete request");
        productService.deleteProduct(pk);
        return "redirect:/products";
    }

    @PutMapping()
    public String updateProduct(ProductVO product) {
        System.out.println("put request");
        productService.updateProduct(product);
        return "redirect:/products";
    }

    @ResponseBody
    @GetMapping("/json/{id}")
    public ProductVO getProduct(@PathVariable int id){
        return productService.getOneProduct(id);
    }
}
