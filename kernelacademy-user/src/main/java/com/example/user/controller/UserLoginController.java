package com.example.user.controller;

import com.example.common.entity.Users;
import com.example.common.webapi.ResultObject;
import com.example.user.service.IUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * UserLoginController : 用户登录接口
 *
 * @author xab
 * @date 2023/4/13 23:06
 */

@Api(tags = "用户登录")
@Controller
@RequestMapping
public class UserLoginController {
    @Autowired
    private IUsersService usersService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public String login(@Validated Users users, BindingResult result, Model model) {
        String token = usersService.login(users.getUserName(), users.getPassword());
        if (token == null) {
            model.addAttribute(ResultObject.validateFailed("用户名或密码错误"));
        }
        //JWT身份验证令牌
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        model.addAttribute(ResultObject.success(tokenMap));
        return "login";
    }
}
