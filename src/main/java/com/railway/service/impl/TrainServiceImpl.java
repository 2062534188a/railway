package com.railway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.entity.Train;
import com.railway.service.TrainService;
import com.railway.mapper.TrainMapper;
import org.springframework.stereotype.Service;

/**
* @author HH
* @description 针对表【railway_train(列车信息表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:16
*/
@Service
public class TrainServiceImpl extends ServiceImpl<TrainMapper, Train>
    implements TrainService{

}




