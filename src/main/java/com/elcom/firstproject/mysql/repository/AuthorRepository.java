
package com.elcom.firstproject.mysql.repository;

import com.elcom.firstproject.mysql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long>{
    
}
