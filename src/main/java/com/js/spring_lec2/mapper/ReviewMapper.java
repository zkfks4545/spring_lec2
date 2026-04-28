package com.js.spring_lec2.mapper;

import com.js.spring_lec2.vo.ProductVO;
import com.js.spring_lec2.vo.ReviewVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReviewMapper {
    // 여러개 => List<클래스>
    // 한개 => VO (bean, dto, ...)

    // c, u, d -> int (영향받는 개행 수)

    @Select("select * from review_test2")
    List<ReviewVO> selectAll();

    @Insert("insert into review_test2 values (review_test2_seq.nextval, #{r_title}, #{r_txt}, sysdate)")
    void insert(ReviewVO reviewVO);

    @Select("select * from review_test2 where r_no = #{r_no}")
    ReviewVO selectOne(int r_no);

    @Update("update review_test2 set r_title = #{r_title}, r_txt = #{r_txt} where r_no = #{r_no}")
    int update(ReviewVO reviewVO);

    @Delete("delete from review_test2 where r_no = #{r_no}")
    void delete(int no);
}
