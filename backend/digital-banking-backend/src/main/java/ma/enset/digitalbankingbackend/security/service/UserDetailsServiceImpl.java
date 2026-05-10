package ma.enset.digitalbankingbackend.security.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsServiceImpl {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        BCryptPasswordEncoder passwordEncoder =
                new BCryptPasswordEncoder();

        UserDetails user = User
                .withUsername("user")
                .password(passwordEncoder.encode("1234"))
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder.encode("1234"))
                .roles("ADMIN","USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}