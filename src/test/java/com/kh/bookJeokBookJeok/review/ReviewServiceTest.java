package com.kh.bookJeokBookJeok.review;

import com.kh.bookJeokBookJeok.review.entity.Review;
import com.kh.bookJeokBookJeok.review.repository.ReviewRepository;
import com.kh.bookJeokBookJeok.review.service.ReviewService;
import com.kh.bookJeokBookJeok.wish.entity.Wish;
import com.kh.bookJeokBookJeok.wish.repository.WishlistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class ReviewServiceTest {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private WishlistRepository wishlistRepository;

    @BeforeEach()
    public void saveEntity() {
        Wish wish = wishlistRepository.save(new Wish());

        Review review = new Review();
        review.setWish(wish);
        review.setTitle("role");
        review.setWriting("writing");

        reviewRepository.save(review);
    }

    @Test
    public void readTest() {
        //given
        long wishlistId = 1L;
        //when
        Review actual = reviewService.read(wishlistId);
        //then
        assertThat(actual.getTitle(), is(equalTo("role")));

    }
}
