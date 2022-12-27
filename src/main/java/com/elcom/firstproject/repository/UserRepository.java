
package com.elcom.firstproject.repository;

import com.elcom.firstproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long>{
    @Query(value = "select * from user where username = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);
}
