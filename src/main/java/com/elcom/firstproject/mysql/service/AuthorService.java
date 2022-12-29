/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.elcom.firstproject.mysql.service;

import com.elcom.firstproject.mysql.dto.AuthorDto;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface AuthorService {
    List<AuthorDto> getListAuthor();
    AuthorDto getAuthorById(Long id);
    AuthorDto createAuthor(AuthorDto authorDto);
    AuthorDto updateAuthor(AuthorDto authorDto, Long id);
    AuthorDto deleteAuthor(Long id);
}
