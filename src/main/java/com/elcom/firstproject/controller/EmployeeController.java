/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcom.firstproject.controller;

import com.elcom.firstproject.postgresql.dto.EmployeeDto;
import com.elcom.firstproject.postgresql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    @PostMapping("")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.createEmployee(employeeDto));
    }
}
