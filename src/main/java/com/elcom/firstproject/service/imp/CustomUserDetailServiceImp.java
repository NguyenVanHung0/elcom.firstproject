
package com.elcom.firstproject.service.imp;

import com.elcom.firstproject.auth.CustomUserDetails;
import com.elcom.firstproject.dto.UserDto;
import com.elcom.firstproject.model.User;
import com.elcom.firstproject.repository.UserRepository;
import com.elcom.firstproject.service.UserService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailServiceImp implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found with username : " + username);
        return new CustomUserDetails(user);
    }
    
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null)
            throw new UsernameNotFoundException("User not found with id : " + id);
        return new CustomUserDetails(user);
    }

    
    
}
