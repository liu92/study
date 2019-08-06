package org.study.boot.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程工程
 * @ClassName DefaultThreadFactory
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/8/5 10:59
 **/
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);

    private static ThreadGroup group;

    private final  AtomicInteger threadNumber = new AtomicInteger(1);

    private String namePrefix;

    public DefaultThreadFactory(){
        SecurityManager s = System.getSecurityManager();
        group = (s !=null ) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = "pool-"+POOL_NUMBER.getAndIncrement()+"-thread";
    }


    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group,r,namePrefix + threadNumber.getAndIncrement());
        if(t.isDaemon()){
            t.setDaemon(true);
        }
        if(t.getPriority() != Thread.NORM_PRIORITY){
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
