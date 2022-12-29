/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcom.firstproject.mysql.model;

import com.elcom.firstproject.mysql.dto.CategoryWithBookCount;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")

// Định nghĩa 1 native query trả kết quả về một dto class 
@NamedNativeQuery(
    name = "CategoryWithBookCount",
    query = "select c.id, count(b.id) as total from book as b left join category as c on b.category_id = c.id group by c.id",
    resultSetMapping = "CategoryWithBookCountMapping"
)
@SqlResultSetMapping(
    name = "CategoryWithBookCountMapping",
    classes = {
        @ConstructorResult(
            columns = {
                @ColumnResult(name = "c.id", type = Long.class),
                @ColumnResult(name = "total", type = int.class)
            },
            targetClass = CategoryWithBookCount.class
        )
    }
)
public class Category extends Base{
    @Column
    private String name;
    
    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();
}
