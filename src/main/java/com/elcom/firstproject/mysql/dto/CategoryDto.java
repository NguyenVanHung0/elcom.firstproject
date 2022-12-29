
package com.elcom.firstproject.mysql.dto;

import com.elcom.firstproject.mysql.model.Book;
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
public class CategoryDto extends BaseDto{

    private String name;
    
    private List<Long> books = new ArrayList<>();
}
