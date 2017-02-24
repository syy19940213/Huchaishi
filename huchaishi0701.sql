/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : huchaishi

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-07-01 07:04:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bound_account
-- ----------------------------
DROP TABLE IF EXISTS `bound_account`;
CREATE TABLE `bound_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `bound_account` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `bound_accountcredit` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `bound_accountstatus` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for bound_store
-- ----------------------------
DROP TABLE IF EXISTS `bound_store`;
CREATE TABLE `bound_store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `bound_storename` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `bound_storepicture` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `bound_status` int(255) DEFAULT NULL COMMENT '1 未审核 2通过审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_type` int(11) DEFAULT NULL COMMENT '1:淘宝任务 2：流量任务 3互助销量 4互助流量',
  `task_shop_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `task_goods_pictur` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `task_require_pictur` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `task_goods_price` decimal(20,1) DEFAULT NULL,
  `task_phone_or_pc` int(11) DEFAULT NULL COMMENT '1电脑单  2手机单',
  `task_credit` int(11) DEFAULT NULL,
  `task_num` int(11) DEFAULT NULL,
  `task_sendtime` int(11) DEFAULT NULL,
  `task_reward` decimal(20,1) DEFAULT NULL,
  `task_send_timestamp` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `task_ismprice` int(11) DEFAULT NULL,
  `task_send_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `task_get_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `task_stauts` int(11) DEFAULT NULL COMMENT '1:发布 2：任务进行中 3：待审核  4完成任务',
  `task_user_account` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for task_base
-- ----------------------------
DROP TABLE IF EXISTS `task_base`;
CREATE TABLE `task_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_num` int(11) DEFAULT NULL,
  `task_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `task_commission` decimal(20,1) DEFAULT NULL COMMENT '佣金',
  `task_consume` decimal(20,1) DEFAULT '0.0' COMMENT '消耗',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_qq` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `real_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `card_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone_num` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `recommend_user` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gold` int(11) DEFAULT NULL,
  `task_gold` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for user_bound
-- ----------------------------
DROP TABLE IF EXISTS `user_bound`;
CREATE TABLE `user_bound` (
  `id` int(11) NOT NULL COMMENT 'unique',
  `bound_acount` varchar(255) DEFAULT NULL,
  `bound_store` varchar(255) DEFAULT NULL,
  `aconut_grade` varchar(255) DEFAULT NULL,
  `store_sign` varchar(255) DEFAULT NULL,
  `acount_sign` varchar(255) DEFAULT NULL,
  `bound_obligate` varchar(255) DEFAULT NULL,
  `store_file` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
