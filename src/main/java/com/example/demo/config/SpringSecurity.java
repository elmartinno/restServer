package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/turnovers").permitAll()
                .antMatchers("/api/accounts").permitAll()
                .antMatchers("/api/fingByIban").permitAll()
                .antMatchers("/api/findTurnoversByIban").permitAll()
                .antMatchers("/api/addTurnover").permitAll()
                .antMatchers("/api/addAccount").permitAll();
    }
}
