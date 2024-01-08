package com.railway.service;

import com.railway.Utils.Result;
import com.railway.entity.Vip;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author HH
* @description 针对表【railway_vip(vip等级对应表)】的数据库操作Service
* @createDate 2023-12-28 18:37:16
*/
public interface VipService extends IService<Vip> {

    /**
     * 查询会员信息
     * @return 会员信息
     */
    Result queryMyVipInformation();
}
