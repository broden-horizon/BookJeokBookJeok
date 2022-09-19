package com.kh.bookJeokBookJeok.book.mapper;

import com.kh.bookJeokBookJeok.book.dto.BookDto;
import com.kh.bookJeokBookJeok.book.dto.BookResponseDto;
import com.kh.bookJeokBookJeok.book.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper{
    Book bookPostDtoToBook(BookDto.Post bookPostDto);
    BookResponseDto BookToBookResponseDto(Book book);
}