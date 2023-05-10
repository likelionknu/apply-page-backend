package com.springboot.applypage.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public SecurityConfiguration(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic().disable()

                .csrf().disable()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/sign-api/sign-in", "/sign-api/sign-up",
                        "/sign-api/exception").permitAll()
                .antMatchers(HttpMethod.GET, "/product/**").permitAll()
                .antMatchers("/sign-api/update-in")
                .hasAnyRole(
                        "ROOT",
                        "ADMIN",
                        "MANAGE",
                        "LION",
                        "APPLY"
                )//모든 권한

                .antMatchers("/adminLogin")
                .hasAnyRole(
                        "ROOT",
                        "ADMIN",
                        "MANAGE"
                )

                .antMatchers("**exception**").permitAll()

                .anyRequest().hasAnyRole("ADMIN")
                //.anyRequest().hasRole("USER")   //role 추가 해봄...

                .and()
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())

                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider)
                        , UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    public void configure(WebSecurity webSecurity){
        webSecurity.ignoring().antMatchers(
                "/v2/api-docs"
                , "/swagger-resources/**"
                , "/swagger-ui.html"
                , "/webjars/**"
                , "/swagger/**"
                , "/sign-api/exception"
                , "/"
                , "/static/**"
                , "/favicon.ico"
                , "/manifest.json");
    }

}
