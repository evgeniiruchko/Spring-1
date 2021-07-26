package ru.geekbrains.app.homework11.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.geekbrains.app.homework11.services.UserService;

@EnableWebSecurity
public class DaoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(DaoSecurityConfig.class.getName());

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("dao authentication provider");
        http.authorizeRequests()
                .antMatchers("/app/**").authenticated()  //только залогиненый
                //.antMatchers("/admin/**").hasAnyRole("ADMIN") //только с ролью админ
                .anyRequest().permitAll()  //могут попасть все
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }
}
