package com.railway.mapper;

import com.railway.entity.Seat;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author HH
* @description 针对表【railway_seat(列车座位表)】的数据库操作Mapper
* @createDate 2023-12-28 18:37:15
* @Entity com.railway.entity.Seat
*/
@Mapper
public interface SeatMapper extends BaseMapper<Seat> {

}




