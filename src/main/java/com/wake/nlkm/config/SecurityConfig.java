package com.wake.nlkm.config;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wake.nlkm.service.impl.UserServiceImpl;
import com.wake.nlkm.utils.RespBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.PrintWriter;
import java.util.concurrent.TransferQueue;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService detailsService() {
        return new UserServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("root")
//                .password("123").roles("admin");
        auth.userDetailsService(detailsService())
                .passwordEncoder(passwordEncoder());

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**","/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/v2/*").permitAll()
                .antMatchers("/csrf").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/doLogin")
                .successHandler(((httpServletRequest, httpServletResponse, authentication) -> {
                    Object principal = authentication.getPrincipal();
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    RespBean respBean = RespBean.ok("登录成功");
//                    out.write(new ObjectMapper().writeValueAsString(principal));
                    out.write(JSONObject.toJSONString(respBean));
                    out.flush();
                    out.close();
                }))
                .failureHandler(((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    RespBean respBean = RespBean.error("登录失败");
//                    out.write(e.getMessage());
                    out.write(JSONObject.toJSONString(respBean));
                    out.flush();
                    out.close();
                }))
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    RespBean respBean = RespBean.ok("注销成功");
                    out.write(JSONObject.toJSONString(respBean));
                    out.flush();
                    out.close();
                }))
                .deleteCookies()
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf().disable().exceptionHandling()
                .authenticationEntryPoint(((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    RespBean.ok();
                    out.write("尚未登录，请先登录");
                    out.flush();
                    out.close();
                }));

//        http.authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
    }
}