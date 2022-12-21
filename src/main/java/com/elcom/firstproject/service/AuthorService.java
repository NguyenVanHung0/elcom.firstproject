/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.elcom.firstproject.service;

import com.elcom.firstproject.dto.AuthorDto;
import com.elcom.firstproject.model.Author;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface AuthorService {
    List<AuthorDto> getListAuthor();
    AuthorDto getAuthorById(Long id) throws Exception;
    AuthorDto createAuthor(AuthorDto authorDto);
    AuthorDto updateAuthor(AuthorDto authorDto, Long id);
    AuthorDto deleteAuthor(Long id);
}
