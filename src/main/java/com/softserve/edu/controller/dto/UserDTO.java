package com.softserve.edu.controller.dto;


import com.softserve.edu.entity.enums.Role;
import com.softserve.edu.validator.PasswordMatches;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches(message = "{password.validation.error.not.matching}")
public class UserDTO {

    @NotNull
    @Size(min = 5, max = 32, message = "{registration.error.username.length}")
    private String username;
    @NotNull
    @Size(min = 8, max = 40, message = "{registration.error.password.length}")
    private String password;
    @NotNull
    private String matchingPassword;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
