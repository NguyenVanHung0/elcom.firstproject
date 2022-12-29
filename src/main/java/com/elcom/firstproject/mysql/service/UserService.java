
package com.elcom.firstproject.mysql.service;

import com.elcom.firstproject.mysql.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {
    //UserDetails loadUserById(Long id);
    UserDto getUserById(Long id);
    UserDto createUser(UserDto userDto);
}
