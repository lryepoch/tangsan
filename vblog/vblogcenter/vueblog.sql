/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : vueblog

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2021-01-15 10:14:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `html_content` text COMMENT '网页内容',
  `summary` text COMMENT '概要',
  `c_id` int(11) DEFAULT NULL COMMENT '分类id',
  `u_id` int(11) DEFAULT NULL COMMENT '作者id',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `edit_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `state` int(11) DEFAULT NULL COMMENT '0表示草稿箱，1表示已发表，2表示已删除',
  `page_view` int(11) DEFAULT '0' COMMENT '浏览数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', 'aaaaaaa', 'bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\nccccccccccccccccccccccccccccccc', '<p>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb<br />\nccccccccccccccccccccccccccccccc</p>\n', 'bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\ncccccccccccccccccc', '4', '1', '2021-01-15 09:26:06', '2021-01-15 09:26:06', '1', '10');
INSERT INTO `t_article` VALUES ('2', 'mybatis-plus update更新操作的三种方式', '1.@ 根据id更新\nUser user = new User();\nuser.setUserId(1);\nuser.setAge(29);\n userMapper.updateById(user);\n1\n2\n3\n4\n2.@ 条件构造器作为参数进行更新\n//把名字为rhb的用户年龄更新为18，其他属性不变\nUpdateWrapper<User> updateWrapper = new UpdateWrapper<>();\nupdateWrapper.eq(\"name\",\"rhb\");\nUser user = new User();\nuser.setAge(18);\nuserMapper.update(user, updateWrapper);\n1\n2\n3\n4\n5\n6\n@ 假设只更新一个字段在使用updateWrapper 的构造器中也需要构造一个实体对象,这样比较麻烦。可以使用updateWrapper的set方法\n//只更新一个属性，把名字为rhb的用户年龄更新为18，其他属性不变\nUpdateWrapper<User> updateWrapper = new UpdateWrapper<>();\nupdateWrapper.eq(\"name\",\"rhb\").set(\"age\", 18);\nuserMapper.update(null, updateWrapper);\n1\n2\n3\n4\n3.@ lambda构造器\nLambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();\nlambdaUpdateWrapper.eq(User::getName, \"rhb\").set(User::getAge, 18);\nInteger rows = userMapper.update(null, lambdaUpdateWrapper);', '<p>1.@ 根据id更新<br />\nUser user = new User();<br />\nuser.setUserId(1);<br />\nuser.setAge(29);<br />\nuserMapper.updateById(user);<br />\n1<br />\n2<br />\n3<br />\n4<br />\n2.@ 条件构造器作为参数进行更新<br />\n//把名字为rhb的用户年龄更新为18，其他属性不变<br />\nUpdateWrapper<User> updateWrapper = new UpdateWrapper&lt;&gt;();<br />\nupdateWrapper.eq(“name”,“rhb”);<br />\nUser user = new User();<br />\nuser.setAge(18);<br />\nuserMapper.update(user, updateWrapper);<br />\n1<br />\n2<br />\n3<br />\n4<br />\n5<br />\n6<br />\n@ 假设只更新一个字段在使用updateWrapper 的构造器中也需要构造一个实体对象,这样比较麻烦。可以使用updateWrapper的set方法<br />\n//只更新一个属性，把名字为rhb的用户年龄更新为18，其他属性不变<br />\nUpdateWrapper<User> updateWrapper = new UpdateWrapper&lt;&gt;();<br />\nupdateWrapper.eq(“name”,“rhb”).set(“age”, 18);<br />\nuserMapper.update(null, updateWrapper);<br />\n1<br />\n2<br />\n3<br />\n4<br />\n3.@ lambda构造器<br />\nLambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper&lt;&gt;();<br />\nlambdaUpdateWrapper.eq(User::getName, “rhb”).set(User::getAge, 18);<br />\nInteger rows = userMapper.update(null, lambdaUpdateWrapper);</p>\n', '1.@ 根据id更新\nUser user = new User();\nuser.setUserId(', '6', '2', '2021-01-15 08:57:26', '2021-01-15 08:57:26', '1', '3');
INSERT INTO `t_article` VALUES ('3', 'gggggggg', 'fffffffffffffffffffff', '<p>fffffffffffffffffffff</p>\n', 'fffffffffffffffffffff\n', '4', '1', null, '2021-01-15 09:28:56', '0', '0');
INSERT INTO `t_article` VALUES ('4', 'gggggggg', 'fffffffffffffffffffff', '<p>fffffffffffffffffffff</p>\n', 'fffffffffffffffffffff\n', '4', '1', '2021-01-15 09:29:00', '2021-01-15 09:29:00', '1', '0');
INSERT INTO `t_article` VALUES ('5', 'gggggggg', 'fffffffffffffffffffff', '<p>fffffffffffffffffffff</p>\n', 'fffffffffffffffffffff\n', '6', '1', '2021-01-15 10:06:40', '2021-01-15 10:06:40', '1', '2');
INSERT INTO `t_article` VALUES ('6', 'gggggggg', 'fffffffffffffffffffff', '<p>fffffffffffffffffffff</p>\n', 'fffffffffffffffffffff\n', '4', '1', '2021-01-15 09:30:43', '2021-01-15 09:30:43', '1', '0');
INSERT INTO `t_article` VALUES ('7', 'wwww', 'qqqqqqqqqqqqqqqq', '<p>qqqqqqqqqqqqqqqq</p>\n', 'qqqqqqqqqqqqqqqq\n', '4', '1', null, '2021-01-15 09:57:16', '0', '0');
INSERT INTO `t_article` VALUES ('8', 'qqqqqqq', 'wwwwwwwwwwwwwwwww', '<p>wwwwwwwwwwwwwwwww</p>\n', 'wwwwwwwwwwwwwwwww\n', '4', '1', '2021-01-15 10:06:20', '2021-01-15 10:06:20', '1', '1');
INSERT INTO `t_article` VALUES ('9', 'wwwwww', 'aaaaaaaaaaaaaaa', '<p>aaaaaaaaaaaaaaa</p>\n', 'aaaaaaaaaaaaaaa\n', '4', '1', '2021-01-15 10:05:43', '2021-01-15 10:05:43', '1', '2');
INSERT INTO `t_article` VALUES ('10', '买书', '\n![微信图片_20210115101012.jpg](http://localhost:8081/blogimg/20210115/38f80e17-d76e-4d4a-8f45-8f073f793d08_微信图片_20210115101012.jpg)', '<p><img src=\"http://localhost:8081/blogimg/20210115/38f80e17-d76e-4d4a-8f45-8f073f793d08_%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210115101012.jpg\" alt=\"微信图片_20210115101012.jpg\" /></p>\n', '\n', '8', '1', '2021-01-15 10:11:13', '2021-01-15 10:11:13', '1', '4');

-- ----------------------------
-- Table structure for t_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_article_tag`;
CREATE TABLE `t_article_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `a_id` int(11) DEFAULT NULL,
  `t_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article_tag
