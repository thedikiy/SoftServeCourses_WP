package com.softserve.edu.config;

import com.softserve.edu.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.authenticationProvider(getAuthProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/login*").anonymous()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login").defaultSuccessUrl("/",true)
                .failureUrl("/login").and()
                .logout().logoutSuccessUrl("/login");
    }


    private AuthenticationProvider getAuthProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
}
