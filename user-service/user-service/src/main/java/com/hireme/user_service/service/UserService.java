package com.hireme.user_service.service;

import com.hireme.user_service.dto.UserDTO;
import com.hireme.user_service.entity.User;
import java.util.List;

public interface UserService {

    UserDTO createUser(User user);

    List<UserDTO> getAllUsers();

    // get user by Id...
    UserDTO getUserById(Long id);
}