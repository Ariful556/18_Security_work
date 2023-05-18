package com.example.main.service.implementation;

import com.example.main.entity.Role;
import com.example.main.entity.UserEntity;
import com.example.main.model.AuthenticationResponse;
import com.example.main.model.UserRequestModel;
import com.example.main.repository.UserRepository;
import com.example.main.service.UserService;
import com.example.main.utlis.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }

    public ResponseEntity<Object> register(UserRequestModel requestModel) {
        UserEntity userEntity = UserEntity.builder()
                .email(requestModel.getEmail())
//                .role(requestModel.getRole())
                .address(requestModel.getAddress())
                .firstname(requestModel.getFirstname())
                .lastname(requestModel.getLastname())
                .password(passwordEncoder.encode(requestModel.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(userEntity);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .token(jwtService.generateToken(userEntity))
                .build();
//        UserEntity savedUserEntity = userRepository.save(userEntity);
        return new ResponseEntity<>(authenticationResponse, HttpStatus.CREATED);
    }
}

