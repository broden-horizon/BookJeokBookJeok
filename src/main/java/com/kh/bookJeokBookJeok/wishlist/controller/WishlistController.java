package com.kh.bookJeokBookJeok.wishlist.controller;

import com.kh.bookJeokBookJeok.wishlist.dto.WishlistDto;
import com.kh.bookJeokBookJeok.wishlist.entity.Wishlist;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

/* 전체적으로 세션 정보를 받아서 처리해야함.
 *
 *
 */

@RestController
@RequestMapping("/wishlist")
@Validated
public class WishlistController {
    //위시리스트에 담기만 눌렀을 때
    @PostMapping
    public void checkWishlist(@Positive long bookId, @Positive long memberId) {

    }
    //옵션을 설정했을 때
    @PatchMapping
    public void optionWishlist(@Valid @RequestBody WishlistDto.Option option, @Positive long memberId) {

    }
    //위시리스트 조회
    @GetMapping("/{wishlistId}")
    public void getWishlist(@PathVariable long wishlistId) {

    }
    @GetMapping
    public void getWishlists(@Positive long memberId) {

    }

    //위시리스트 삭제할 때
    @DeleteMapping("/{wishlistId}")
    public void wishlistDelete(@PathVariable long wishlistId) {

    }


}