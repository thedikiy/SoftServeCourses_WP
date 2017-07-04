package com.softserve.edu.service;

import com.softserve.edu.controller.dto.UserDTO;
import com.softserve.edu.entity.User;

public interface UserService extends ICRUDService<User> {
    User createNewAccount(UserDTO userDTO);
}
