/*
 Navicat MySQL Data Transfer

 Source Server         : ghy
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : my_blog

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 11/07/2023 21:33:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `my_article_tag`;
CREATE TABLE `my_article_tag`  (
  `article_id` bigint NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `tag_id` bigint NOT NULL DEFAULT 0 COMMENT '标签id',
  PRIMARY KEY (`article_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章标签关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_article_tag
-- ----------------------------
INSERT INTO `my_article_tag` VALUES (1, 4);
INSERT INTO `my_article_tag` VALUES (2, 1);
INSERT INTO `my_article_tag` VALUES (2, 4);
INSERT INTO `my_article_tag` VALUES (3, 4);
INSERT INTO `my_article_tag` VALUES (3, 5);

SET FOREIGN_KEY_CHECKS = 1;
