/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcom.firstproject.postgresql.model;

import com.elcom.firstproject.mysql.model.Base;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "testtable")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TestTable extends Base{
    @Column
    private String name;
}
