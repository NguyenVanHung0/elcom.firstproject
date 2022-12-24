/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcom.firstproject.dto;

/**
 *
 * @author ADMIN
 */
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryWithBookCount {
    private Long categoryId;
    private int total;
    
    public CategoryWithBookCount(Long id, int total){
        this.categoryId = id;
        this.total = total;
    }
}
