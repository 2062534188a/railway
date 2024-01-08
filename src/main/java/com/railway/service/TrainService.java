package com.railway.service;

import com.railway.Utils.Result;
import com.railway.entity.Train;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author HH
* @description 针对表【railway_train(列车信息表)】的数据库操作Service
* @createDate 2023-12-28 18:37:16
*/
public interface TrainService extends IService<Train> {

    /**
     * 查询列车类型接口
     * @return 列车类型实体类
     */
    Result queryTrainType();
}
