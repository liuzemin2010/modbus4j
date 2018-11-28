package com.net4iot.oss.web.controller.test;

import java.util.Random;

/**
 * Created by pangPython on 2017/9/25.
 */
public class CacheTest {
    public static void main(String[] args){
        /**
         * 比较好的使用场景就是：网络请求的状态下，请求过来，
         * 直接返回，然后开启线程操作，修改结果集，供上层轮询调用，实现异步。
         *
         */
        CacheManager cacheManager = CacheManager.getInstance();
        String sessionID = "test_sessionid";
        Integer random_num = new Random().nextInt();
        System.out.println("========================"+random_num);
        MyCache myCache = new MyCache(sessionID,random_num);
        //cacheManager.setCache(sessionID,myCache);

        //休眠3秒
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //cacheManager.clearCache();
        //System.out.println("----------------------"+cacheManager.getCache(sessionID)/.getElectricityMeter().toString());




    }
}
