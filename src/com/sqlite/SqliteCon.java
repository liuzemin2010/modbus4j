package com.sqlite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import org.junit.Test;

public class SqliteCon {

    //@Test
    public static void testHelper() {
        try {
            SqliteHelper h = new SqliteHelper("modbus4j.db");
            /*h.executeUpdate("drop table if exists modbus_protocol_basic;");
            h.executeUpdate(" CREATE TABLE modbus_protocol_basic ( \n" +
                    "[id] INTEGER PRIMARY KEY autoincrement, \n" +
                    "[ip] VARCHAR (50),  \n" +
                    "[PORT] INTEGER, \n" +
                    "[time_out] INTEGER, \n" +
                    "[retries] INTEGER, \n" +
                    "[remark] VARCHAR (255), \n" +
                    "[create_time] DATETIME DEFAULT (DATETIME('now', 'localtime')), \n" +
                    "[update_time] DATETIME  \n" +
                    "); ");
            h.executeUpdate("INSERT  INTO modbus_protocol_basic(id,ip,PORT,time_out,retries,remark,create_time,update_time) VALUES (1,'192.168.31.252',8899,2000,0,NULL,'2018-11-02 10:22:00','2018-11-02 10:22:02');");

           h.executeUpdate(" CREATE TABLE modbus_business_command ( \n" +
                    "[id] INTEGER PRIMARY KEY autoincrement, \n" +
                    "[modbus_protocol_basic_id] INTEGER,  \n" +
                    "[business_code]  VARCHAR (100), \n" +
                    "[device_code] INTEGER, \n" +
                    "[register_address] INTEGER, \n" +
                    "[command_value] VARCHAR (255),\n" +
                    "[remark] VARCHAR (255),\n" +
                    "[wdms_company_id] INTEGER, \n" +
                    "[company_id] INTEGER, \n" +
                    "[create_time] DATETIME DEFAULT (DATETIME('now', 'localtime')), \n" +
                    "[update_time] DATETIME  \n" +
                    "); ");
            h.executeUpdate(" INSERT  INTO modbus_business_command(id,modbus_protocol_basic_id,business_code,device_code,register_address,command_value,remark,create_time,update_time,wdms_company_id,company_id) VALUES (1,1,'power',5,84,NULL,'开关机状态','2018-11-02 10:31:27','2018-11-02 10:31:29',NULL,NULL),(2,1,'mode',5,81,NULL,'制冷制热模式',NULL,NULL,NULL,NULL),(3,1,'fun',5,83,NULL,'空调风速',NULL,NULL,NULL,NULL),(4,1,'setTemp',5,82,NULL,'设定温度',NULL,NULL,NULL,NULL),(5,1,'nowTemp',5,264,NULL,'空调当前温度(室内温度)',NULL,NULL,NULL,NULL),(6,1,'wlock',5,85,NULL,'面板锁定标志',NULL,NULL,NULL,NULL); ");*/

            List<String> sList = h.executeQuery("select * from modbus_business_command", new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet rs, int index)
                        throws SQLException {

                    String retIp =  rs.getString("modbus_protocol_basic_id");
                    String retPort =  rs.getString("business_code");
                    String retTimeout =  rs.getString("device_code");
                    String retRetries =  rs.getString("register_address");

                    return retIp+"/"+retPort+"/"+retTimeout+"/"+retRetries;
                }
            });
            for (int i=0;i<sList.size();i++){
                System.out.println(sList.get(i));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //testHelper();
    	//插入初始指令数据
//    	testInsertOrder();
        testInsertOrder2();
    }

    public static void testInsertOrder() {
    	int start = 1;
		
		int end = 164;
		
		
        try {
            SqliteHelper h = new SqliteHelper("resources\\db\\modbus4j.db");
            
            for(int i = start;i <= end;i++ ) {
    			StringBuffer sbf = new StringBuffer();
    			
    			sbf.append("INSERT INTO modbus_business_command ( modbus_protocol_basic_id,  device_code, device_no,  command_value, remark, wdms_company_id, company_id )  ");
				sbf.append("VALUES ");
				sbf.append("	( 1,  'ovu100"+ i +"', "+ i +",  NULL, '', NULL, NULL ); ");
				h.executeUpdate(sbf.toString());
				
				/*sbf = new StringBuffer();
				sbf.append("INSERT INTO main.modbus_business_command ( modbus_protocol_basic_id,  device_code, device_no,  command_value, remark, wdms_company_id, company_id ) ");
				sbf.append("VALUES ");
				sbf.append("	( 1,  'ovu100"+ i +"', "+ i +",  NULL, '制冷制热模式', NULL, NULL ); ");
				h.executeUpdate(sbf.toString());
				
				sbf = new StringBuffer();
				sbf.append("INSERT INTO modbus_business_command ( modbus_protocol_basic_id,  device_code, device_no,  command_value, remark, wdms_company_id, company_id ) ");
				sbf.append("VALUES ");
				sbf.append("	( 1, 'ovu100"+ i +"',"+ i +",NULL, '空调风速', NULL, NULL ); ");
				h.executeUpdate(sbf.toString());
				
				sbf = new StringBuffer();
				sbf.append("INSERT INTO modbus_business_command ( modbus_protocol_basic_id,  device_code, device_no, command_value, remark, wdms_company_id, company_id ) ");
				sbf.append("VALUES ");
				sbf.append("	( 1,  'ovu100"+ i +"',"+ i +",  NULL, '设定温度', NULL, NULL ); ");
				h.executeUpdate(sbf.toString());
				
				sbf = new StringBuffer();
				sbf.append("INSERT INTO modbus_business_command ( modbus_protocol_basic_id, device_code, device_no, command_value, remark, wdms_company_id, company_id ) ");
				sbf.append("VALUES ");
				sbf.append("	( 1,  'ovu100"+ i +"',"+ i +",  NULL, '空调当前温度(室内温度)', NULL, NULL ); ");
				h.executeUpdate(sbf.toString());
				
				sbf = new StringBuffer();
				sbf.append("INSERT INTO modbus_business_command ( modbus_protocol_basic_id,  device_code, device_no,  command_value, remark, wdms_company_id, company_id ) ");
				sbf.append("VALUES ");
				sbf.append("	( 1,  'ovu100"+ i +"',"+ i +",  NULL, '面板锁定标志', NULL, NULL ); ");
				h.executeUpdate(sbf.toString());*/
    			System.out.println("-------------" + i);
            }
            

        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
        
    }

    public static void testInsertOrder2() {
        try {
            SqliteHelper h = new SqliteHelper("resources\\db\\modbus4j.db");
            String sql = "INSERT INTO modbus_protocol_basic(ip,PORT,time_out,retries) VALUES('10.7.20.252',8899,2000,3)";
            h.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}