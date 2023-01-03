
package com.elcom.firstproject.convert;

import com.elcom.firstproject.mysql.dto.AuthorDto;
import com.elcom.firstproject.mysql.dto.BookDto;
import com.elcom.firstproject.mysql.dto.CategoryDto;
import com.elcom.firstproject.mysql.dto.UserDto;
import com.elcom.firstproject.mysql.model.Author;
import com.elcom.firstproject.mysql.model.Book;
import com.elcom.firstproject.mysql.model.Category;
import com.elcom.firstproject.mysql.model.User;
import com.elcom.firstproject.postgresql.dto.BorrowLogDto;
import com.elcom.firstproject.postgresql.dto.EmployeeDto;
import com.elcom.firstproject.postgresql.model.BorrowLog;
import com.elcom.firstproject.postgresql.model.Employee;
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

    //Employee
    public Employee toEmployee(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setBirthDay(employeeDto.getBirthDay());
        employee.setAddress(employeeDto.getAddress());
        employee.setPhone(employeeDto.getPhone());
        return employee;
    }
    
     public Employee toEmployee(Employee employee, EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        employee.setName(employeeDto.getName());
        employee.setBirthDay(employeeDto.getBirthDay());
        employee.setAddress(employeeDto.getAddress());
        employee.setPhone(employeeDto.getPhone());
        return employee;
    }
     
     public EmployeeDto toEmployeeDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setBirthDay(employee.getBirthDay());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setPhone(employee.getPhone());
        employeeDto.setCreatedBy(employee.getCreatedBy());
        employeeDto.setCreatedDate(employee.getCreatedDate());
        employeeDto.setModifiedBy(employee.getModifiedBy());
        employeeDto.setModifiedDate(employee.getModifiedDate());
        return employeeDto;
    }
     
     // BorrorLog
     
     public BorrowLog toBorrowLog(BorrowLogDto borrowLogDto){
         if(borrowLogDto == null){
             return null;
         }
         BorrowLog borrowLog = new BorrowLog();
         borrowLog.setAuthorName(borrowLogDto.getAuthorName());
         borrowLog.setBookName(borrowLogDto.getBookName());
         borrowLog.setCategoryBook(borrowLogDto.getCategoryBook());
         borrowLog.setUserName(borrowLogDto.getUserName());
         borrowLog.setBorrowDate(borrowLogDto.getBorrowDate());
         return borrowLog;
     }
     
     public BorrowLog toBorrowLog(BorrowLog borrowLog, BorrowLogDto borrowLogDto){
         if(borrowLogDto == null){
             return null;
         }
         borrowLog.setAuthorName(borrowLogDto.getAuthorName());
         borrowLog.setBookName(borrowLogDto.getBookName());
         borrowLog.setCategoryBook(borrowLogDto.getCategoryBook());
         borrowLog.setUserName(borrowLogDto.getUserName());
         borrowLog.setBorrowDate(borrowLogDto.getBorrowDate());
         return borrowLog;
     }
     
     public BorrowLogDto toBorrowLogDto(BorrowLog borrowLog){
         if(borrowLog == null){
             return null;
         }
         BorrowLogDto borrowLogDto = new BorrowLogDto();
         borrowLogDto.setId(borrowLog.getId());
         borrowLogDto.setAuthorName(borrowLog.getAuthorName());
         borrowLogDto.setBookName(borrowLog.getBookName());
         borrowLogDto.setCategoryBook(borrowLog.getCategoryBook());
         borrowLogDto.setUserName(borrowLog.getUserName());
         borrowLogDto.setBorrowDate(borrowLog.getBorrowDate());
         return borrowLogDto;
     }
}
