
package com.elcom.firstproject.service;

import com.elcom.firstproject.dto.AuthorWithBookCount;
import com.elcom.firstproject.dto.BookDto;
import com.elcom.firstproject.dto.CategoryWithBookCount;
import com.elcom.firstproject.dto.FirstTextWithBookCount;
import java.util.List;


public interface BookService {
    List<BookDto> getListBook();
    BookDto getBookById(Long id);
    BookDto createBook(BookDto bookDto);
    BookDto updateBook(Long id, BookDto bookDto);
    BookDto deleteBook(Long id);
    List<AuthorWithBookCount> AuthorWithBookCount();
    List<CategoryWithBookCount> CategoryWithBookCount();
    List<FirstTextWithBookCount> FirstTextWithBookCount();
}
