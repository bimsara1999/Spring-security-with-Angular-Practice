package com.springbootAcademy.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

      //  http.csrf().and().cors().disable()
             //   authorizeRequests();
               // .anyRequest("api/v1/account/my-account" , "api/v1/loan/my-loan").authenticated()
              //  .anyRequest("api/v1/notice/my-notices").permitAll()
               // .and().formLogin().and().httpBasic();

        return http.build();
    }
/*
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("1234")
                .authorities("admin")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource  dataSource){
        return  new JdbcUserDetailsManager(dataSource);
    }
*/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
