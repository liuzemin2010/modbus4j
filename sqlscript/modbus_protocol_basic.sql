/*
 Navicat SQLite Data Transfer

 Source Server         : modbus4j-db
 Source Server Type    : SQLite
 Source Server Version : 3021000
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3021000
 File Encoding         : 65001

 Date: 05/11/2018 09:32:54
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for modbus_protocol_basic
-- ----------------------------
DROP TABLE IF EXISTS "modbus_protocol_basic";
CREATE TABLE "modbus_protocol_basic" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "ip" VARCHAR (50),
  "PORT" INTEGER,
  "time_out" INTEGER,
  "retries" INTEGER,
  "remark" VARCHAR (255)
);

-- ----------------------------
-- Records of modbus_protocol_basic
-- ----------------------------
INSERT INTO "modbus_protocol_basic" VALUES (1, '192.168.31.252', 8899, 2000, 0, NULL);

-- ----------------------------
-- Auto increment value for modbus_protocol_basic
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 1 WHERE name = 'modbus_protocol_basic';

PRAGMA foreign_keys = true;
