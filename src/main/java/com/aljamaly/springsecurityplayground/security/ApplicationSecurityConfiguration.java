package com.aljamaly.springsecurityplayground.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.aljamaly.springsecurityplayground.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails hamzaJamalyUser = User.builder()
                .username("hamzajamaly")
                .password(passwordEncoder.encode("password"))
                .roles(STUDENT.name()) //We assign roles to implement role based authentication
                .build();

        UserDetails minaUser = User.builder()
                .username("minabaghdadi")
                .password(passwordEncoder.encode("jamajim123"))
                .roles(ADMIN.name()) //ROLE_ADMIN
                .build();

        UserDetails tomUser = User.builder()
                .username("tomjones")
                .password("password")
                .roles(ADMINTRAINEE.name()) //ROLE_ADMIN TRAINEE
                .build();

        return new InMemoryUserDetailsManager(hamzaJamalyUser,minaUser, tomUser);

    }
}
