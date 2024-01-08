package com.railway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.Utils.Result;
import com.railway.Utils.ThreadLocalUtil;
import com.railway.VO.UserVO;
import com.railway.VO.VipVO;
import com.railway.entity.User;
import com.railway.entity.Vip;
import com.railway.mapper.UserMapper;
import com.railway.service.VipService;
import com.railway.mapper.VipMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author HH
* @description 针对表【railway_vip(vip等级对应表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:16
*/
@Service
public class VipServiceImpl extends ServiceImpl<VipMapper, Vip>
    implements VipService{
@Resource
private UserMapper userMapper;
    @Override
    public Result queryMyVipInformation() {
        //获取用户ID
        String userId = ThreadLocalUtil.getUser().toString();
        //获取用户数据
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_id", userId));
        VipVO vipVO=new VipVO();
        //对传回数据进行封装

        BeanUtils.copyProperties(user,vipVO);
        return Result.success(vipVO);
    }
}




