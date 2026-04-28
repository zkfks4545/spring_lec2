package com.js.spring_lec2.controller;

// json 으로 결과물을 반환하는 공간.

import com.js.spring_lec2.service.ProductService;
import com.js.spring_lec2.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// url 을 예쁘게 만든다는것 => 동일 url  / 다른 method 요청방식
// GET, POST, PUT, DELETE
@RequestMapping("/api/product")
@RestController
public class ProductAPIC {
    // all: 전체조회

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductVO> getAllProduct() {
        return productService.getProducts();
    }

    @PostMapping
    public int createProduct(@RequestBody ProductVO product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

}
