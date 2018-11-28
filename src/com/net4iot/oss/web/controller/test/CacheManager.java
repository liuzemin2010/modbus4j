package com.net4iot.oss.web.controller.test;

import com.net4iot.oss.domain.dto.ElectricityMeter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pangPython on 2017/9/25.
 */
public class CacheManager {
    private ConcurrentHashMap<String,ElectricityMeter> cacheContainer = null;
    private static volatile CacheManager m_cacheManager = null;
    private long timeout;


    public static CacheManager getInstance() {
        if(m_cacheManager == null){
            synchronized (CacheManager.class){
                if(m_cacheManager == null){
                    m_cacheManager = new CacheManager(1000*60*30);
                }
            }
        }
        return m_cacheManager;
    }

    private CacheManager(long timeout) {
        this.timeout = timeout;
        cacheContainer = new ConcurrentHashMap<>();
        CacheCleaner cacheCleanerThread = new CacheCleaner();
        cacheCleanerThread.start();
    }

    /**
     * 访问缓存
     * 每一次访问把最后访问时间改成当前时间
     *
     * @param key
     * @return
     */
    public ElectricityMeter getCache(String key){
        ElectricityMeter electricityMeter = cacheContainer.get(key);
//        if(electricityMeter!=null){
//            ElectricityMeter.setLastAccessTime(System.currentTimeMillis());
//            cacheContainer.put(key,electricityMeter);
//        }

        return electricityMeter;
    }

    /**
     * 添加缓存
     *
     * 默认最后访问时间为当前时间
     * @param key
     * @param value
     */
    public void setCache(String key,ElectricityMeter value){
        //      System.out.println("key:"+key);
//        System.out.println("value:"+value);
//        ElectricityMeter ElectricityMeter = new ElectricityMeter(key,value.getElectricityMeter());
//        ElectricityMeter.setLastAccessTime(System.currentTimeMillis());
        cacheContainer.put(key,value);
    }


    public void clearCache(String key){
        cacheContainer.remove(key);
    }

    public void clearCache(){

        for (Map.Entry<String,ElectricityMeter> entry:cacheContainer.entrySet() ) {
            String sessionID = entry.getKey();
            ElectricityMeter ElectricityMeter = entry.getValue();
//            if(System.currentTimeMillis() - ElectricityMeter.getLastAccessTime() >= timeout){
//
//            }
            cacheContainer.remove(sessionID);

        }

    }



    /**
     * 缓存定时清理线程
     *
     */
    class CacheCleaner extends Thread{

        @Override
        public void run() {
            while(true){
                /**
                 * 30分钟执行一次清理
                 *
                 */
                try {
                    Thread.sleep(1000*60*30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (Map.Entry<String,ElectricityMeter> entry:cacheContainer.entrySet() ) {
                    String sessionID = entry.getKey();
                    ElectricityMeter ElectricityMeter = entry.getValue();
//                    if(System.currentTimeMillis() - ElectricityMeter.getLastAccessTime() >= timeout){
//                        cacheContainer.remove(sessionID);
//                    }
                }



            }
        }
    }
}