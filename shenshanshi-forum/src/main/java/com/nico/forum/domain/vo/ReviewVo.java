package com.nico.forum.domain.vo;

import com.nico.forum.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVo extends Review {
    private List<Review> Child;
}
