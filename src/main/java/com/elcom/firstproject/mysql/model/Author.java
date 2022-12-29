/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcom.firstproject.mysql.model;

import com.elcom.firstproject.mysql.dto.AuthorWithBookCount;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


// Định nghĩa 1 native query trả kết quả về một dto class
@NamedNativeQuery(
    name = "AuthorWithBookCount",
    query = "select a.id, count(b.id) as total from book as b left join author as a on b.author_id = a.id group by a.id",
    resultSetMapping = "AuthorWithBookCountMapping"
)
@SqlResultSetMapping(
    name = "AuthorWithBookCountMapping",
    classes = {
        @ConstructorResult(
            columns = {
                @ColumnResult(name = "a.id", type = Long.class),
                @ColumnResult(name = "total", type = int.class)
            },
            targetClass = AuthorWithBookCount.class
        )
    }
)
public class Author extends Base{
    
    @Column
    private String name;
    
    @Column
    private String website;
    
    @Column
    private String note;
    
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
    
}
