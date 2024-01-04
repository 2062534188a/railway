package com.railway.service;

import com.railway.DTO.UserRegisterDTO;
import com.railway.Utils.Result;
import com.railway.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author HH
* @description 针对表【railway_user(用户表)】的数据库操作Service
* @createDate 2023-12-22 18:37:04
*/
public interface UserService extends IService<User> {
    /**
     * 登录接口
     * @param loginMsg 用户名/手机号/邮箱
     * @param password 密码
     * @param loginMethod 登录方式 0:用户名 1:手机号 2:邮箱
     * @return 登录验证回调
     */
    Result login(String loginMsg, String password,Integer loginMethod);

    /**
     * 用户注册
     * @param userRegisterDTO 注册信息实体类
     * @return 注册验证回调
     */
    Result register(UserRegisterDTO userRegisterDTO);
}
