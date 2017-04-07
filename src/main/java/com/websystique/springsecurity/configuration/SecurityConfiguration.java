package com.websystique.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Ivan").password("111").roles("USER");
        auth.inMemoryAuthentication().withUser("Dima").password("222").roles("REDACTOR");
        auth.inMemoryAuthentication().withUser("Alex").password("333").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("Imant").password("444").roles("SUPERADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/edit/**").access("hasRole('REDACTOR')")
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/super_admin/**").access("hasRole('SUPERADMIN')")
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/access_denied");
    }
}
