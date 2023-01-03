
package com.elcom.firstproject.mysql.service.imp;

import com.elcom.firstproject.auth.jwt.JwtTokenProvider;
import com.elcom.firstproject.convert.Mapper;
import com.elcom.firstproject.mysql.dto.AuthorDto;
import com.elcom.firstproject.mysql.model.Author;
import com.elcom.firstproject.mysql.repository.AuthorRepository;
import com.elcom.firstproject.mysql.service.AuthorService;
import java.util.ArrayList;
import java.util.List;
import com.elcom.firstproject.exception.NoSuchElementException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Autowired
    Mapper mapper;
    
    @Autowired
    private RedisTemplate template;

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
            template.opsForHash().put("author", id, author);
            template.expire("UniqueKey",30, TimeUnit.SECONDS);
            LOGGER.info("them cache author co id: " + id);
            LOGGER.info(template.opsForHash().get("author", id).toString());
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
