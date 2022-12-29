/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.elcom.firstproject.mysql.repository;

import com.elcom.firstproject.mysql.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ADMIN
 */
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
