package com.railway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.entity.Announcement;
import com.railway.service.AnnouncementService;
import com.railway.mapper.AnnouncementMapper;
import org.springframework.stereotype.Service;

/**
* @author HH
* @description 针对表【railway_announcement(公告表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:15
*/
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement>
    implements AnnouncementService{

}




