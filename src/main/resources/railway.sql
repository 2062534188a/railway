CREATE DATABASE IF NOT EXISTS railway CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci';

USE railway;

SET NAMES utf8mb4;

DROP TABLE IF EXISTS railway_user;
DROP TABLE IF EXISTS railway_vip;
DROP TABLE IF EXISTS railway_train;
DROP TABLE IF EXISTS railway_seat;
DROP TABLE IF EXISTS railway_route;
DROP TABLE IF EXISTS railway_ticket;
DROP TABLE IF EXISTS railway_order;
DROP TABLE IF EXISTS railway_ticket_refund;
DROP TABLE IF EXISTS railway_announcement;


-- 用户表
CREATE TABLE `railway_user`  (
        `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键Id',
        `user_id` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
        `user_name` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
        `user_pwd` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
        `user_id_name` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '真实姓名',
        `user_id_number` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '身份证号',
        `user_birthday` TIMESTAMP COMMENT '生日',
        `user_age` int(3) COMMENT '年龄',
        `user_phone` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号',
        `user_phone_state` tinyint(1) DEFAULT 1 NOT NULL COMMENT '手机号状态',# 1:正常 0:异常
        `user_mail` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '邮箱',
        `user_mail_state` tinyint(1)   COMMENT '邮箱状态',# 1:正常 0:异常
        `user_sex` tinyint(1) DEFAULT 0 NOT NULL COMMENT '性别',# 0:男 1:女
        `user_vip` tinyint(1) DEFAULT 1 NOT NULL COMMENT 'vip等级',# 1:二星会员 2:三星会员 3:四星会员 4:五星会员
        `user_vip_integral` bigint(20) DEFAULT 0 NOT NULL COMMENT 'vip积分',
        `user_type` tinyint(1) DEFAULT 0 NOT NULL COMMENT '用户类型',# 0:成人票 1:儿童 2:学生票 3:残疾军人
        `user_permissions` tinyint(1) DEFAULT 0 NOT NULL COMMENT '用户权限',# -2:账号注销/封禁 -1:状态异常  0:用户 1:管理员
        `user_login_ip` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录时IP',
        `user_update_ip` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '修改时IP',
        `user_create` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '注册时间',
        `user_update` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '修改时间' ,
        PRIMARY KEY (`id`) USING BTREE,
        UNIQUE (`user_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC COMMENT '用户表';
# 建立索引

CREATE INDEX user_name_index ON railway_user (user_name(20),user_pwd(20));

# 测试数据
INSERT INTO `railway_user` VALUES (null,'45bfb2523e3ecf578c351bbaab54c297','admin1','e00cf25ad42683b3df678c61f42c6bda','sugiyamar',020686321821298812,null,957,'(116) 621 9100',1,'rinsugiyama@outlook.com',1,0,1,3000,0,0,'251.119.37.18','2005-01-19','2023-12-01 19:38:19','2023-12-01 19:57:39');


-- vip等级表

CREATE TABLE `railway_vip`(
        `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键Id',
        `vip_level_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'vip等级名称',
        `vip_level_num` int(3) NOT NULL COMMENT 'vip等级',
        `vip_starExperienceValue` bigint(20) DEFAULT 0 NOT NULL COMMENT 'vip经验起始值',
        `vip_endExperienceValue` bigint(20) DEFAULT 0 NOT NULL COMMENT 'vip经验结束值',
        `vip_level_discount` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'vip等级对应折扣',
        PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact COMMENT 'vip等级对应表';

# 测试数据
INSERT INTO `railway_vip` VALUES (NULL,'二星级会员',2,0,49999,'0.97');
INSERT INTO `railway_vip` VALUES (NULL,'三星级会员',3,50000,149999,'0.95');
INSERT INTO `railway_vip` VALUES (NULL,'四星级会员',4,150000,249999,'0.90');
INSERT INTO `railway_vip` VALUES (NULL,'五星级会员',5,250000,999999,'0.85');

-- 列车信息表

CREATE TABLE `railway_train`
(
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键Id',
    `train_num` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE COMMENT '列车编号',
    `train_type` tinyint(1) NOT NULL COMMENT '列车类型',# 0:高铁 1:动车 2:快车(硬卧) 3:快车(软卧) 4:火车
    `train_business_seats` int(6) NOT NULL COMMENT '商务座余量',
    `train_business_seats_price` int(10) NOT NULL COMMENT '商务座票价',
    `train_superior_seats` int(6) NOT NULL COMMENT '特等座余量',
    `train_superior_seats_price` int(10) NOT NULL COMMENT '特等座票价',
    `train_first_seats` int(6) NOT NULL COMMENT '一等座余量',
    `train_first_seats_price` int(10) NOT NULL COMMENT '一等座票价',
    `train_second_seats` int(6) NOT NULL COMMENT '二等座余量',
    `train_second_seats_price` int(10) NOT NULL COMMENT '二等座票价',
    `train_state` int(1) NOT NULL COMMENT '列车状态', # 0:维修中 1:运行中 2:车辆异常
    `train_service_life` int(5) NOT NULL COMMENT '列车使用年限',
    PRIMARY KEY (`id`) USING BTREE

)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci row_format=DYNAMIC COMMENT '列车信息表';

create index user_id_index on railway_train (train_num);
-- 列车座位表

CREATE TABLE `railway_seat`
(
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键Id',
    `train_num` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL  COMMENT '列车编号',
    `carriage_number` int(3) COMMENT '车厢号',
    `carriage_type` int(3) NOT NULL COMMENT '车厢类型', #0:商务 1：特等 2：一等 3：二等
    `row_a_seat` int(3) COMMENT '已预订的A列座位',
    `row_b_seat`  int(3) COMMENT  '已预订的B列座位',
    `row_c_seat`  int(3) COMMENT  '已预订的C列座位',
    `row_d_seat`  int(3) COMMENT  '已预订的D列座位',
    `row_e_seat`  int(3) COMMENT '已预订的E列座位',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci row_format=DYNAMIC COMMENT '列车座位表';
INSERT INTO railway_seat (train_num, carriage_number,  carriage_type, row_a_seat, row_b_seat,row_c_seat,row_d_seat,row_e_seat) VALUES
                        ('T001', 1, 0, 0, 0, 0,0,0),('T001', 2, 1, 0, 0, 0,0,0),
                        ('T001', 3, 2, 0, 0, 0,0,0),('T001', 4, 2, 0, 0, 0,0,0),
                        ('T001', 5, 3, 0, 0, 0,0,0),('T001', 6, 3, 0, 0, 0,0,0),
                        ('T001', 7, 3, 0, 0, 0,0,0),('T001', 8, 3, 0, 0, 0,0,0),
                        ('T001', 9, 3, 0, 0, 0,0,0),('T001', 10,3, 0, 0, 0,0,0),
                        ('T001', 11,3, 0, 0, 0,0,0),('T001', 12,3, 0, 0, 0,0,0);


CREATE TABLE `railway_route`
(
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键Id',
    `train_num` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL  COMMENT '列车编号',
    `train_Stops` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '站点',
    `train_arrival_time` TIMESTAMP NOT NULL COMMENT '预计到达时间',
    `train_issued_time` TIMESTAMP NOT NULL COMMENT '预计出发时间',
    `train_residence_time` int(3) NOT NULL COMMENT '预计停留时间',
    `train_late` int(3) COMMENT '预计晚点',
    PRIMARY KEY (`id`) USING BTREE

)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC COMMENT '列车路线表';


INSERT INTO railway_route (train_num, train_Stops, train_arrival_time, train_issued_time, train_residence_time, train_late) VALUES
        ('T001', '站点A', '2024-01-09 08:00:00', '2024-01-09 07:45:00', 15, 5),
        ('T001', '站点B', '2024-01-09 09:30:00', '2024-01-09 09:15:00', 20, 0),
        ('T001', '站点C', '2024-01-09 11:00:00', '2024-01-09 10:45:00', 25, 10),
        ('T001', '站点D', '2024-01-09 12:30:00', '2024-01-09 12:15:00', 18, 3),
        ('T001', '站点E', '2024-01-09 14:00:00', '2024-01-09 13:45:00', 22, 8),

        ('T002', '站点A', '2024-01-09 09:00:00', '2024-01-09 08:45:00', 15, 2),
        ('T002', '站点B', '2024-01-09 10:30:00', '2024-01-09 10:15:00', 22, 0),
        ('T002', '站点C', '2024-01-09 12:00:00', '2024-01-09 11:45:00', 18, 5),
        ('T002', '站点D', '2024-01-09 13:30:00', '2024-01-09 13:15:00', 20, 0),
        ('T002', '站点E', '2024-01-09 15:00:00', '2024-01-09 14:45:00', 25, 12);

-- 车票信息表

CREATE TABLE `railway_ticket`
(
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键Id',
    `user_id` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
    `ticket_number` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '车票编号',
    `train_num` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '列车编号',
    `seating` tinyint(1) COMMENT '座席',# 0:商务座 1:特等座 2:一等座 3:二等座
    `carriage_number` int(3) COMMENT '车厢号',
    `seat_number` int(3) NOT NULL COMMENT '座位号',
    `row_seat` int(3) NOT NULL COMMENT '座位列',
    `order_status` int(5) COMMENT '车票状态', # 0:预定失败 1:预订中 2:预订成功 3:候车中 4:行驶中 5:订单结束
    `departure_point` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '发车站点',
    `target_point` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '目标站点',
    `departure_time` TIMESTAMP NOT NULL COMMENT '发车时间',
    `arrival_time` TIMESTAMP NOT NULL COMMENT '到站时间',
    `booking_date` TIMESTAMP NOT NULL COMMENT '预订日期',
    `train_late` int(3) COMMENT '预计晚点',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE (`ticket_number`)
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC COMMENT '车票信息表';

INSERT INTO railway_ticket (user_id, ticket_number, train_num, seating, carriage_number, seat_number, row_seat, order_status, departure_point, target_point, departure_time, arrival_time, booking_date, train_late)
VALUES
    ('45bfb2523e3ecf578c351bbaab54c297', 'T001001', 'T001', 0, 1, 1, 1, 2, '站点A', '站点B', '2024-01-09 08:00:00', '2024-01-09 09:30:00', '2024-01-09 07:30:00', 5),
    ('45bfb2523e3ecf578c351bbaab54c297', 'T001002', 'T001', 1, 2, 3, 2, 1, '站点B', '站点C', '2024-01-09 09:30:00', '2024-01-09 11:00:00', '2024-01-09 09:00:00', 0),
    ('45bfb2523e3ecf578c351bbaab54c297', 'T001003', 'T001', 2, 5, 8, 3, 3, '站点C', '站点D', '2024-01-09 11:00:00', '2024-01-09 12:30:00', '2024-01-09 10:30:00', 10),
    ('45bfb2523e3ecf578c351bbaab54c297', 'T001004', 'T001', 3, 8, 10, 4, 1, '站点D', '站点E', '2024-01-09 12:30:00', '2024-01-09 14:00:00', '2024-01-09 12:00:00', 3),
    ('45bfb2523e3ecf578c351bbaab54c297', 'T001005', 'T001', 0, 11, 12, 5, 2, '站点E', '站点F', '2024-01-09 14:00:00', '2024-01-09 15:30:00', '2024-01-09 13:30:00', 8),

    ('45bfb2523e3ecf578c351bbaab54c297', 'T002001', 'T002', 1, 4, 5, 1, 2, '站点A', '站点B', '2024-01-09 09:00:00', '2024-01-09 10:30:00', '2024-01-09 08:30:00', 2),
    ('45bfb2523e3ecf578c351bbaab54c297', 'T002002', 'T002', 2, 7, 9, 2, 1, '站点B', '站点C', '2024-01-09 10:30:00', '2024-01-09 12:00:00', '2024-01-09 10:00:00', 5),
    ('45bfb2523e3ecf578c351bbaab54c297', 'T002003', 'T002', 3, 10, 11, 3, 3, '站点C', '站点D', '2024-01-09 12:00:00', '2024-01-09 13:30:00', '2024-01-09 11:30:00', 0),
    ('45bfb2523e3ecf578c351bbaab54c297', 'T002004', 'T002', 0, 2, 2, 4, 1, '站点D', '站点E', '2024-01-09 13:30:00', '2024-01-09 15:00:00', '2024-01-09 13:00:00', 0),
    ('45bfb2523e3ecf578c351bbaab54c297', 'T002005', 'T002', 1, 6, 7, 5, 2, '站点E', '站点F', '2024-01-09 15:00:00', '2024-01-09 16:30:00', '2024-01-09 14:30:00', 12);

-- 订单表

CREATE TABLE `railway_order`
(
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键Id',
    `user_id` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id' ,
    `order_price` DECIMAL(20,2) COMMENT '订单金额',
    `order_sn` varchar(64) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '订单号',
    `user_id_name` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '真实姓名',
    `user_id_number` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '身份证号',
    `user_phone` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '修改时间' ,
    `close_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '结束时间' ,
    `order_status` tinyint(1) COMMENT '订单状态', # 0：未付款 1：已付款 2：已完成 3：已退款
    PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC COMMENT '订单表';

-- 车票退票信息表
CREATE TABLE `railway_ticket_refund`
(
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键Id',
    `user_id` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
    `order_id` bigint(20) UNSIGNED NOT NULL COMMENT '关联的订单Id',
    `refund_amount` DECIMAL(20,2) COMMENT '退款金额',
    `refund_reason` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '退款原因',
    `refund_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '退款申请时间',
    `refund_status` tinyint(1) COMMENT '退款状态', # 0：待审核 1：审核通过 2：审核不通过 3：已退款
    `admin_comment` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '管理员备注',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC COMMENT '车票退票信息表';

-- 通知表
CREATE TABLE `railway_announcement`
(
    `announcement_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '公告ID',
    `title` VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公告标题',
    `content` TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公告内容',
    `publish_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '发布时间',
    PRIMARY KEY (`announcement_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC COMMENT '公告表';
