package com.railway.mapper;

import com.railway.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author HH
* @description 针对表【railway_user(用户表)】的数据库操作Mapper
* @createDate 2023-12-22 18:37:04
* @Entity com.railway.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




