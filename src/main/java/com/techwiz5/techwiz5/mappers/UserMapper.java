package com.techwiz5.techwiz5.mappers;


import com.techwiz5.techwiz5.dtos.UserDTO;
import com.techwiz5.techwiz5.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toUserSummaryDTO(User user) {
        if (user == null) return null;
        return UserDTO.builder()
                .id(user.getId())
                .code(user.getCode())
                .fullName(user.getUsername())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }
}
