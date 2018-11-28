/*
 Navicat SQLite Data Transfer

 Source Server         : modbus4j-db
 Source Server Type    : SQLite
 Source Server Version : 3021000
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3021000
 File Encoding         : 65001

 Date: 05/11/2018 09:32:46
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for modbus_business_command
-- ----------------------------
DROP TABLE IF EXISTS "modbus_business_command";
CREATE TABLE "modbus_business_command" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "modbus_protocol_basic_id" INTEGER,
  "business_code" VARCHAR (100),
  "device_code" INTEGER,
  "register_address" INTEGER,
  "command_value" VARCHAR (255),
  "remark" VARCHAR (255),
  "wdms_company_id" INTEGER,
  "company_id" INTEGER
);

-- ----------------------------
-- Records of modbus_business_command
-- ----------------------------
INSERT INTO "modbus_business_command" VALUES (1, 1, 'power', 5, 84, NULL, '开关机状态', NULL, NULL);
INSERT INTO "modbus_business_command" VALUES (2, 1, 'mode', 5, 81, NULL, '制冷制热模式', NULL, NULL);
INSERT INTO "modbus_business_command" VALUES (3, 1, 'fun', 5, 83, NULL, '空调风速', NULL, NULL);
INSERT INTO "modbus_business_command" VALUES (4, 1, 'setTemp', 5, 82, NULL, '设定温度', NULL, NULL);
INSERT INTO "modbus_business_command" VALUES (5, 1, 'nowTemp', 5, 264, NULL, '空调当前温度(室内温度)', NULL, NULL);
INSERT INTO "modbus_business_command" VALUES (6, 1, 'wlock', 5, 85, NULL, '面板锁定标志', NULL, NULL);

-- ----------------------------
-- Auto increment value for modbus_business_command
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 6 WHERE name = 'modbus_business_command';

PRAGMA foreign_keys = true;
