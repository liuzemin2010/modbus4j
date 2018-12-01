CREATE TABLE "modbus_log" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "name" VARCHAR (100),
  "params_in" text,
  "params_out" text,
  "status" VARCHAR (10),
  "create_time" TEXT,
  "device_code" VARCHAR (200),
  "business_code" VARCHAR (100),
  "business_value" VARCHAR (100),
  "business_name" VARCHAR (100),
  "exceptions_info" TEXT
);