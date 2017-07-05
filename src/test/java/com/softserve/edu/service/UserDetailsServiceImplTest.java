package com.softserve.edu.service;

import com.softserve.edu.controller.dto.UserDTO;
import com.softserve.edu.dao.UserDAO;
import com.softserve.edu.entity.User;
import com.softserve.edu.entity.enums.Role;
import com.softserve.edu.service.impl.UserDetailsServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserDetailsServiceImplTest {

    @Test
    public void createNewAccount_UserCreated() {
        UserDAO userDAO = mock(UserDAO.class);
        UserService userService = new UserDetailsServiceImpl(userDAO);
        User expected = new User();
        expected.setUsername("Root");
        expected.setPassword("1234");
        expected.setRole(Role.ADMIN);

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("Root");
        userDTO.setPassword("1234");
        userDTO.setRole(Role.ADMIN);
        when(userDAO.findUserByUsername(userDTO.getUsername())).thenReturn(null);

        User actual = userService.createNewAccount(userDTO);

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void createNewAccount_NoRole_UserPassengerCreated() {
        UserDAO userDAO = mock(UserDAO.class);
        UserService userService = new UserDetailsServiceImpl(userDAO);
        User expected = new User();
        expected.setUsername("Root");
        expected.setPassword("1234");
        expected.setRole(Role.PASSENGER);

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("Root");
        userDTO.setPassword("1234");
        when(userDAO.findUserByUsername(userDTO.getUsername())).thenReturn(null);

        User actual = userService.createNewAccount(userDTO);

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void createNewAccount_UserExists_NullReturned() {
        UserDAO userDAO = mock(UserDAO.class);
        UserService userService = new UserDetailsServiceImpl(userDAO);
        User user = new User();
        user.setUsername("Root");
        user.setPassword("1234");
        user.setRole(Role.PASSENGER);

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("Root");
        userDTO.setPassword("1234");
        when(userDAO.findUserByUsername(userDTO.getUsername())).thenReturn(user);

        User actual = userService.createNewAccount(userDTO);

        Assert.assertEquals(actual,null);
    }


}
