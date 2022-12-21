
package com.elcom.firstproject.dto;

import com.elcom.firstproject.model.Author;
import com.elcom.firstproject.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto extends  BaseDto{

    private String name;
    
    private String nhaXB;
    
    private String namXB;
    
    private String firstText;
    
    private Long authorId;
    
    private Long categoryId;
}
