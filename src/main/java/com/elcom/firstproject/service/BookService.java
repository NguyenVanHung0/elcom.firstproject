/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.elcom.firstproject.service;

import com.elcom.firstproject.dto.BookDto;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface BookService {
    List<BookDto> getListBook();
    BookDto getBookById(Long id);
    BookDto createBook(BookDto bookDto);
    BookDto updateBook(Long id, BookDto bookDto);
    BookDto deleteBook(Long id);
    List<Object> getCountBookGroupByAuthor();
    List<Object> getCountBookGroupByCategory();
    List<Object> getCountBookGroupByFirstText();
}
