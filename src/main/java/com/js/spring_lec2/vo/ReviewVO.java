package com.js.spring_lec2.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewVO {
    private int r_no;
    private String r_title;
    private String r_txt;
    private Date r_date;
}
