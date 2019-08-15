package org.study.boot.rpcdynamic;

/**
 * 实现接口
 * @ClassName RealSubject
 * @Description 实现接口
 * @Author liuwanlin
 * @Date 2019/8/14 11:11
 **/
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println(" dynamic doSomething()");
    }
}
