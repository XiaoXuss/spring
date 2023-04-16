package com.example.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.entity.Users;
import com.example.common.exception.Asserts;
import com.example.security.model.AdminUserDetails;
import com.example.security.util.JwtTokenUtil;
import com.example.user.mapper.UsersMapper;
import com.example.user.service.IUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xab
 * @since 2023-04-13
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    private static Logger LOGGER = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            //用户认证授权信息
            UserDetails userDetails = loadUserByUsername(username);
            //验证密码
            if (passwordEncoder.matches(password, userDetails.getPassword())) {
                //抛出自定义异常
                Asserts.fail("密码不正确");
            }
            //返回token
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        //将token返回给Controller接口
        return token;
    }

    /**
     * 返回一个USerDetails对象,用于springSecurity的认证授权
     *
     * @param username
     * @return
     */
    public UserDetails loadUserByUsername(String username) {
        Users admin = getAdminByUsername(username);
        if (admin != null) {
            return new AdminUserDetails(admin);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    /**
     * 实际查询数据库
     *
     * @param username
     * @return
     */
    @Override
    public Users  getAdminByUsername(String username) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", username);
        List<Users> usersList = baseMapper.selectList(queryWrapper);
        if (usersList != null && usersList.size() > 0) {
            System.out.println(usersList.get(0));
            return usersList.get(0);
        }
        // 用户名错误，提前抛出异常
        throw new UsernameNotFoundException("用户名错误");
    }

}