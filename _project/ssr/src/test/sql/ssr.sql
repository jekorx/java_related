/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : ssr

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2017-12-20 08:42:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `articles`
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `create_time` char(19) DEFAULT NULL COMMENT '创建时间',
  `modify_time` char(19) DEFAULT NULL COMMENT '修改时间',
  `img_url` varchar(255) DEFAULT NULL COMMENT '列表展示图片链接',
  `tid` int(11) DEFAULT NULL COMMENT '标签id',
  `content` text,
  `read_count` int(11) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO `articles` VALUES ('1', 'biaoti', '1', '2017-12-19 13:48:27', '2017-12-19 13:48:27', '', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('2', 'biaoti', '1', '2017-12-19 13:49:04', '2017-12-19 13:49:04', '', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('3', 'biaoti', '1', '2017-12-19 13:49:14', '2017-12-19 13:49:14', '', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('4', 'biaoti', '1', '2017-12-19 14:07:19', '2017-12-19 14:07:19', 'http://127.0.0.1/images/article/f43d911d-f285-4978-bba3-a47c23e41368.jpg', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('5', 'biaoti', '1', '2017-12-19 14:28:16', '2017-12-19 14:28:16', 'http://127.0.0.1/images/article/20697944-34ea-4514-bc3a-39c33132300f.gif', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('17', 'biaoti', '4', '2017-12-19 17:21:53', '2017-12-19 17:21:53', 'http://127.0.0.1/images/article/d653c80d-c6e7-4d69-b5d6-d1bdb72a7915.gif', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('18', 'biaoti', '5', '2017-12-19 17:21:54', '2017-12-19 17:21:54', 'http://127.0.0.1/images/article/8075ad35-5c74-49ff-9e56-d7e4649546f6.gif', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('19', 'biaoti', '6', '2017-12-19 17:21:55', '2017-12-19 17:21:55', 'http://127.0.0.1/images/article/f361c51b-15c6-4d7c-b458-bb2afb240718.gif', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('20', 'biaoti', '7', '2017-12-19 17:21:55', '2017-12-19 17:21:55', 'http://127.0.0.1/images/article/06e15e64-fd99-45d5-acf8-d655f7cde4cf.gif', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('21', 'biaoti', '8', '2017-12-19 17:21:56', '2017-12-19 17:21:56', 'http://127.0.0.1/images/article/7813e4d8-ef10-40f4-9c8a-838c45616dd4.gif', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('22', 'biaoti', '9', '2017-12-19 17:21:57', '2017-12-19 17:21:57', 'http://127.0.0.1/images/article/96f6d3af-0142-4d10-a576-9abf17ecf190.gif', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('23', 'biaoti', '10', '2017-12-19 17:21:58', '2017-12-19 17:21:58', 'http://127.0.0.1/images/article/c49098a2-d90a-4321-98f9-f513550462ae.gif', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('24', 'biaoti', '11', '2017-12-19 17:23:57', '2017-12-19 17:23:57', 'http://127.0.0.1/images/article/ecfefe1c-7112-4a9f-aadd-82d210ca3b3f.gif', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('25', 'biaoti', '12', '2017-12-19 17:23:58', '2017-12-19 17:23:58', 'http://127.0.0.1/images/article/af54228e-d211-4d16-b1ac-42dd2731e511.gif', '1', 'neirong', '0');
INSERT INTO `articles` VALUES ('26', 'biaoti', '13', '2017-12-19 17:23:59', '2017-12-19 17:23:59', 'http://127.0.0.1/images/article/775f02b6-5f27-4a1d-aa35-ac9e9039fcb3.gif', '1', 'neirong', '0');

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `comment` text,
  `time` char(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '24', 'a1', '男的');
INSERT INTO `person` VALUES ('4', '25', 'b1', '女');
INSERT INTO `person` VALUES ('19', '18', '张三2', '男');
INSERT INTO `person` VALUES ('20', '18', '张三3', '男');
INSERT INTO `person` VALUES ('21', '18', '张三4', '男');
INSERT INTO `person` VALUES ('22', '18', '张三5', '男');
INSERT INTO `person` VALUES ('23', '18', '张三6', '男');
INSERT INTO `person` VALUES ('24', '18', '张三7', '男');
INSERT INTO `person` VALUES ('25', '18', '张三8', '男');
INSERT INTO `person` VALUES ('26', '28', '张三9', '男');
INSERT INTO `person` VALUES ('27', '19', 'aa1', 'man');
INSERT INTO `person` VALUES ('28', '19', 'aa1', 'man');
INSERT INTO `person` VALUES ('29', '19', 'aa1', 'man');
INSERT INTO `person` VALUES ('30', '19', 'aa1', 'man');
INSERT INTO `person` VALUES ('31', '19', 'aa1', 'man');
INSERT INTO `person` VALUES ('32', '19', 'aa1', 'man');
INSERT INTO `person` VALUES ('33', '20', 'zhangsan', 'woman');
INSERT INTO `person` VALUES ('34', '19', 'aa1', 'man');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ulogin` varchar(100) NOT NULL,
  `upwd` varchar(100) NOT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin1', '21232F297A57A5A743894A0E4A801FC3', '1', '20');
INSERT INTO `users` VALUES ('2', 'admin2', '21232F297A57A5A743894A0E4A801FC3', '2', '21');
