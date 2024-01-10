package com.railway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.DTO.TrainRouteDTO;
import com.railway.Utils.Result;
import com.railway.VO.RouteVO;
import com.railway.entity.Route;
import com.railway.service.RouteService;
import com.railway.mapper.RouteMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public Result queryTrainByRoute(TrainRouteDTO trainRouteDTO) {
        List<Route> routes = list(new QueryWrapper<Route>().eq("train_Stops", trainRouteDTO.getFrom()).gt("train_issued_time", trainRouteDTO.getDate()));
        ArrayList<RouteVO> list = new ArrayList<>();
        for (Route route : routes) {
            Route one = getOne(new QueryWrapper<Route>().eq("train_num", route.getTrainNum()).eq("train_Stops", trainRouteDTO.getTo()).gt("id", route.getId()));
            if (one!=null){
                list.add(new RouteVO(one.getTrainNum(),route.getTrainStops(),one.getTrainStops(),route.getTrainIssuedTime(),route.getTrainArrivalTime()));
            }
        }
        return Result.success(list);
    }
}




