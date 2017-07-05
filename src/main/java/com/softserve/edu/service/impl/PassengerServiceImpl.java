package com.softserve.edu.service.impl;

import com.softserve.edu.dao.PassengerDAO;
import com.softserve.edu.entity.Passenger;
import com.softserve.edu.entity.User;
import com.softserve.edu.entity.enums.Role;
import com.softserve.edu.service.PassengerService;
import com.softserve.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerServiceImpl extends AbstractCRUDService<Passenger> implements PassengerService {
    UserService userService;

    @Autowired
    public PassengerServiceImpl(PassengerDAO passengerDAO, UserService userService) {
        super(passengerDAO);
        this.userService = userService;
    }

    @Transactional
    @Override
    public List<Passenger> getAllElements() {
        User user = userService.getCurrentUser();
        user = userService.getElementByID(user.getUserId());
        Role role = user.getRole();
        if (role.equals(Role.ADMIN) || role.equals(Role.MANAGER)) {
            return super.getAllElements();
        }
        List<Passenger> list = new ArrayList<Passenger>();
        list.addAll(user.getPassengers());
        return list;
    }

}
