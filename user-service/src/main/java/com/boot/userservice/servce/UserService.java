package com.boot.userservice.servce;

import com.boot.userservice.dto.ResponseDto;
import com.boot.userservice.entity.User;

public interface UserService {
    User saveUser(User user);

    ResponseDto getUser(Long userId);
}
