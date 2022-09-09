package com.deliveryou.configuration;

import com.deliveryou.pojo.Role;
import com.deliveryou.pojo.User;
import com.deliveryou.service.interfaces.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {
        "com.deliveryou.repository",
        "com.deliveryou.service"
})
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("phone_number")
                .passwordParameter("password")
                .successHandler( (request, response, authentication) -> {
                    response.setStatus(HttpStatus.OK.value());
                    User user = userDetailsService.getUser(authentication.getName());
                    request.getSession().setAttribute("current_user", user);
                    System.out.println("current user: " + user);

                    switch (user.getRole().getName()) {
                        case Role.REGULAR_USER:
                            response.sendRedirect("/deliveryou_war_exploded/user/app");
                            break;
                        case Role.SHIPPER:
                            response.sendRedirect("/deliveryou_war_exploded/shipper/app");
                            break;
                    }
                } )
                .failureHandler( ((request, response, exception) -> {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    Map<String, Object> data = new HashMap<>();

                    data.put("msg", "failed to log in");

                    response.getOutputStream()
                            .println(new ObjectMapper().writeValueAsString(data));
                }) );

        http.logout().logoutSuccessHandler((request, response, authentication) -> {
            request.getSession().removeAttribute("current_user");
            response.sendRedirect("/deliveryou_war_exploded/");
        });

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                .antMatchers("/shipper/**").authenticated()
                .antMatchers("/shipper/**").access("hasRole('ROLE_SHIPPER')");

        http.authorizeRequests()
                .antMatchers("/test/**").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}