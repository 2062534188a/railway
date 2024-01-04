package com.railway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.entity.Vip;
import com.railway.service.VipService;
import com.railway.mapper.VipMapper;
import org.springframework.stereotype.Service;

/**
* @author HH
* @description 针对表【railway_vip(vip等级对应表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:16
*/
@Service
public class VipServiceImpl extends ServiceImpl<VipMapper, Vip>
    implements VipService{

}




