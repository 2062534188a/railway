package com.railway.mapper;

import com.railway.entity.Route;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author HH
* @description 针对表【railway_route(列车路线表)】的数据库操作Mapper
* @createDate 2023-12-28 18:37:15
* @Entity com.railway.entity.Route
*/
@Mapper
public interface RouteMapper extends BaseMapper<Route> {

}




