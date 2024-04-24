package com.mytech.rest.webservices.restfulwebservices.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        //1: Response to preflight request doesn't pass access control check
//        //2: basic auth
//        return
//                http
//                        .authorizeHttpRequests(
//                                auth ->
//                                        auth
//                                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                                                .anyRequest().authenticated()
//                        )
//                        .httpBasic(Customizer.withDefaults())
//                        .sessionManagement(
//                                session -> session.sessionCreationPolicy
//                                        (SessionCreationPolicy.STATELESS))
//                        .csrf(csrf -> csrf
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                // Added this:
//                .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler()))
//                        .build();
//    }
}