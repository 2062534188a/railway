package com.railway.Controller;

import com.railway.Utils.Result;
import com.railway.service.RouteService;
import com.railway.service.TrainService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 列车数据接口
 */
@RestController
@RequestMapping("api/trainData")
public class TrainController {
    @Resource
    private TrainService trainService;
    @Resource
    private RouteService routeService;
    @PostMapping("/queryTrainType")
    public Result queryTrainType(){
        return trainService.queryTrainType();
    }
    @PostMapping("/queryTrainInformation")
    public Result queryTrainInformation(){
        return routeService.queryTrainInformation();
    }
}
