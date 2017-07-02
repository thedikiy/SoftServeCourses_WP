package com.softserve.edu.service.impl;

import com.softserve.edu.UserDTO;
import com.softserve.edu.dao.impl.UserDAOImpl;
import com.softserve.edu.entity.User;
import com.softserve.edu.entity.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl extends AbstractCRUDService<User> implements
        UserDetailsService {

    private UserDAOImpl userDAO;

    @Autowired
    public UserDetailsServiceImpl(UserDAOImpl userDAO) {
        super(userDAO);
        this.userDAO = userDAO;
    }

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
        try {
            loadUserByUsername(user.getUsername());
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findUserByName("User", "username", username);
        return new UserDetailsImpl(user);
    }

    private class UserDetailsImpl implements UserDetails {
        private User user;

        public UserDetailsImpl(User user) {
            this.user = user;
        }

        public Collection<? extends GrantedAuthority> getAuthorities() {
            Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            authorities.add(new
                    SimpleGrantedAuthority(user.getRole().toString()));
            return authorities;
        }

        public String getPassword() {
            return user.getPassword();
        }

        public String getUsername() {
            return user.getUsername();
        }

        public boolean isAccountNonExpired() {
            return true;
        }

        public boolean isAccountNonLocked() {
            return true;
        }

        public boolean isCredentialsNonExpired() {
            return true;
        }

        public boolean isEnabled() {
            return true;
        }
    }
}
