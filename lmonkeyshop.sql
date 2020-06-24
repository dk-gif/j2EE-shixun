/*
 Navicat Premium Data Transfer

 Source Server         : xxxxx
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : lmonkeyshop

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 24/06/2020 20:33:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lmonkey_category
-- ----------------------------
DROP TABLE IF EXISTS `lmonkey_category`;
CREATE TABLE `lmonkey_category`  (
  `CATE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CATE_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CATE_PARTENR_ID` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`CATE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lmonkey_category
-- ----------------------------
INSERT INTO `lmonkey_category` VALUES (1, '文科', 0);
INSERT INTO `lmonkey_category` VALUES (2, '理科', 0);
INSERT INTO `lmonkey_category` VALUES (3, '工科', 0);
INSERT INTO `lmonkey_category` VALUES (4, '医科', 0);
INSERT INTO `lmonkey_category` VALUES (5, '计算机类', 3);
INSERT INTO `lmonkey_category` VALUES (6, '临床医学类', 4);
INSERT INTO `lmonkey_category` VALUES (7, '古文类', 1);
INSERT INTO `lmonkey_category` VALUES (8, '数学类', 2);
INSERT INTO `lmonkey_category` VALUES (18, '锋利的jQuery', 5);
INSERT INTO `lmonkey_category` VALUES (19, 'Node-js基础讲解', 5);
INSERT INTO `lmonkey_category` VALUES (20, '唐诗宋词三百首', 1);

-- ----------------------------
-- Table structure for lmonkey_user
-- ----------------------------
DROP TABLE IF EXISTS `lmonkey_user`;
CREATE TABLE `lmonkey_user`  (
  `USER_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id主键',
  `USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_SEX` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_BIRTHDAY` datetime(0) NULL DEFAULT NULL,
  `USER_EMAIL` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_MOBILE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lmonkey_user
-- ----------------------------
INSERT INTO `lmonkey_user` VALUES ('0000004', '李四13', '1111111', 'F', '2020-06-17 00:00:00', 'eee@ee.com', '13458451211', '发电方式');
INSERT INTO `lmonkey_user` VALUES ('000001', '张三1', '111111', 'F', '2020-05-13 00:00:00', '1212121@rrr', '3232323', '发电方式');
INSERT INTO `lmonkey_user` VALUES ('000002', '李四', '111111', 'T', '2020-05-11 20:07:45', '12121212@qq', '23233232323', '32323233');
INSERT INTO `lmonkey_user` VALUES ('000003', '李四', '111111', 'T', '1998-05-06 00:00:00', '1101627117@qq.com', '3232', '111111111');
INSERT INTO `lmonkey_user` VALUES ('1', '张三', '1', 'T', '2020-05-15 00:00:00', '110162786465@778', '1', '1');
INSERT INTO `lmonkey_user` VALUES ('11', '327671', '111111', 'T', '2020-06-23 00:00:00', '1101627117@qq.com', '13458451211', '111111');
INSERT INTO `lmonkey_user` VALUES ('1111111', '111', '111111', 'T', '2020-06-16 00:00:00', '1101627117@qq.com', '13458451211', 'gfuguguguy');
INSERT INTO `lmonkey_user` VALUES ('121243', '啦啦啦', '111111', 'T', '2020-06-17 00:00:00', NULL, '3232323', '发电方式');
INSERT INTO `lmonkey_user` VALUES ('32323211', '张三434', '111111', 'T', '2020-06-24 00:00:00', 'eee@ee.com', '13458451211', '二恶');
INSERT INTO `lmonkey_user` VALUES ('3232323', '327671', '111111', 'T', '2020-05-15 00:00:00', '1101627117@qq.com', '33333333333', '发电方式');
INSERT INTO `lmonkey_user` VALUES ('43434', 'lll', '3223', 'T', '1998-05-06 00:00:00', '1101627117@qq.com', '3232', '2323');
INSERT INTO `lmonkey_user` VALUES ('admin', '张三332', '323', 'T', '2020-07-08 00:00:00', '1101627117@qq.com', '3232323', '32323232');
INSERT INTO `lmonkey_user` VALUES ('admin1', 'zz', '111111', 'T', '1998-08-08 00:00:00', '21211', '212121', '4343434');
INSERT INTO `lmonkey_user` VALUES ('root', 'root', '111111', 'F', '2020-06-19 21:08:07', 'xxx@163.com', '13545444545', '小烧烤');

SET FOREIGN_KEY_CHECKS = 1;
