package com.js.spring_lec2.service;

import com.js.spring_lec2.mapper.ReviewMapper;
import com.js.spring_lec2.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public List<ReviewVO> getReviews() {
        List<ReviewVO> reviewVOS = reviewMapper.selectAll();
        System.out.println(reviewVOS);
        return reviewVOS;
    }

    public void createReview(ReviewVO reviewVO) {
        reviewMapper.insert(reviewVO);
        System.out.println(reviewVO);
        System.out.println("Review created successfully");
    }

    public ReviewVO detailReview(int no) {
        return reviewMapper.selectOne(no);
    }

    public int updateReview(ReviewVO reviewVO) {
         int row = reviewMapper.update(reviewVO);
        System.out.println(reviewVO);
        System.out.println("Review updated successfully");
        return row;
    }

    public void deleteReview(int no) {
        reviewMapper.delete(no);
        System.out.println("Review deleted successfully");
    }
}
