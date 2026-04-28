package com.js.spring_lec2.service;

import com.js.spring_lec2.mapper.ProductMapper;
import com.js.spring_lec2.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<ProductVO> getProducts() {
        List<ProductVO> products = productMapper.selectAll();
        System.out.println(products);
        return products;
    }


    public int deleteProduct(int pk) {

        if (productMapper.deleteProduct(pk) == 1) {
            System.out.println("delete success");
        } else {
            System.out.println("delete fail");
        }

        return pk;
    }

    public int createProduct(ProductVO product) {
        int row = productMapper.inertProduct(product);
        if (row == 1) {
            System.out.println("create success");
        }
        return row;
    }


    public String updateProduct(ProductVO product) {
        int row = productMapper.updateProduct(product);
        if (row == 1) {
            System.out.println("update success");
            return "success";
        } else {
            System.out.println("update fail");
            return  "fail";
        }
    }

    public ProductVO getOneProduct(int pk) {
        return productMapper.selectOne(pk);
    }
}
