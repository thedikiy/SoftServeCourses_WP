package com.softserve.edu.service;

import com.softserve.edu.dao.PassengerDAO;
import com.softserve.edu.entity.Passenger;
import com.softserve.edu.entity.User;
import com.softserve.edu.entity.enums.Role;
import com.softserve.edu.service.impl.PassengerServiceImpl;
import org.testng.annotations.Test;

import java.util.HashSet;

import static org.mockito.Mockito.*;

public class PassengerServiceImplTest {

    @Test
    public void getAllElements_RoleAdmin_AllPassengersExpected(){
        UserService userService = mock(UserService.class);
        PassengerDAO passengerDAO = mock(PassengerDAO.class);
        PassengerService passengerService = new PassengerServiceImpl(passengerDAO, userService);
        User user = new User();
        user.setRole(Role.ADMIN);

        when(userService.getCurrentUser()).thenReturn(user);
        when(userService.getElementByID(user.getUserId())).thenReturn(user);
        passengerService.getAllElements();

        verify(passengerDAO,times(1)).getAllElements();
    }

    @Test
    public void getAllElements_RoleManager_AllPassengersExpected(){
        UserService userService = mock(UserService.class);
        PassengerDAO passengerDAO = mock(PassengerDAO.class);
        PassengerService passengerService = new PassengerServiceImpl(passengerDAO, userService);
        User user = new User();
        user.setRole(Role.MANAGER);

        when(userService.getCurrentUser()).thenReturn(user);
        when(userService.getElementByID(user.getUserId())).thenReturn(user);
        passengerService.getAllElements();

        verify(passengerDAO,times(1)).getAllElements();
    }

    @Test
    public void getAllElements_RolePassenger_AllPassengersExpected(){
        UserService userService = mock(UserService.class);
        PassengerDAO passengerDAO = mock(PassengerDAO.class);
        PassengerService passengerService = new PassengerServiceImpl(passengerDAO, userService);
        User user = mock(User.class);

        when(userService.getCurrentUser()).thenReturn(user);
        when(userService.getElementByID(user.getUserId())).thenReturn(user);
        when(user.getRole()).thenReturn(Role.PASSENGER);
        when(user.getPassengers()).thenReturn(new HashSet<Passenger>());
        passengerService.getAllElements();

        verify(passengerDAO,times(0)).getAllElements();
        verify(user, times(1)).getPassengers();
    }
}
