/*
 Navicat Premium Data Transfer

 Source Server         : mysql7
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : permission-management

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 25/06/2019 20:51:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pid` int(11) NOT NULL COMMENT '上级机构ID，一级机构为0',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_update_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1639 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名',
  `pid` int(11) NOT NULL COMMENT '父菜单ID，一级菜单为0',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单对应的url',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单对应图标',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `del_flag` int(11) NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '根节点', 0, NULL, 'layui-icon layui-icon-tree', 0, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (2, '系统管理', 1, NULL, 'layui-icon layui-icon-set', 0, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (3, '用户管理', 2, '/sys/user', 'layui-icon layui-icon-username', 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (4, '角色管理', 2, '/sys/role', 'layui-icon layui-icon-user', 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (5, '权限管理', 2, '/sys/permission', 'layui-icon layui-icon-ok-circle', 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (6, '部门管理', 2, '/sys/dept', 'layui-icon layui-icon-component', 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (7, '系统日志', 2, '/sys/log', 'layui-icon layui-icon-tabs', 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (8, '测试目录', 1, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (9, '测试菜单1', 8, '/test01', 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (10, '测试菜单2', 8, '/test02', 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (11, '测试菜单3', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (20, '测试菜单4', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (21, '测试菜单5', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (22, '测试菜单6', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (23, '测试菜单7', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (24, '测试菜单8', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (25, '测试菜单9', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (26, '测试菜单10', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (27, '测试菜单11', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (28, '测试菜单12', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (29, '测试菜单13', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (30, '测试菜单14', 8, NULL, 'layui-icon layui-icon-diamond', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (37, '测试菜单100', 8, '/test100', 'layui-icon layui-icon-rate', 1, NULL, 1, '这是测试菜单100', 'admin', '2019-06-23 18:21:14', 'admin', '2019-06-23 18:21:14');
INSERT INTO `sys_permission` VALUES (38, '测试目录02', 1, '', 'layui-icon layui-icon-rate', 0, 0, NULL, '测试目录02', 'admin', '2019-06-23 18:26:43', 'admin', '2019-06-23 18:26:43');
INSERT INTO `sys_permission` VALUES (40, '测试菜单200', 8, '/test200', 'layui-icon layui-icon-rate-solid', 1, 0, 2, '测试菜单200', 'admin', '2019-06-23 18:31:32', 'admin', '2019-06-23 18:31:32');
INSERT INTO `sys_permission` VALUES (41, '测试菜单300', 8, '/test200', 'layui-icon layui-icon-cellphone', 1, 0, 1, '这是备注信息', 'admin', '2019-06-23 18:35:38', 'admin', '2019-06-23 18:35:38');
INSERT INTO `sys_permission` VALUES (42, '测试菜单999', 8, '/test999', 'layui-icon layui-icon-rate', 1, 0, 999, '9999999999999999999', 'admin', '2019-06-23 18:38:26', 'admin', '2019-06-24 09:09:45');
INSERT INTO `sys_permission` VALUES (43, '测试菜单800', 2, '/test800', 'layui-icon layui-icon-rate', 1, 0, NULL, '', 'admin', '2019-06-23 18:42:30', 'admin', '2019-06-23 18:42:30');
INSERT INTO `sys_permission` VALUES (44, '测试目录1000', 38, '/test1000', 'layui-icon layui-icon-rate', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '超级管理员', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (2, 'dev', '开发人员', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (3, 'test', '测试人员', 0, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_update_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 328 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (216, 2, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (217, 2, 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (218, 2, 3, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (219, 2, 4, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (220, 2, 5, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (221, 2, 6, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (222, 2, 7, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (223, 3, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (224, 3, 8, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (225, 3, 9, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (226, 3, 10, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (227, 3, 11, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (228, 3, 20, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (229, 3, 21, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (230, 3, 22, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (231, 3, 23, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (232, 3, 24, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (233, 3, 25, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (234, 3, 26, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (235, 3, 27, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (236, 3, 28, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (237, 3, 29, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (238, 3, 30, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (300, 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (301, 1, 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (302, 1, 3, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (303, 1, 4, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (304, 1, 5, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (305, 1, 6, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (306, 1, 7, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (307, 1, 8, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (308, 1, 9, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (309, 1, 10, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (310, 1, 11, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (311, 1, 20, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (312, 1, 21, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (313, 1, 22, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (314, 1, 23, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (315, 1, 24, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (316, 1, 25, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (317, 1, 26, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (318, 1, 27, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (319, 1, 28, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (320, 1, 29, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (321, 1, 30, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (322, 1, 37, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (323, 1, 40, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (324, 1, 41, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (325, 1, 42, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (326, 1, 38, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_permission` VALUES (327, 1, 44, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' ',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `login_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '状态 0：禁用   1：正常',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', 'root', 'B3CF1F413EF7DCE269EC4CEA96F7057F', 'admin@163.com', 'f96d8cce6f334e5a8bf3', 0, 1, '', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2, 'king', 'king', 'F346259459013614A280FA6F8CD96DB7', 'king@qq.com', '8d59e54d29ae4f7fa341', 0, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (3, 'queen', 'queen', '2DCC0ED83003175CED38AD20958C4256', 'queen@qq.om', 'fa091bdedff94c3bbf6f', 0, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (10, '张三', 'zhangsan', 'BCDF588C22D8C1BE4ACD7D572571A42C', 'zs@qq.com', '871148841d6d4061b816', 0, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (11, '李四', 'lisi', '5F7D4F1BAB16EF278588C0A871228B0D', 'lisi@qq.com', '281a80ac84a4408da2d7', 0, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (12, '王五', 'wangwu', '5535B78BBEF0F9673A59C96A8A750391', 'ww@qq.com', '7eb02a4fac1f4c79bad6', 0, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (13, '赵六', 'zhaoliu', 'CFB1676BD071ADA9393D73381D58932A', 'zl@qq.com', '333a1b53969443cf87a3', 0, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (14, '田七', 'tianqi', '0B4063DFA1B39E3E8E678851D8B0C1BD', 'tq@qq.com', '674d7c439c274b978c29', 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (15, '赵云', 'zhaoyun', 'E29E649B4112F61F440DC18C1C102185', 'zy@qq.com', 'b8703ee402bf4527b938', 0, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (16, '吕布', 'lvbu', '2386A8D652E41C8B0B0089D9D2B01C07', 'lb@qq.com', '1605ea19b968465997f6', 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (17, '关羽', 'guanyu', '664D9F1509833C9A33F5C6B205A7ECBB', 'gy@qq.com', 'c79a3cc042a6465ab698', 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (18, '张飞', 'zhangfei', '1A35B825F42F97B2352D978534511644', 'zf@qq.com', 'cf1e4e94befe43eea125', 0, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (19, '貂蝉', 'diaochan', '25935A99B681A156C529E74D3A4A202E', 'dc@qq.com', '8dba677ad29549bfa839', 0, 1, '这是备注信息', 'admin', '2019-06-25 18:31:40', 'admin', '2019-06-25 18:31:40');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (15, 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (19, 2, 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (20, 3, 3, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (21, 19, 2, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
