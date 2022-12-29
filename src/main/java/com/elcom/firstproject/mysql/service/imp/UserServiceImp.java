/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcom.firstproject.mysql.service.imp;

import com.elcom.firstproject.convert.Mapper;
import com.elcom.firstproject.mysql.dto.UserDto;
import com.elcom.firstproject.exception.NoSuchElementException;
import com.elcom.firstproject.mysql.model.User;
import com.elcom.firstproject.mysql.repository.UserRepository;
import com.elcom.firstproject.mysql.service.UserService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    Mapper mapper;

//    @Override
//    public UserDetails loadUserById(Long id) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            return mapper.toUserDto(user);
        }
        throw new NoSuchElementException("Khong ton tai user co ma: " + id);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        if(userDto != null){
            user = mapper.toUser(userDto);
            user.setCreatedDate(new Date());
            user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
            userRepository.save(user);
        }
        return mapper.toUserDto(user);
    }
    
    
}
