package com.railway.mapper;

import com.railway.entity.Train;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author HH
* @description 针对表【railway_train(列车信息表)】的数据库操作Mapper
* @createDate 2023-12-28 18:37:16
* @Entity com.railway.entity.Train
*/
@Mapper
public interface TrainMapper extends BaseMapper<Train> {

}




