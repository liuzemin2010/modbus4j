package com.net4iot.oss.infra.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import org.junit.Test;
 
/**
 *
 */
public class SnmpUtils {
	
	//@Test
	public void testGet()
	{
		String ip = "127.0.0.1";
		String community = "public";
		String oidval = "1.3.6.1.2.1.1.6.0";
		SnmpData.snmpGet(ip, community, oidval);
	}
	
	public static void main(String[] args) {
		/*String ip = "127.0.0.1";
		String community = "public";
		String targetOid = "1.3.6.1.2.1.25.4.2.1.2";
		SnmpData.snmpWalk(ip, community, targetOid);*/

        String ip = "127.0.0.1";
        String community = "public";

        String targetOid = "1.3.6.1.2.1.25.4.2.1.2";
        SnmpData.snmpWalk(ip, community, targetOid);
        //SnmpData.snmpWalk(ip, community, targetOid);

        List<String> oidList=new ArrayList<String>();
        oidList.add("1.3.6.1.2.1.25.4.2.1.2.6432");
        oidList.add("1.3.6.1.2.1.25.4.2.1.2.8796");
        oidList.add("1.3.6.1.2.1.25.4.2.1.2.8892");
        oidList.add("1.3.6.1.2.1.25.4.2.1.2.9052");
        oidList.add("1.3.6.1.2.1.25.4.2.1.2.9096");
        oidList.add("1.3.6.1.2.1.25.4.2.1.2.9296");
        oidList.add("1.3.6.1.2.1.25.4.2.1.2.9328");
        oidList.add("1.3.6.1.2.1.25.4.2.1.2.9436");
        JSONObject snmpJsonObj = SnmpData.snmpGetList(ip, community, oidList);
        System.out.println(snmpJsonObj);
		
	}
 
	public void testGetList()
	{
		String ip = "127.0.0.1";
		String community = "public";
		List<String> oidList=new ArrayList<String>();
		oidList.add("1.3.6.1.2.1.1.5.0");
		oidList.add("1.3.6.1.2.1.1.7.0");
		SnmpData.snmpGetList(ip, community, oidList);
	}
	
 
	public void testGetAsyList()
	{
		String ip = "127.0.0.1";
		String community = "public";
		List<String> oidList=new ArrayList<String>();
		oidList.add("1.3.6.1.2.1.1.5.0");
		oidList.add("1.3.6.1.2.1.1.7.0");
		SnmpData.snmpAsynGetList(ip, community, oidList);
		
		System.out.println("i am first!");
	}
	
 
	public void testWalk()
	{
		String ip = "127.0.0.1";
		String community = "public";
		String targetOid = "1.3.6.1.2.1.25.4.2.1.2";
		SnmpData.snmpWalk(ip, community, targetOid);
	}
	
 
	public void testAsyWalk()
	{
		String ip = "127.0.0.1";
		String community = "public";
 
		// 异步采集数据
		SnmpData.snmpAsynWalk(ip, community, "1.3.6.1.2.1.25.4.2.1.2");
	}
	
	//@Test
	public void testSetPDU() throws Exception
	{
		String ip = "127.0.0.1";
		String community = "public";
		
		SnmpData.setPDU(ip, community, "1.3.6.1.2.1.1.6.0");
	}
}

