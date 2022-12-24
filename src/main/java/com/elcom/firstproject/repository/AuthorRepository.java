
package com.elcom.firstproject.repository;

import com.elcom.firstproject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long>{
    
}
