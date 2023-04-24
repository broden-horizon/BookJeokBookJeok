package com.kh.bookJeokBookJeok.review.service;

import com.kh.bookJeokBookJeok.exception.BusinessLogicException;
import com.kh.bookJeokBookJeok.exception.ExceptionCode;
import com.kh.bookJeokBookJeok.review.entity.Review;
import com.kh.bookJeokBookJeok.review.repository.ReviewRepository;
import com.kh.bookJeokBookJeok.wish.entity.Wish;
import com.kh.bookJeokBookJeok.wish.service.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {
    private ReviewRepository reviewRepository;
    private WishlistService wishlistService;

    public Review create(Review review) {
        //존재하는 Wishlist에 포함될 리뷰인가?
        Wish wish = wishlistService.getWishlist(review.getWish().getWishlistId());
        //이미 이 Wishlist는 Review를 가지고 있지는 않은가?
        if(wish.getReview() != null) {
            throw new BusinessLogicException(ExceptionCode.WISHLIST_HAS_REVIEW_ALREADY);
        }
        review.setWish(wish);
        return reviewRepository.save(review);
    }

    public Review read(long wishlistId) {
        Wish wish = new Wish();
        wish.setWishlistId(wishlistId);
        Optional<Review> optionalReview = reviewRepository.findByWishlist(wish);
        return optionalReview.orElseThrow(() -> new BusinessLogicException(ExceptionCode.REVIEW_NOT_FOUND));
    }
}
