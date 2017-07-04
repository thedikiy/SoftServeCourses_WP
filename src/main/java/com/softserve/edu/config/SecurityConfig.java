package com.softserve.edu.config;

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

    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(getAuthProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/bus/**", "/driver/**","/journey/edit*",
                        "/journey/delete")
                .hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/passenger/**")
                .hasAnyAuthority("ADMIN", "MANAGER", "PASSENGER")
                .antMatchers("/login*").anonymous()
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().formLogin()
                .loginPage("/login").defaultSuccessUrl("/", true)
                .failureUrl("/login?error=true").and()
                .logout().logoutSuccessUrl("/login");
    }


    private AuthenticationProvider getAuthProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
}
