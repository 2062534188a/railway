package com.railway.Controller;

import com.railway.Utils.Result;
import com.railway.service.UserService;
import com.railway.service.VipService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户数据接口
 */
@RestController
@RequestMapping("api/queryUserData")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private VipService vipService;
    /**
     * 查询我的用户数据
     * @return 用户数据
     */
    @PostMapping("/queryMyUserData")
    public Result queryMyUserData(){
        return userService.queryMyUserData();
    }

    /**
     * 查询会员信息
     * @return 会员信息
     */
    @PostMapping("/queryMyVipInformation")
    public Result queryMyVipInformation(){
        return vipService.queryMyVipInformation();
    }
    @PostMapping("/queryUserData")
    public Result queryUserData(){
        return userService.queryUserData();
    }

}
