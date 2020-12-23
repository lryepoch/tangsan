/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : qa

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-01-03 23:34:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answers
-- ----------------------------
DROP TABLE IF EXISTS `answers`;
CREATE TABLE `answers` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `a_content` varchar(20) DEFAULT NULL COMMENT '标题',
  `a_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '提问时间',
  `q_id` int(11) DEFAULT NULL COMMENT '问题id',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answers
-- ----------------------------
INSERT INTO `answers` VALUES ('5', '球王', '2019-05-16 20:07:44', '8');
INSERT INTO `answers` VALUES ('6', '外星人', '2019-05-16 20:07:56', '8');
INSERT INTO `answers` VALUES ('7', 'NBA历史第二分卫', '2019-05-16 20:09:09', '9');
INSERT INTO `answers` VALUES ('8', '二本', '2019-05-16 20:29:04', '10');
INSERT INTO `answers` VALUES ('9', '听说不久就是一本', '2019-05-16 20:32:10', '10');
INSERT INTO `answers` VALUES ('10', '我也觉得奇怪', '2019-05-16 20:34:22', '13');
INSERT INTO `answers` VALUES ('12', '2', '2019-05-17 01:14:05', '14');
INSERT INTO `answers` VALUES ('13', '总之就是我的偶像', '2019-05-17 01:25:23', '9');
INSERT INTO `answers` VALUES ('17', '因为爱情', '2020-01-03 23:19:35', '34');

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `q_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `q_desc` varchar(20) DEFAULT NULL COMMENT '问题描述',
  `q_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '提问时间',
  `a_num` int(11) DEFAULT NULL COMMENT '回答数目',
  `label` varchar(20) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`q_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES ('8', '梅西是谁', '？？', '2019-05-16 20:07:03', null, '足球');
INSERT INTO `questions` VALUES ('9', '科比到底有多厉害', '？？？', '2019-05-16 20:08:36', null, '篮球');
INSERT INTO `questions` VALUES ('10', '广东某某大学', '是几本？？', '2019-05-16 20:28:46', null, '教育');
INSERT INTO `questions` VALUES ('11', '好烦', '大哥老是说好烦', '2019-05-16 20:32:44', null, '情绪');
INSERT INTO `questions` VALUES ('12', '宏基坏了', '开不了机是为什么', '2019-05-16 20:33:24', null, '电子产品');
INSERT INTO `questions` VALUES ('13', '为什么人会哭', '', '2019-05-16 20:34:06', null, '情绪');
INSERT INTO `questions` VALUES ('14', '1+1=?', '', '2019-05-17 01:04:00', null, '数学');
INSERT INTO `questions` VALUES ('16', '为什么？', '就是为什么？', '2020-01-03 23:10:30', null, '十万个为什么');
INSERT INTO `questions` VALUES ('34', '大学', '上大学干嘛', '2019-05-17 17:01:16', null, '教育');
