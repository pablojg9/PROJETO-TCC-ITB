package com.itb.tcc.amazbook.amazbook.modules.jwt.config;

import com.itb.tcc.amazbook.amazbook.modules.jwt.filter.JWTApiAuthenticationFilter;
import com.itb.tcc.amazbook.amazbook.modules.jwt.filter.JWTLoginFilter;
import com.itb.tcc.amazbook.amazbook.modules.user.service.ImplementationUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

    private final ImplementationUserDetailsService implementationUserDetailsService;

    public WebConfigSecurity(ImplementationUserDetailsService implementationUserDetailsService) {
        this.implementationUserDetailsService = implementationUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .disable()
                .authorizeHttpRequests()// Ativação a restrição a URL
                .antMatchers(        /*"/api/category/",
                                                "/api/category/name/**",
                                                "/api/category/id/**",
                                                "/api/book/",
                                                "/api/book/name/**",
                                                "/api/book/id/**",
                                                "/api/usuarios/save",
                                                "/api/endereco/**"*/
                        "/api/**"
                                                )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/index")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().
                addFilterBefore(
                        new JWTLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTApiAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO - Service que irá consultar o user no banco de dados
        auth.userDetailsService(implementationUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder()); // Padrão de codificação de senha para o user



    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}