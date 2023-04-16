package com.example.security.component;


import com.example.security.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JwtAuthenticationTokenFilter : JWT登录授权过滤器(每一次的请求都要经过这个过滤器)
 *
 * @author xab
 * @date 2023/4/10 21:21
 */

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Autowired
    private UserDetailsService userDetailsService; //获取用户详细信息
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //从客户端获取JWT
        String authHeader = request.getHeader(this.tokenHeader);
        //JWT是自定义格式,以tokenHead开头
        if(authHeader != null && authHeader.startsWith(this.tokenHead)) {
            // The part after "Bearer "
            String authToken = authHeader.substring(this.tokenHead.length()); //实际的Token值
            //从JWT中获取用户名
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            LOGGER.info("checking username:{}",username);//在日志中输出用户名

            // SecurityContextHolder 是 SpringSecurity 的一个工具类
            // 保存应用程序中当前使用人的Security上下文
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                //根据用户名获取登录用户信息
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                // 验证 token 是否过期
                if(jwtTokenUtil.validateToken(authToken,userDetails)) {
                    // 将登录用户保存到security上下文中
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                            null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    LOGGER.info("authenticated user:{}", username);
                }
            }
            filterChain.doFilter(request,response); //继续执行后续的过滤器或 Servlet
        }
    }
}
