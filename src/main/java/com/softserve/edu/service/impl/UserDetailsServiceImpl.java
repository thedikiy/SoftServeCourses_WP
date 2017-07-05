package com.softserve.edu.service.impl;

import com.softserve.edu.controller.dto.UserDTO;
import com.softserve.edu.dao.UserDAO;
import com.softserve.edu.entity.User;
import com.softserve.edu.entity.enums.Role;
import com.softserve.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl extends AbstractCRUDService<User> implements
        UserDetailsService, UserService {

    private UserDAO userDAO;

    @Autowired
    public UserDetailsServiceImpl(UserDAO userDAO) {
        super(userDAO);
        this.userDAO = userDAO;
    }

    @Transactional
    public User createNewAccount(UserDTO userDTO) {
        User newUser = null;
        if (!isUserExists(userDTO)) {
            newUser = new User();
            newUser.setUsername(userDTO.getUsername());
            newUser.setPassword(userDTO.getPassword());
            if (userDTO.getRole() != null)
                newUser.setRole(userDTO.getRole());
            else
                newUser.setRole(Role.PASSENGER);
            addElement(newUser);
        }
        return newUser;
    }

    private boolean isUserExists(UserDTO user) {
        return userDAO.findUserByUsername(user.getUsername()) != null;
    }

    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userDAO.findUserByUsername(username);
        if (user == null) {
            user = new User();
        }
        return new UserDetailsImpl(user);
    }

    public User getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return null;
        }
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return null;
        }
        return ((UserDetailsImpl) authentication.getPrincipal()).getUser();
    }
}