-- ----------------------------
INSERT INTO `t_article_tag` VALUES ('1', '9', '2');
INSERT INTO `t_article_tag` VALUES ('2', '8', '1');
INSERT INTO `t_article_tag` VALUES ('3', '8', '3');
INSERT INTO `t_article_tag` VALUES ('4', '5', '2');
INSERT INTO `t_article_tag` VALUES ('5', '5', '4');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(100) DEFAULT NULL COMMENT '专栏名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('4', 'php', '2021-01-14 17:11:29');
INSERT INTO `t_category` VALUES ('5', 'python', '2021-01-14 17:11:37');
INSERT INTO `t_category` VALUES ('6', 'java', '2021-01-14 17:11:42');
INSERT INTO `t_category` VALUES ('8', 'we', '2021-01-14 19:16:53');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text COMMENT '评论内容',
  `publish_time` datetime DEFAULT NULL COMMENT '评论时间',
  `a_id` int(11) DEFAULT NULL COMMENT '文章id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父评论id',
  `u_id` int(11) DEFAULT NULL COMMENT '评论用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_pv
-- ----------------------------
DROP TABLE IF EXISTS `t_pv`;
CREATE TABLE `t_pv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count_date` date DEFAULT NULL COMMENT '统计日期',
  `pv` int(11) DEFAULT NULL COMMENT '浏览量',
  `u_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pv
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员');
INSERT INTO `t_role` VALUES ('2', '普通用户');
INSERT INTO `t_role` VALUES ('3', '测试角色');

-- ----------------------------
-- Table structure for t_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_role_user`;
CREATE TABLE `t_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `r_id` int(11) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_user
-- ----------------------------
INSERT INTO `t_role_user` VALUES ('1', '1', '1');
INSERT INTO `t_role_user` VALUES ('2', '2', '2');
INSERT INTO `t_role_user` VALUES ('3', '3', '3');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(100) DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES ('1', '555');
INSERT INTO `t_tag` VALUES ('2', '444');
INSERT INTO `t_tag` VALUES ('3', '555');
INSERT INTO `t_tag` VALUES ('4', '444');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(200) DEFAULT NULL COMMENT '昵称',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `userface` varchar(200) DEFAULT NULL COMMENT '头像',
  `register_time` datetime DEFAULT NULL COMMENT '创建时间',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '当前状态（1：启用；0：禁用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'sang', '江南一点雨', '202cb962ac59075b964b07152d234b70', 'sang123@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-21 13:30:29', '1');
INSERT INTO `t_user` VALUES ('2', 'linghu', '令狐葱', '202cb962ac59075b964b07152d234b70', 'linghu@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920326&di=44a6fa6b597d86f475c2b15fa93008dd&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-12%2F023019564.jpg', '2017-12-08 09:30:22', '1');
INSERT INTO `t_user` VALUES ('3', 'qiaofeng', '乔峰', '202cb962ac59075b964b07152d234b70', 'qiaofeng@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2021-01-05 08:36:37', '1');
