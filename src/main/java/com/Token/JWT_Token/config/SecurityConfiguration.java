package com.Token.JWT_Token.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     *
     * @param jwtAuthenticationFilter
     * @param authenticationProvider
     */
    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter,
                                 AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    /**
     *
     * @param http
     * @return
     * @throws Exception
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests()
                //csrf().disable().authorizeHttpRequests()
                .requestMatchers("/auth/login", "/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**", "/favicon.ico")
                .permitAll().anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        http.headers().frameOptions().disable();
        return http.build();
    }

}
