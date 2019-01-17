package com.SundayScaries.MurderClueWalk.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/game").hasRole("USER")
//                .and()
//                .formLogin();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/console/**").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/game**").hasRole("USER")
                .and()
                .authorizeRequests()
                .antMatchers("/quiz").hasRole("USER")
                .and()
                .authorizeRequests()
                .antMatchers("/profile").hasRole("USER")
                .and()
                .formLogin().defaultSuccessUrl("/findAllUsers", true)
                .loginPage("/login").permitAll()
                .usernameParameter("loginName");




        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

}
