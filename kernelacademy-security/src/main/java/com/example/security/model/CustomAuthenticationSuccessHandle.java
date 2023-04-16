package com.example.security.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CustomAuthenticationSuccessHandle : 根据用户角色跳转不同页面
 *
 * @author xab
 * @date 2023/4/11 23:48
 */
public class CustomAuthenticationSuccessHandle extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        //获取当前用户的UserDetails实例
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String role = userDetails.getAuthorities().iterator().next().getAuthority();

        //根据不同用户角色跳转不同页面
        if("USER_ADMIN".equals(role)) {
            super.setDefaultTargetUrl("/admin/home");
        } else if("USER_USER".equals(role)) {
            super.setDefaultTargetUrl("/user/home");
        } else if("USER_TEACHER".equals(role)) {
            super.setDefaultTargetUrl("/teacher/home");
        }
        super.onAuthenticationSuccess(request,response,authentication);
    }
}
