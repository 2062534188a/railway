package com.railway.mapper;

import com.railway.entity.Vip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author HH
* @description 针对表【railway_vip(vip等级对应表)】的数据库操作Mapper
* @createDate 2023-12-28 18:37:16
* @Entity com.railway.entity.Vip
*/
@Mapper
public interface VipMapper extends BaseMapper<Vip> {

}




