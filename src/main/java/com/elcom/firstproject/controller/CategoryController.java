/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcom.firstproject.controller;

import com.elcom.firstproject.auth.jwt.JwtTokenProvider;
import com.elcom.firstproject.mysql.dto.CategoryDto;
import com.elcom.firstproject.mysql.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    private RedisTemplate template;
    
    
    @GetMapping("")
    public ResponseEntity<?> getListCategory(){
        return ResponseEntity.ok(categoryService.getListCategory());
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    
    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.createCategory(categoryDto));
    }
    
    @PutMapping("{id}")
    public ResponseEntity<?> updateCategory( @PathVariable Long id, @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, id));
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
}
