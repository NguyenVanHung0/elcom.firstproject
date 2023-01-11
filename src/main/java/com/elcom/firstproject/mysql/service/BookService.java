
package com.elcom.firstproject.mysql.service;

import com.elcom.firstproject.mysql.dto.AuthorWithBookCount;
import com.elcom.firstproject.mysql.dto.BookDto;
import com.elcom.firstproject.mysql.dto.CategoryWithBookCount;
import com.elcom.firstproject.mysql.dto.FirstTextWithBookCount;
import java.util.List;


public interface BookService {
    List<BookDto> getListBook();
    BookDto getBookById(Long id);
    BookDto createBook(BookDto bookDto);
    BookDto updateBook(Long id, BookDto bookDto);
    BookDto deleteBook(Long id);
    String deleteAllBook();
    List<AuthorWithBookCount> AuthorWithBookCount();
    List<CategoryWithBookCount> CategoryWithBookCount();
    List<FirstTextWithBookCount> FirstTextWithBookCount();
}
