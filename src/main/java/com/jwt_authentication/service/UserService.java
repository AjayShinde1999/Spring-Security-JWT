package com.jwt_authentication.service;

import com.jwt_authentication.dto.SignUpDto;
import com.jwt_authentication.dto.UserDto;
import com.jwt_authentication.entity.User;
import com.jwt_authentication.entity.enums.Role;
import com.jwt_authentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(
                () -> new RuntimeException("User not found with email : " + username)
        );
    }

    public UserDto signUp(SignUpDto signUpDto) {
        User user = modelMapper.map(signUpDto, User.class);
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRole(Role.MANAGER);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    public User getUserById(long id) {
       return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found with id : " + id)
        );
    }
}
