/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-02-06 14:17:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `depid` int(11) NOT NULL AUTO_INCREMENT,
  `depname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`depid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '部门1');
INSERT INTO `department` VALUES ('2', '部门2');
INSERT INTO `department` VALUES ('3', '部门3');
INSERT INTO `department` VALUES ('4', '部门4');
INSERT INTO `department` VALUES ('5', '部门5');
INSERT INTO `department` VALUES ('6', '部门6');
INSERT INTO `department` VALUES ('7', '部门7');
INSERT INTO `department` VALUES ('8', '部门8');
INSERT INTO `department` VALUES ('9', '部门9');
INSERT INTO `department` VALUES ('10', '部门10');
INSERT INTO `department` VALUES ('11', '部门11');
INSERT INTO `department` VALUES ('12', '部门12');
INSERT INTO `department` VALUES ('13', '部门13');
INSERT INTO `department` VALUES ('14', '部门14');
INSERT INTO `department` VALUES ('15', '部门15');
INSERT INTO `department` VALUES ('16', '部门16');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` char(10) DEFAULT NULL,
  `depid` int(11) DEFAULT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'aa', '18', '男', '1');
INSERT INTO `employee` VALUES ('2', 'bb', '19', '女', '2');
INSERT INTO `employee` VALUES ('3', 'cc', '20', '女', '1');
INSERT INTO `employee` VALUES ('4', 'dd', '21', '男', '2');
INSERT INTO `employee` VALUES ('5', 'cc', '20', '男', '7');
INSERT INTO `employee` VALUES ('6', 'dd', '21', '女', '6');
INSERT INTO `employee` VALUES ('7', 'ee', '23', '男', '5');
INSERT INTO `employee` VALUES ('8', 'ff', '22', '女', '3');
INSERT INTO `employee` VALUES ('9', 'gg', '21', '男', '2');
INSERT INTO `employee` VALUES ('10', 'hh', '20', '女', '2');
INSERT INTO `employee` VALUES ('11', 'ii', '17', '男', '7');
INSERT INTO `employee` VALUES ('12', 'jj', '18', '女', '6');
INSERT INTO `employee` VALUES ('13', 'kk', '19', '男', '5');
INSERT INTO `employee` VALUES ('14', 'll', '18', '男', '4');
INSERT INTO `employee` VALUES ('15', 'mm', '16', '女', '3');
INSERT INTO `employee` VALUES ('16', 'nn', '17', '男', '2');
