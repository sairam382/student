package com.example.studentregistration.SecurityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.example.studentregistrationsystem.service.StudentService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @SuppressWarnings("unused")
	@Autowired
    private StudentService studentService;

    @SuppressWarnings({ "deprecation", "removal" })
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/student/**").hasRole("STUDENT")
                .requestMatchers("/", "/login", "/register").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/student/dashboard", true)
            .and()
            .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
}

