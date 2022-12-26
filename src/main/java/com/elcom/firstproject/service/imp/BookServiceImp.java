package com.elcom.firstproject.service.imp;

import com.elcom.firstproject.convert.Mapper;
import com.elcom.firstproject.dto.AuthorWithBookCount;
import com.elcom.firstproject.dto.BookDto;
import com.elcom.firstproject.dto.CategoryWithBookCount;
import com.elcom.firstproject.dto.FirstTextWithBookCount;
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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
    @PersistenceContext
    public EntityManager em;

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
        Book book = bookRepository.findById(id).orElse(null);
        BookDto bookDto = new BookDto();
        if (book != null) {
            bookDto = mapper.toBookDto(book);
            return bookDto;
        }
        // Ném ra NoSuchElementException
        throw new NoSuchElementException("Sach khong ton tai");

    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = new Book();
        if (bookDto != null) {
            book = mapper.toBook(bookDto);
            Category category = categoryRepository.findById(bookDto.getCategoryId()).orElse(null);
            Author author = authorRepository.findById(bookDto.getAuthorId()).orElse(null);
            if(category == null){
                throw new NoSuchElementException("The loai khong ton tai");
            }
            if(author == null){
                throw new NoSuchElementException("Tac gia khong ton tai");
            }
            book.setAuthor(author);
            book.setCategory(category);
            book.setCreatedDate(new Date());
            bookRepository.save(book);
        }
        return mapper.toBookDto(book);
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Book oldBook = bookRepository.findById(id).orElse(null);
        Book newBook = new Book();
        if (oldBook != null) {
            newBook = mapper.toBook(oldBook, bookDto);
            newBook.setId(id);
            Category category = categoryRepository.findById(bookDto.getCategoryId()).orElse(null);
            Author author = authorRepository.findById(bookDto.getAuthorId()).orElse(null);
            if(category == null){
                throw new NoSuchElementException("The loai khong ton tai");
            }
            if(author == null){
                throw new NoSuchElementException("Tac gia khong ton tai");
            }
            newBook.setCategory(category);
            newBook.setAuthor(author);
            newBook.setModifiedDate(new Date());
            bookRepository.save(newBook);
            return mapper.toBookDto(newBook);
        }
        // Ném ra NoSuchElementException
        throw new NoSuchElementException("Sach khong ton tai");
    }

    @Override
    public BookDto deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            bookRepository.deleteById(id);
            return mapper.toBookDto(book);
        }
        // Ném ra NoSuchElementException
        throw new NoSuchElementException("Sach khong ton tai");
    }

    @Override
    public List<AuthorWithBookCount> AuthorWithBookCount() {
        
        //Thực hiện native query đã được định nghĩa (Đếm số lượng sách theo tác giả)
        List<AuthorWithBookCount> AuthorWithBookCount = em
            .createNamedQuery("AuthorWithBookCount")
            .getResultList();
                
        return AuthorWithBookCount;
    }

    @Override
    public List<CategoryWithBookCount> CategoryWithBookCount() {
        
        //Thực hiện native query đã được định nghĩa (Đếm số lượng sách theo thể loại)
        List<CategoryWithBookCount> CategoryWithBookCount = em
                .createNamedQuery("CategoryWithBookCount")
                .getResultList();
        return CategoryWithBookCount;
    }

    @Override
    public List<FirstTextWithBookCount> FirstTextWithBookCount() {
        
        //Thực hiện native query đã được định nghĩa (Đếm số lượng sách theo chữ cái đầu)
         List<FirstTextWithBookCount> FirstTextWithBookCount = em
                .createNamedQuery("FirstTextWithBookCount")
                .getResultList();
        return FirstTextWithBookCount;
    }

}
