package com.example.testApplication.demo.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class WebSecurityConfig  {

    @Autowired
    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void initialize(AuthenticationManagerBuilder builder, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) throws Exception {
        builder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//       return http
//                .authorizeRequests(authz -> authz
//                        .requestMatchers("/login", "/signup").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(formLogin ->
//                                formLogin
//                                        .loginPage("/login")
//                                        .permitAll()
//                                        .defaultSuccessUrl("/home", true)
//                                        .failureUrl("/login?error=true")
//                        // other configurations
//                ).build();

        return http
                .authorizeHttpRequests((authz) -> authz.requestMatchers("/login", "/signup").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults()).build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
        return builder.build();
    }
}
