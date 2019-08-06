package org.study.boot.threademo;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Myrunable
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/8/5 11:06
 **/
public class Myrunable implements Runnable {

    private int map = 0;
    public Myrunable(int map){
        this.map=map;
    }

    public Myrunable(Integer put) {
    }

    @Override
    public void run() {
        try {
//            for (int i = 0; i < 50000; i++) {
                // 休眠100ms
                Thread.sleep(100);
                System.out.println("当前线程================="+Thread.currentThread().getName());
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
