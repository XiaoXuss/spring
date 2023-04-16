package com.example.security.config;


import com.example.security.component.JwtAuthenticationTokenFilter;
import com.example.security.component.RestAuthenticationEntryPoint;
import com.example.security.component.RestfulAccessDeniedHandler;
import com.example.security.model.CustomAuthenticationSuccessHandle;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SecurityConfig : Security配置扩展
 *
 * @author xab
 * @date 2023/4/11 23:30
 */
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(IgnoreUrlsConfig.class)
public class SecurityConfig  {

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        //配置安全路径白名单
        return (web -> web.ignoring().antMatchers(ignoreUrlsConfig().getUrls().toArray(new String[0])));
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        //过滤 HTTP 请求并进行身份认证和授权
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(auth ->{
                    auth.antMatchers("/login").permitAll();
                    auth.antMatchers("/user").hasRole("USER_USER");
                    auth.antMatchers("/admin").hasRole("USER_ADMIN");
                    auth.antMatchers("/teacher").hasRole("USER_TEACHER");
                    auth.anyRequest().authenticated();
                })
                .formLogin()
                .loginPage("/login")
                .and()
                //关闭跨站请求及不使用session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //自定义权限拒绝处理类
                .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler())
                .authenticationEntryPoint(restAuthenticationEntryPoint())
                .and()
                //自定义权限拦截器JWT过滤器
                .addFilterBefore(jwtAuthenticationTokenFilter(),UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    //配置AuthenticationSuccessHandler实现类 用来实现不同用户登录跳转不同客户端
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandle();
    }
    //security密码加密器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //JWT登录授权过滤器
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    //安全路径白名单
    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }

    @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {return new RestAuthenticationEntryPoint();}

    @Bean
    public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {return new RestfulAccessDeniedHandler();}

    @Bean
    public UserDetailsService userDetailsService() {return new UserDetailsService() {
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return null;
        }
    };}
}
