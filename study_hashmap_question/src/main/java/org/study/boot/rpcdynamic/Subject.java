package org.study.boot.rpcdynamic;

/**
 *
 * 深入理解 RPC 之动态代理 , JDK 动态代理
 *
 * @ClassName Subject
 * @Description 深入理解 RPC 之动态代理, JDK 动态代理
 * @Author liuwanlin
 * @Date 2019/8/14 10:12
 **/
public interface Subject {

    /**
     * 实现动态代理的几种实现方案
     * jdk 动态代理
     * cglib 动态代理
     * javassist 动态代理
     * ASM 字节码
     * javassist 字节码
     */

    public void doSomething();

}
