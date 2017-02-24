/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : huchaishi

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-06-21 20:32:14
*/

SET FOREIGN_KEY_CHECKS=0;

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
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'syy', '123456', null, null, null, null, null, null, null, null);
