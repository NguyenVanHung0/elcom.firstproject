/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcom.firstproject.convert;

import com.elcom.firstproject.dto.AuthorDto;
import com.elcom.firstproject.dto.BookDto;
import com.elcom.firstproject.dto.CategoryDto;
import com.elcom.firstproject.dto.UserDto;
import com.elcom.firstproject.model.Author;
import com.elcom.firstproject.model.Book;
import com.elcom.firstproject.model.Category;
import com.elcom.firstproject.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    //Author
    public Author toAuthor(AuthorDto authorDto) {
        if (authorDto == null) {
            return null;
        }
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setNote(authorDto.getNote());
        author.setWebsite(authorDto.getWebsite());
        return author;
    }

    public Author toAuthor(Author author, AuthorDto authorDto) {
        if (authorDto == null) {
            return null;
        }

        author.setName(authorDto.getName());
        author.setNote(authorDto.getNote());
        author.setWebsite(authorDto.getWebsite());
        return author;
    }

    public AuthorDto toAuthorDto(Author author) {
        if (author == null) {
            return null;
        }
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setCreatedBy(author.getCreatedBy());
        authorDto.setCreatedDate(author.getCreatedDate());
        authorDto.setModifiedBy(author.getModifiedBy());
        authorDto.setModifiedDate(author.getModifiedDate());
        authorDto.setName(author.getName());
        authorDto.setNote(author.getNote());
        authorDto.setWebsite(author.getWebsite());
        List<Long> books = new ArrayList<>();
        for (Book book : author.getBooks()) {
            books.add(book.getId());
        }
        authorDto.setBooks(books);
        return authorDto;
    }

    // Category
    public Category toCategory(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }

    public Category toCategory(Category category, CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        category.setName(categoryDto.getName());
        return category;
    }

    public CategoryDto toCategoryDto(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setCreatedBy(category.getCreatedBy());
        categoryDto.setCreatedDate(category.getCreatedDate());
        categoryDto.setModifiedBy(category.getModifiedBy());
        categoryDto.setModifiedDate(category.getModifiedDate());
        categoryDto.setName(category.getName());
        List<Long> books = new ArrayList<>();
        for (Book book : category.getBooks()) {
            books.add(book.getId());
        }
        categoryDto.setBooks(books);
        return categoryDto;
    }

    // Book
    public Book toBook(BookDto bookDto) {
        if (bookDto == null) {
            return null;
        }
        Book book = new Book();
        book.setNamXB(bookDto.getNamXB());
        book.setName(bookDto.getName());
        book.setNhaXB(bookDto.getNhaXB());
        book.setFirstText(bookDto.getFirstText());
        return book;
    }

    public Book toBook(Book book, BookDto bookDto) {
        if (bookDto == null) {
            return null;
        }
        book.setNamXB(bookDto.getNamXB());
        book.setName(bookDto.getName());
        book.setNhaXB(bookDto.getNhaXB());
        book.setFirstText(bookDto.getFirstText());
        return book;
    }

    public BookDto toBookDto(Book book) {
        if (book == null) {
            return null;
        }
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setCreatedBy(book.getCreatedBy());
        bookDto.setCreatedDate(book.getCreatedDate());
        bookDto.setModifiedBy(book.getModifiedBy());
        bookDto.setModifiedDate(book.getModifiedDate());
        bookDto.setNamXB(book.getNamXB());
        bookDto.setName(book.getName());
        bookDto.setNhaXB(book.getNhaXB());
        bookDto.setFirstText(book.getFirstText());
        bookDto.setAuthorId(book.getAuthor().getId());
        bookDto.setCategoryId(book.getCategory().getId());
        return bookDto;
    }

    // User
    public User toUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        return user;
    }

    public User toUser(User user, UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        user.setUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        return user;
    }

    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());
        userDto.setCreatedBy(user.getCreatedBy());
        userDto.setCreatedDate(user.getCreatedDate());
        userDto.setModifiedBy(user.getModifiedBy());
        userDto.setModifiedDate(user.getModifiedDate());
        return userDto;
    }

}
