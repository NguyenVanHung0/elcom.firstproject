
package com.elcom.firstproject.postgresql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BorrowLogNameWithTime {
    private String dateStart;
    
    private String dateEnd;
    
    private String name;
    
    private Long count;
    
    public BorrowLogNameWithTime(Long count, String name){
        this.setCount(count);
        this.setName(name);
    }
}
