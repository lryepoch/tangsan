/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : minipro

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2021-06-12 11:14:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('1', '而尴尬的个', '112', '2021-06-12 11:02:27', '2021-06-26 11:02:30');
INSERT INTO `area` VALUES ('2', 'demoData', '1', '2021-06-12 03:13:45', '2021-06-12 03:13:46');
INSERT INTO `area` VALUES ('3', 'demoData', '1987', '2021-06-12 03:14:38', '2021-06-12 03:14:38');
