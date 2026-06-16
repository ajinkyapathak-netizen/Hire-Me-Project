package com.hireme.user_service.service;

import com.hireme.user_service.dto.UserDTO;
import com.hireme.user_service.entity.User;
import com.hireme.user_service.mapper.UserMapper;
import com.hireme.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
        // Create User....
    @Override
    public UserDTO createUser(User user) {
        User savedUser = userRepository.save(user);
        return UserMapper.mapToDTO(savedUser);
    }

    // get all users...
    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream().map(UserMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    // get user by Id...
    @Override
    public UserDTO getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() ->
                 new RuntimeException("User Not Found with Id : " + id));

        return UserMapper.mapToDTO(user);

    }

}