package com.deliveryou.configuration;

import com.cloudinary.Cloudinary;
import com.deliveryou.pojo.Role;
import com.deliveryou.pojo.User;
import com.deliveryou.service.interfaces.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@ComponentScan(basePackages = {
        "com.deliveryou.repository",
        "com.deliveryou.service"
})
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Configuration
    @Order(1)
    public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter{
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
                    .successHandler((request, response, authentication) -> {
                        User user = userDetailsService.getUser(authentication.getName());

                        if (user.getRole().getName().equals(Role.ADMIN))
                            response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        else {
                            response.setStatus(HttpStatus.OK.value());
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
                        }
                    })
                    .failureHandler(((request, response, exception) -> {
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        Map<String, Object> data = new HashMap<>();

                        data.put("msg", "failed to log in");

                        response.getOutputStream()
                                .println(new ObjectMapper().writeValueAsString(data));
                    }));

            http.logout().logoutSuccessHandler((request, response, authentication) -> {
                request.getSession().removeAttribute("current_user");
                response.sendRedirect("/deliveryou_war_exploded/");
            });

            http.authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/user/**").authenticated()
                    .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/shipper/**").authenticated()
                    .antMatchers("/shipper/**").access("hasRole('ROLE_SHIPPER')")
                    .antMatchers("/common/**").authenticated();

            http.authorizeRequests()
                    .antMatchers("/test/**").permitAll();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        }

        @Bean
        public Cloudinary cloudinary() {
            return new Cloudinary(new HashMap() {{
                put("cloud_name", "quocnv0707");
                put("api_key", "252896799917597");
                put("api_secret", "LhJpqRPCnCr6AxVsaSnsG7TpjtA");
                put("secure", true);
            }});
        }
    }

    @Configuration
    @Order(-1)
    public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
        private UserService userDetailsService;
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.headers().frameOptions().disable();
            http.formLogin()
                    .loginPage("/admin")
                    .usernameParameter("phone_number")
                    .passwordParameter("password")
                    .successHandler( (request, response, authentication) -> {
                        User user = userDetailsService.getUser(authentication.getName());
                        if (!user.getRole().getName().equals(Role.ADMIN))
                            response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        else {
                            response.setStatus(HttpStatus.OK.value());
                            request.getSession().setAttribute("current_user", user);
                            System.out.println("current user: " + user);
                            response.sendRedirect("/deliveryou_war_exploded/admin/app");
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

            http.requestMatchers().antMatchers("/admin/**").and()
                    .authorizeRequests()
                    .antMatchers("/admin").permitAll()
                    .antMatchers("/admin/**").authenticated()
                    .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
        }
    }

}