package com.vblog.config;

import com.vblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description spring security配置类。
 *              一般会通过自定义配置这三个方法来自定义我们的安全访问策略
 */
@Configuration
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    /**
     * @description 配置全局的认证相关的信息，其实就是AuthenticationProvider和UserDetailsService，前者是认证服务提供商，后者是用户详情查询服务；
     * @author lryepoch
     * @date 2020/5/27 11:17
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("进入WebSecurityConfig->AuthenticationManagerBuilder……");
        auth.userDetailsService(userService);
    }

    /**
     * @description 具体的权限控制规则配置。一个这个配置相当于xml配置中的一个标签。各种具体的认证机制的相关配置，
     * OpenIDLoginConfigurer、AnonymousConfigurer、FormLoginConfigurer、HttpBasicConfigurer等;
     * <p>
     * authenticated()要求在执行该请求时，必须已经登录了应用; permitAll()方法允许请求没有任何的安全限制;
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("进入WebSecurityConfig->HttpSecurity……");
        http.authorizeRequests()

                //登录后都可以访问/admin/category/all
                .antMatchers("/admin/category/all")
                .authenticated()

                // /admin/**的URL都需要有超级管理员角色才可以访问，如果使用.hasAuthority()来配置，需要在参数中加上ROLE_，如：.hasAuthority("ROLE_超级管理员")
                .antMatchers("/admin/**", "/reg")
                .hasRole("超级管理员")

                //其他路径都是登录认证后才可访问
                .anyRequest()
                .authenticated()

                //使用 form 表单进行登录(默认路径为/login)
                .and()
                .formLogin()
                .loginPage("/login_page")

                //自定义认证成功或者失败的返回json
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"success\",\"msg\":\"登录成功\"}");
                        out.flush();
                        out.close();
                    }
                })

                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                        out.flush();
                        out.close();
                    }
                }).loginProcessingUrl("/login")

                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()

                .and()
                .logout()
                .permitAll()

                //关闭csrf防护
                .and()
                .csrf()
                .disable()

                .exceptionHandling()
                .accessDeniedHandler(getAccessDeniedHandler());

    }

    /**
     * @description 一般不会过多来自定义 WebSecurity, 使用较多的是其ignoring() 方法用来忽略Spring Security 对静态资源的控制。
     * 全局请求忽略规则配置（比如说静态文件，比如说注册页面）、全局HttpFirewall配置、是否debug配置、全局SecurityFilterChain配置、
     * privilegeEvaluator、expressionHandler、securityInterceptor
     */
    @Override
    public void configure(WebSecurity webSecurity) {
        log.info("进入WebSecurityConfig->WebSecurity……");
        webSecurity.ignoring().antMatchers("/blogimg/**", "/index.html", "/static/**",
                "/swagger-ui.html","/webjars/**","/swagger-resources/**","/v2/**","/u/**","/swagger/**","/doc.html");
    }

    /**
     * @description 该类用来统一处理 AccessDeniedException 异常,AccessDeniedException 主要是在用户在访问受保护资源时被拒绝而抛出的异常
     * @author lryepoch
     * @date 2020/5/27 13:55
     */
    @Bean
    AccessDeniedHandler getAccessDeniedHandler() {
        return new AuthenticationAccessDeniedHandler();
    }

}
