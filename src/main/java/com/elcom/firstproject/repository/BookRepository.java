/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.elcom.firstproject.repository;

import com.elcom.firstproject.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long>{
    //Dem book theo author
    @Query(value = "select count(id) as count, author_id from book group by author_id", nativeQuery = true)
    public List<Object> getCountBookGroupByAuthor();
    
    //Dem book theo category
    @Query(value = "select count(id) as count, category_id from book group by category_id", nativeQuery = true)
    public List<Object> getCountBookGroupByCategory();
    
    //Dem book theo category
    @Query(value = "select count(id) as count, first_text from book group by first_text", nativeQuery = true)
    public List<Object> getCountBookGroupByFirstText();
}
