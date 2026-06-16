package com.hireme.user_service.mapper;

import com.hireme.user_service.dto.UserDTO;
import com.hireme.user_service.entity.User;

public class UserMapper {

    public static UserDTO mapToDTO(User user) {
        return new UserDTO(user.getId(),
                user.getFullName(),
                user.getEmail()
        );
    }
}
