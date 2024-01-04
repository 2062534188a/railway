package com.railway.Controller;

import com.railway.DTO.UserRegisterDTO;
import com.railway.Utils.Result;
//import io.swagger.annotations.Api;
import com.railway.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/user")
//@Api("登录接口")
public class LoginController {


    @Resource
    private UserService userService;

    /**
     * 登录接口
     * @param loginMsg 用户名/手机号/邮箱
     * @param password 密码
     * @return 登录验证回调
     */
    @PostMapping("/login")
    public Result loginByPassword(@RequestParam String loginMsg,@RequestParam String password,@RequestParam Integer loginMethod){
        return userService.login(loginMsg,password,loginMethod);
    }

    /**
     * 注册接口
     * @return 注册验证回调
     */
    @PostMapping("/register")
    public Result loginByPassword(@RequestBody UserRegisterDTO userRegisterDTO, HttpServletRequest request){
        userRegisterDTO.setIP(request.getRemoteAddr());
        return userService.register(userRegisterDTO);
    }
}
