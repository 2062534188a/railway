package com.railway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.entity.Seat;
import com.railway.service.SeatService;
import com.railway.mapper.SeatMapper;
import org.springframework.stereotype.Service;

/**
* @author HH
* @description 针对表【railway_seat(列车座位表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:15
*/
@Service
public class SeatServiceImpl extends ServiceImpl<SeatMapper, Seat>
    implements SeatService{

}




