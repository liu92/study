package org.study.boot.hashmapsyn;

import org.study.boot.factory.DefaultThreadFactory;
import org.study.boot.threademo.Myrunable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 模拟 hashMap 在多线程下出现死循环
 * @ClassName HashMultiThread
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/8/5 10:41
 **/
public class HashMultiThread {

    private static Map<String, Integer> map = new HashMap<>();

    public HashMultiThread() {
        Thread test1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    map.put("t1" + i, i);
                }
                System.out.println("测试hashMap 在多线程情况下出现死循环test1 over");
            }
        };

        Thread test2 = new Thread() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    map.put("t2" + i, i);
                }
                System.out.println("测试hashMap 在多线程情况下出现死循环 test2 over");
            }
        };
        test1.start();
        test2.start();

    }

    public static void main(String[] args) {
        new HashMultiThread();
    }
}
