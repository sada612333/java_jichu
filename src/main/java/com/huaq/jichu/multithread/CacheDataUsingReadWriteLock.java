package com.huaq.jichu.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁做一个缓存对象
 */
public class CacheDataUsingReadWriteLock {

    private Map<String,Object> cache = new HashMap<>();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object get(String key){
        rwl.readLock().lock();
        try {
            Object val = cache.get(key);
            if (val == null){
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                if(cache.get(key) == null){
                    try {
                        //模拟从数据库查询数据
                        Thread.currentThread().sleep(200);
                        cache.put(key,"");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        rwl.writeLock().unlock();
                    }

                }
            }
            return cache.get(key);
        }finally {
            rwl.readLock().unlock();
        }
    }

    private Object read(String key){

        return cache.get(key);
    }

    private void write(String key,Object val){
        cache.put(key,val);
    }
}
