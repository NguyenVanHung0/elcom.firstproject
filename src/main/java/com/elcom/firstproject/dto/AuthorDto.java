
package com.elcom.firstproject.dto;

import com.elcom.firstproject.model.Author;
import com.elcom.firstproject.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ColumnResult;
import javax.persistence.EntityManager;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto extends BaseDto{
    
    private String name;
    
    private String website;
    
    private String note;
    
    private List<Long> books = new ArrayList<>();
    
}
