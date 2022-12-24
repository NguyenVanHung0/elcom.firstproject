/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcom.firstproject.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Getter
@Setter
public class AuthorWithBookCount {
    private Long authorId;
    private int total;
    
    public AuthorWithBookCount(Long id, int total){
        this.authorId = id;
        this.total = total;
    }
}
