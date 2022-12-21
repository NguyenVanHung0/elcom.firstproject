
package com.elcom.firstproject.dto;

import com.elcom.firstproject.model.Book;
import java.util.ArrayList;
import java.util.List;
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
    
    private List<Book> books = new ArrayList<>();
}
