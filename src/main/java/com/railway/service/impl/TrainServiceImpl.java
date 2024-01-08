package com.railway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.Utils.Result;
import com.railway.Utils.ThreadLocalUtil;
import com.railway.VO.OrderVO;
import com.railway.VO.TicketVO;
import com.railway.entity.Order;
import com.railway.entity.Ticket;
import com.railway.entity.Train;
import com.railway.entity.User;
import com.railway.mapper.TicketMapper;
import com.railway.mapper.UserMapper;
import com.railway.service.TrainService;
import com.railway.mapper.TrainMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author HH
* @description 针对表【railway_train(列车信息表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:16
*/
@Service
public class TrainServiceImpl extends ServiceImpl<TrainMapper, Train>
    implements TrainService{


    @Override
    public Result queryTrainType() {
        //获取用户数据

        List<Train> trains = list();


        //对传回数据进行封装
        return Result.success(trains);
    }
}




