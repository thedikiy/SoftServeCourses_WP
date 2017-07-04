package com.softserve.edu.controller;

import com.softserve.edu.controller.dto.UserDTO;
import com.softserve.edu.entity.User;
import com.softserve.edu.entity.enums.Role;
import com.softserve.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
public class RegistrationController {
    private static final String USER_EXISTS = "Пользователь с таким именем уже существует";
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("roles", Role.values());
        model.addAttribute(userDTO);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUserAccount(
            @ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result,
            Errors errors, Model model) {
        User registered = null;
        if (!result.hasErrors()) {
            if (userService.createNewAccount(userDTO) == null) {
                model.addAttribute("errors",
                        Arrays.asList(new FieldError("user","username",USER_EXISTS)));
                return showRegistrationForm(model);
            }

        } else {
            model.addAttribute("errors", errors.getAllErrors());
            return showRegistrationForm(model);
        }
        return "login";
    }

}
