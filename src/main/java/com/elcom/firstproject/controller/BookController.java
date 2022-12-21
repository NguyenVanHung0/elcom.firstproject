package com.elcom.firstproject.controller;

import com.elcom.firstproject.dto.BookDto;
import com.elcom.firstproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public ResponseEntity<?> getListBook() {
        return ResponseEntity.ok(bookService.getListBook());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.createBook(bookDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.updateBook(id, bookDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    @GetMapping("count/author")
    public ResponseEntity<?> getCountBookByAuthor() {
        return ResponseEntity.ok(bookService.getCountBookGroupByAuthor());
    }

    @GetMapping("count/category")
    public ResponseEntity<?> getCountBookByCategory() {
        return ResponseEntity.ok(bookService.getCountBookGroupByCategory());
    }

    @GetMapping("count/firsttext")
    public ResponseEntity<?> getCountBookByFirstText() {
        return ResponseEntity.ok(bookService.getCountBookGroupByFirstText());
    }
}
