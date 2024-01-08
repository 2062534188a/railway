package com.railway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.Constants.UserConstants;
import com.railway.DTO.UserRegisterDTO;
import com.railway.Utils.*;
import com.railway.VO.TicketVO;
import com.railway.VO.UserVO;
import com.railway.entity.Ticket;
import com.railway.entity.User;
import com.railway.service.UserService;
import com.railway.mapper.UserMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
* @author HH
* @description 针对表【railway_user(用户表)】的数据库操作Service实现
* @createDate 2023-12-22 18:37:04
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public Result login(String loginMsg, String password, Integer loginMethod){
        if (loginMethod==null){
            //未检测到登录标识 返回状态异常
            return Result.error(UserConstants.USER_LOGIN_STATUS_ERROR);
        }
        User user=null;
        //MD5加密
        password= MD5Util.encrypt(password);

        if (loginMethod==0){
            //用户名登录
            user = getOne(new QueryWrapper<User>().eq("user_name",loginMsg).eq("user_pwd",password));
        }else if (loginMethod==1){
            //手机号登录
            user = getOne(new QueryWrapper<User>().eq("user_phone",loginMsg).eq("user_pwd",password));
        }else if (loginMethod==2){
            //邮箱登录
            user = getOne(new QueryWrapper<User>().eq("user_mail",loginMsg).eq("user_pwd",password));

        }
        //用户不存在
        if (user==null){
            return Result.error(UserConstants.USER_NOTFOUND);
        }
        if (user.getUserPermissions()==-1||user.getUserPermissions()==-2){
            //账号被封禁或异常 不返回token
            return Result.success(UserConstants.USER_LOGIN_STATUS_ERROR);
        }
        //构建jwt令牌
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",user.getUserId());
        map.put("user_permissions",user.getUserPermissions());
        String jwt = JwtUtil.createJwt(map);
        //返回jwt令牌
        return Result.success(UserConstants.USER_LOGIN_SUCCESS,jwt);
    }

    @Override
    public Result register(UserRegisterDTO userRegisterDTO) {
            User user = new User();
            BeanUtils.copyProperties(userRegisterDTO,user);
            //对密码密进行MD5加密
            user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
            //用户ID为随机UUID
            user.setUserId(UUID.randomUUID().toString().replace("-",""));
            //设置用户年龄 生日
            String userIdNumber = user.getUserIdNumber();
            String birthday = userIdNumber.substring(6, 14);
            user.setUserAge(AgeUtil.getAgeByIdCard(birthday));
            //设置用户生日 默认为yyyy-MM-DD hh-mm-ss
            user.setUserBirthday(LocalDateTime.of(Integer.parseInt(birthday.substring(0,4)),Integer.parseInt(birthday.substring(4,6)),Integer.parseInt(birthday.substring(6)),0,0,0));
            //设置用户性别
            user.setUserSex(Integer.parseInt(userIdNumber.substring(17,18))%2);
            //设置用户IP 防止判空 获取注册IP进行注册
            user.setUserLoginIp(userRegisterDTO.getIP());
            user.setUserUpdateIp(userRegisterDTO.getIP());
            return save(user)? Result.success(UserConstants.USER_SUCCESS_REGISTER,"true"): Result.error(UserConstants.USER_ERROR_REGISTER);


    }

    @Override
    public Result queryMyUserData() {
        //获取用户ID
        String userId = ThreadLocalUtil.getUser().toString();
        //获取用户数据
        User user = getOne(new QueryWrapper<User>().eq("user_id",userId));
        UserVO userVO=new UserVO();
        //对传回数据进行封装
        BeanUtils.copyProperties(user,userVO);
        return Result.success(userVO);
    }

    @Override
    public Result queryUserData() {
        //获取用户数据
        List<User> users = list();
        if (users == null||users.size()==0) {
            return Result.success(null);

        }

        //对传回数据进行封装
        return Result.success(users);
    }

}




