package com.js.spring_lec2.mapper;

import com.js.spring_lec2.controller.ProductC;
import com.js.spring_lec2.vo.ProductVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 여러개 => List<클래스>
    // 한개 => VO (bean, dto, ...)

    // c, u, d -> int (영향받는 개행 수)

    @Select("select * from product_test2")
    List<ProductVO> selectAll();

    @Delete("delete from product_test2 where p_no = #{pk}")
    int deleteProduct(int pk);

    @Insert("insert into product_test2 " +
            "values (product_test2_seq.nextval, #{p_name}, #{p_price})")
    int inertProduct(ProductVO product);


    @Update("update product_test2 " +
            "set p_name = #{p_name}, p_price = #{p_price} " +
            "where p_no = #{p_no}")
    int updateProduct(ProductVO product);

    @Select("select * from product_test2 where p_no = #{pk}")
    ProductVO selectOne(int pk);
}
