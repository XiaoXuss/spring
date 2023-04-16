package com.example.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.entity.Users;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xab
 * @since 2023-04-13
 */
public interface IUsersService extends IService<Users> {
    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);
    /**
     * 根据用户名获取后台管理员
     */
    Users getAdminByUsername(String username);

    /**
     *获取用户登录信息
     */
    UserDetails loadUserByUsername(String username);
}
