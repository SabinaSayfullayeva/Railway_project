package com.example.railway.service.impl;

import com.example.railway.dto.user.UserDTO;
import com.example.railway.exception.UserNotFoundException;
import com.example.railway.repository.UserRepository;
import com.example.railway.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getById(Long id) {
        return UserDTO.from(userRepository
                .findByIdAndEnabledIsTrue(id)
                .orElseThrow(
                        () -> new UserNotFoundException(
                                "User not found with id: " + id
                        )
                ));
    }
}
