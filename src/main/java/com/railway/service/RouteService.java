package com.railway.service;

import com.railway.Utils.Result;
import com.railway.entity.Route;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author HH
* @description 针对表【railway_route(列车路线表)】的数据库操作Service
* @createDate 2023-12-28 18:37:15
*/
public interface RouteService extends IService<Route> {
    /**
     * 查询列车信息接口
     * @return 列车信息实体类
     */
    Result queryTrainInformation();
}
