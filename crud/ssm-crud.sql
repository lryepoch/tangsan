/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : ssm-crud

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-01-25 20:42:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '开发部');
INSERT INTO `dept` VALUES ('2', '后勤部');
INSERT INTO `dept` VALUES ('3', '测试部');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `fk-dept-emp` (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('2', '李四', 'F', '1783510791@qq.com', '1');
INSERT INTO `emp` VALUES ('3', '王五', 'M', '1783510791@qq.com', '1');
INSERT INTO `emp` VALUES ('4', '小七', 'F', '1783510791@qq.com', '2');
INSERT INTO `emp` VALUES ('5', '小兵', 'M', '1783510791@qq.com', '1');
INSERT INTO `emp` VALUES ('6', '33', 'M', '124789@qq.com', '1');
INSERT INTO `emp` VALUES ('7', '522060', 'M', '522060@qq.com', '1');
INSERT INTO `emp` VALUES ('8', '88ce81', 'M', '88ce81@qq.com', '1');
INSERT INTO `emp` VALUES ('9', 'ea8012', 'M', 'ea8012@qq.com', '1');
INSERT INTO `emp` VALUES ('10', '85c033', 'M', '85c033@qq.com', '1');
INSERT INTO `emp` VALUES ('11', '98fa14', 'M', 'qqqqqqqqqq@qq.com', '1');
INSERT INTO `emp` VALUES ('12', 'ea4b45', 'M', 'ea4b45@qq.com', '1');
INSERT INTO `emp` VALUES ('15', 'f42e68', 'M', 'f42e68@qq.com', '1');
INSERT INTO `emp` VALUES ('16', '77d9f9', 'M', '77d9f9@qq.com', '1');
INSERT INTO `emp` VALUES ('17', '630e00', 'M', '630e00@qq.com', '1');
INSERT INTO `emp` VALUES ('18', '34d0e1', 'M', '34d0e1@qq.com', '1');
INSERT INTO `emp` VALUES ('19', '12e2f2', 'M', 'a@qq.com', '1');
INSERT INTO `emp` VALUES ('20', '864793', 'M', 'a@qq.com', '1');
INSERT INTO `emp` VALUES ('21', '025ad4', 'M', 'a@qq.com', '1');
INSERT INTO `emp` VALUES ('22', '123aaa', 'F', '1783510791@qq.com', '1');
INSERT INTO `emp` VALUES ('25', 'gfjg;l', '男', '797f@qq.com', '2');
INSERT INTO `emp` VALUES ('26', 'gfjg;l', '男', '797f@qq.com', '1');
INSERT INTO `emp` VALUES ('27', 'gfjg;l', '男', '797f@qq.com', '1');
