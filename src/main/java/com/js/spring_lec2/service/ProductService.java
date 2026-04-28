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

        if (productMapper.deleteProduct(pk) == 1){
            System.out.println("delete success");
        }else {
            System.out.println("delete fail");
        }

        return pk;
    }

    public int createProduct(ProductVO product) {
        int row = productMapper.inertProduct(product);
         if (row == 1){
             System.out.println("create success");
         }
        return row;
    }


    public void updateProduct(ProductVO product) {
        if(productMapper.updateProduct(product) == 1){
            System.out.println("update success");
        }
    }

    public ProductVO getOneProduct(int pk) {
        return productMapper.selectOne(pk);
    }
}
