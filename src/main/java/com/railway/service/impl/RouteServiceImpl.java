package com.railway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.Utils.Result;
import com.railway.entity.Route;
import com.railway.service.RouteService;
import com.railway.mapper.RouteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author HH
* @description 针对表【railway_route(列车路线表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:15
*/
@Service
public class RouteServiceImpl extends ServiceImpl<RouteMapper, Route>
    implements RouteService{

    @Override
    public Result queryTrainInformation() {
        List<Route> routes = list();

        return Result.success(routes);
    }
}




