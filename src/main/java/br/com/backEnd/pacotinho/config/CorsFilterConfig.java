package br.com.backEnd.pacotinho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsFilterConfig {

    public static final List<String> allowedOrigins = Arrays.asList("http://localhost:4200");

    @Bean
    public FilterRegistrationBean<CorsFilter> initCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        config.addAllowedMethod("*");
        config.setAllowedOrigins(allowedOrigins);

        //Configuração para API de login
        UrlBasedCorsConfigurationSource authConfigSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration authConfig = new CorsConfiguration();
        authConfig.setAllowCredentials(true);
        authConfig.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        authConfig.addAllowedMethod("*");
        authConfig.setAllowedOrigins(allowedOrigins);
        authConfigSource.registerCorsConfiguration("/auth/login", authConfig);

        //Configuração para API de validação de token já existente
        UrlBasedCorsConfigurationSource tokenValid = new UrlBasedCorsConfigurationSource();
        CorsConfiguration tokenValidConfig = new CorsConfiguration();
        tokenValidConfig.setAllowCredentials(true);
        tokenValidConfig.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        tokenValidConfig.addAllowedMethod("*");
        tokenValidConfig.setAllowedOrigins(allowedOrigins);
        tokenValid.registerCorsConfiguration("/auth/tokenValid", authConfig);

        //Configuração para API de criação de novo usuario
        UrlBasedCorsConfigurationSource newUser = new UrlBasedCorsConfigurationSource();
        CorsConfiguration newUserConfig = new CorsConfiguration();
        newUserConfig.setAllowCredentials(true);
        newUserConfig.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        newUserConfig.addAllowedMethod("*");
        newUserConfig.setAllowedOrigins(allowedOrigins);
        newUser.registerCorsConfiguration("/user/newExternalUser", authConfig);

        source.registerCorsConfiguration("/**", config);
        source.registerCorsConfiguration("/auth/login", authConfig);
        source.registerCorsConfiguration("/auth/tokenValid", tokenValidConfig);
        source.registerCorsConfiguration("/user/newExternalUser", newUserConfig);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}