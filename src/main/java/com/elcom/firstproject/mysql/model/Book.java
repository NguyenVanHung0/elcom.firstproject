/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcom.firstproject.mysql.model;

import com.elcom.firstproject.mysql.dto.CategoryWithBookCount;
import com.elcom.firstproject.mysql.dto.FirstTextWithBookCount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 *
 * @author ADMIN
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")

// Định nghĩa 1 native query trả kết quả về một dto 
@NamedNativeQuery(
    name = "FirstTextWithBookCount",
    query = "select first_text, count(id) as total from book group by first_text",
    resultSetMapping = "FirstTextWithBookCountMapping"
)
@SqlResultSetMapping(
    name = "FirstTextWithBookCountMapping",
    classes = {
        @ConstructorResult(
            columns = {
                @ColumnResult(name = "first_text", type = String.class),
                @ColumnResult(name = "total", type = int.class)
            },
            targetClass = FirstTextWithBookCount.class
        )
    }
)
public class Book extends Base{
    @Column
    private String name;
    
    @Column(name = "nhaxb")
    private String nhaXB;
    
    @Column(name = "namxb")
    private String namXB;
    
    @Column(name = "first_text")
    private String firstText;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;
}
