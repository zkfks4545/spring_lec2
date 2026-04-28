package com.js.spring_lec2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HC {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/api/product")
    public String productAsync() {
        return "product/product_async";
    }

}
