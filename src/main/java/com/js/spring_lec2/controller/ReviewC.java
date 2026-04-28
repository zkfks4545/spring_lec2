package com.js.spring_lec2.controller;

import com.js.spring_lec2.service.ReviewService;
import com.js.spring_lec2.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/review")
@Controller
public class ReviewC {

//     url - 조금이라도 이쁘게 만들기
//     ex)crud
//     product/all
//     product/detail
//     product/create
//     product/update
//     product/delete

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/all")
    public String getAll(Model model) {
        List<ReviewVO> reviews = reviewService.getReviews();
        System.out.println(reviews);
        model.addAttribute("reviews", reviews);
        return "review/reviews";
    }

    @GetMapping("/create")
    public String create() {
        return "review/review_add";
    }

    @PostMapping("/create")
    public String create(ReviewVO reviewVO) {
        reviewService.createReview(reviewVO);
        return "redirect:/review/all";
    }

    // 동기 상세페이지
    @GetMapping("/detail")
    public String detail(@RequestParam int no, Model model) {
        ReviewVO reviewVO = reviewService.detailReview(no);
        model.addAttribute("review", reviewVO);
        return  "review/review_detail";
    }
    // 비동기 상세페이지
    @GetMapping("/detail2")
    public String detail2(@RequestParam int no, Model model) {
        ReviewVO reviewVO = reviewService.detailReview(no);
        model.addAttribute("review", reviewVO);
        return  "review/review_detail2";
    }

    //동기 업데이트
    @GetMapping("/update")
    public String update(@RequestParam int no, Model model) {
        ReviewVO reviewVO = reviewService.detailReview(no);
        model.addAttribute("review", reviewVO);
        return "review/review_update";
    }

    @PostMapping("/update")
    public String update(ReviewVO reviewVO) {
        reviewService.updateReview(reviewVO);
        return "redirect:/review/all";
    }

    // 비동기 업데이트
    @PostMapping("/api/update")
    @ResponseBody
    public int apiUpdate(ReviewVO reviewVO) {
            return reviewService.updateReview(reviewVO);
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int no) {
        reviewService.deleteReview(no);
        return "redirect:/review/all";
    }


}
