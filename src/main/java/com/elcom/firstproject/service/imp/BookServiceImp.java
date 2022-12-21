package com.elcom.firstproject.service.imp;

import com.elcom.firstproject.convert.Mapper;
import com.elcom.firstproject.dto.BookDto;
import com.elcom.firstproject.exception.NoSuchElementException;
import com.elcom.firstproject.model.Author;
import com.elcom.firstproject.model.Book;
import com.elcom.firstproject.model.Category;
import com.elcom.firstproject.repository.AuthorRepository;
import com.elcom.firstproject.repository.BookRepository;
import com.elcom.firstproject.repository.CategoryRepository;
import com.elcom.firstproject.service.BookService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    Mapper mapper;

    @Override
    public List<BookDto> getListBook() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> result = new ArrayList<>();
        if (!books.isEmpty()) {
            for (Book book : books) {
                result.add(mapper.toBookDto(book));
            }
        }
        return result;
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).get();
        BookDto bookDto = new BookDto();
        if (book != null) {
            bookDto = mapper.toBookDto(book);
            return bookDto;
        }

        throw new NoSuchElementException("Sach khong ton tai");

    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = new Book();
        if (bookDto != null) {
            book = mapper.toBook(bookDto);
            Category category = categoryRepository.findById(bookDto.getCategoryId()).get();
            Author author = authorRepository.findById(bookDto.getAuthorId()).get();
            book.setAuthor(author);
            book.setCategory(category);
            book.setCreatedDate(new Date());
            bookRepository.save(book);
        }
        return mapper.toBookDto(book);
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Book oldBook = bookRepository.findById(id).get();
        Book newBook = new Book();
        if (oldBook != null) {
            newBook = mapper.toBook(oldBook, bookDto);
            newBook.setId(id);
            Category category = categoryRepository.findById(bookDto.getCategoryId()).get();
            Author author = authorRepository.findById(bookDto.getAuthorId()).get();
            newBook.setCategory(category);
            newBook.setAuthor(author);
            newBook.setModifiedDate(new Date());
            bookRepository.save(newBook);
            return mapper.toBookDto(newBook);
        }
        throw new NoSuchElementException("Sach khong ton tai");
    }

    @Override
    public BookDto deleteBook(Long id) {
        Book book = bookRepository.findById(id).get();
        if (book != null) {
            bookRepository.deleteById(id);
            return mapper.toBookDto(book);
        }

        throw new NoSuchElementException("Sach khong ton tai");
    }

    @Override
    public List<Object> getCountBookGroupByAuthor() {
        return bookRepository.getCountBookGroupByAuthor();
    }

    @Override
    public List<Object> getCountBookGroupByCategory() {
        return bookRepository.getCountBookGroupByCategory();
    }

    @Override
    public List<Object> getCountBookGroupByFirstText() {
        return bookRepository.getCountBookGroupByFirstText();
    }
}
