
package com.elcom.firstproject.service.imp;

import com.elcom.firstproject.convert.Mapper;
import com.elcom.firstproject.dto.AuthorDto;
import com.elcom.firstproject.model.Author;
import com.elcom.firstproject.repository.AuthorRepository;
import com.elcom.firstproject.service.AuthorService;
import java.util.ArrayList;
import java.util.List;
import com.elcom.firstproject.exception.NoSuchElementException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    Mapper mapper;

    @Override
    public List<AuthorDto> getListAuthor() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> result = new ArrayList<>();
        if (!authors.isEmpty()) {
            for (Author author : authors) {
                result.add(mapper.toAuthorDto(author));
            }
        }
        return result;
    }

    @Override
    public AuthorDto getAuthorById(Long id){
        AuthorDto authorDto = new AuthorDto();
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            authorDto = mapper.toAuthorDto(author);
            return authorDto;
        }
        
        // Ném ra NoSuchElementException
        throw new NoSuchElementException("Tac gia khong ton tai");
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = new Author();
        if (authorDto != null) {
            author = mapper.toAuthor(authorDto);
            author.setCreatedDate(new Date());
            authorRepository.save(author);
        }
        return mapper.toAuthorDto(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, Long id) {
        Author oldAuthor = authorRepository.findById(id).orElse(null);
        Author newAuthor = new Author();
        if (oldAuthor != null) {
            newAuthor = mapper.toAuthor(oldAuthor, authorDto);
            newAuthor.setId(id);
            newAuthor.setModifiedDate(new Date());
            authorRepository.save(newAuthor);
            return mapper.toAuthorDto(newAuthor);
        }
        
        // Ném ra NoSuchElementException
        throw new NoSuchElementException("Tac gia khong ton tai");
    }

    @Override
    public AuthorDto deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            authorRepository.deleteById(id);
            return mapper.toAuthorDto(author);
        }
        
        // Ném ra NoSuchElementException
        throw new NoSuchElementException("Tac gia khong ton tai");
    }

}
