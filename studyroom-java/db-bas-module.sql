-- 基础数据模块表结构

USE `study-room`;

-- 修改用户表，添加 status 字段
ALTER TABLE `tb_user` ADD COLUMN `status` INT DEFAULT 1 COMMENT '状态 0:禁用 1:正常' AFTER `openid`;

-- 公告表
DROP TABLE IF EXISTS `bas_notice`;
CREATE TABLE `bas_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `title` varchar(200) DEFAULT NULL COMMENT '公告标题',
  `content` text COMMENT '公告内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(11) DEFAULT '1' COMMENT '状态 0:隐藏 1:显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公告表';

-- 楼层表
DROP TABLE IF EXISTS `bas_floor`;
CREATE TABLE `bas_floor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '楼层ID',
  `floor_name` varchar(50) DEFAULT NULL COMMENT '楼层名称',
  `floor_num` int(11) DEFAULT NULL COMMENT '楼层号',
  `status` int(11) DEFAULT '1' COMMENT '状态 0:禁用 1:启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼层表';

-- 自习室表
DROP TABLE IF EXISTS `bas_study_room`;
CREATE TABLE `bas_study_room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自习室ID',
  `room_name` varchar(100) DEFAULT NULL COMMENT '自习室名称',
  `floor_id` bigint(20) DEFAULT NULL COMMENT '楼层ID',
  `capacity` int(11) DEFAULT NULL COMMENT '容量',
  `status` int(11) DEFAULT '1' COMMENT '状态 0:禁用 1:启用',
  PRIMARY KEY (`id`),
  KEY `idx_floor_id` (`floor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='自习室表';

-- 座位表
DROP TABLE IF EXISTS `bas_seat`;
CREATE TABLE `bas_seat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '座位ID',
  `seat_num` varchar(50) DEFAULT NULL COMMENT '座位号',
  `room_id` bigint(20) DEFAULT NULL COMMENT '自习室ID',
  `status` int(11) DEFAULT '1' COMMENT '状态 0:不可用 1:可用 2:已预约',
  PRIMARY KEY (`id`),
  KEY `idx_room_id` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='座位表';

-- 预约表
DROP TABLE IF EXISTS `bas_appointment`;
CREATE TABLE `bas_appointment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '预约ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `seat_id` bigint(20) DEFAULT NULL COMMENT '座位ID',
  `appointment_date` date DEFAULT NULL COMMENT '预约日期',
  `start_time` varchar(20) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(20) DEFAULT NULL COMMENT '结束时间',
  `status` int(11) DEFAULT '1' COMMENT '状态 0:已取消 1:进行中 2:已完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_seat_id` (`seat_id`),
  KEY `idx_appointment_date` (`appointment_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='预约表';

-- 留言表
DROP TABLE IF EXISTS `bas_message`;
CREATE TABLE `bas_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '留言ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `content` text COMMENT '留言内容',
  `message_type` int(11) DEFAULT '1' COMMENT '留言类型 1:用户留言 2:系统消息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='留言表';

-- 插入测试数据

-- 插入楼层数据
INSERT INTO `bas_floor` (`floor_name`, `floor_num`, `status`) VALUES
('一楼', 1, 1),
('二楼', 2, 1),
('三楼', 3, 1),
('四楼', 4, 1),
('五楼', 5, 1);

-- 插入自习室数据
INSERT INTO `bas_study_room` (`room_name`, `floor_id`, `capacity`, `status`) VALUES
('101自习室', 1, 50, 1),
('102自习室', 1, 40, 1),
('201自习室', 2, 60, 1),
('202自习室', 2, 50, 1),
('301自习室', 3, 45, 1);

-- 插入座位数据（每个自习室10个座位示例）
INSERT INTO `bas_seat` (`seat_num`, `room_id`, `status`) VALUES
-- 101自习室
('A01', 1, 1), ('A02', 1, 1), ('A03', 1, 1), ('A04', 1, 1), ('A05', 1, 1),
('A06', 1, 1), ('A07', 1, 1), ('A08', 1, 1), ('A09', 1, 1), ('A10', 1, 1),
-- 102自习室
('B01', 2, 1), ('B02', 2, 1), ('B03', 2, 1), ('B04', 2, 1), ('B05', 2, 1),
('B06', 2, 1), ('B07', 2, 1), ('B08', 2, 1), ('B09', 2, 1), ('B10', 2, 1),
-- 201自习室
('C01', 3, 1), ('C02', 3, 1), ('C03', 3, 1), ('C04', 3, 1), ('C05', 3, 1),
('C06', 3, 1), ('C07', 3, 1), ('C08', 3, 1), ('C09', 3, 1), ('C10', 3, 1);

-- 插入公告数据
INSERT INTO `bas_notice` (`title`, `content`, `create_time`, `status`) VALUES
('欢迎使用自习室预约系统', '请各位同学文明学习，保持安静，爱护公共设施。', NOW(), 1),
('自习室开放时间调整通知', '自即日起，自习室开放时间调整为早上8:00至晚上22:00，请各位同学注意。', NOW(), 1),
('五一假期自习室开放安排', '五一假期期间，自习室正常开放，欢迎各位同学前来学习。', NOW(), 1);

