
package com.elcom.firstproject.service;

import com.elcom.firstproject.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {
    //UserDetails loadUserById(Long id);
    UserDto getUserById(Long id);
    UserDto createUser(UserDto userDto);
}
