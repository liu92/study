package org.study.boot.listener;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.study.boot.rpcdynamic.DemoDynamic;
import org.study.boot.rpcdynamic.RealSubject;
import org.study.boot.rpcdynamic.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * springboot 启动时 进行监听
 * @ClassName MyApplicationStartedEventListener
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/7/24 16:08
 **/
@Component
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    private  static Logger logger = LoggerFactory.getLogger(MyApplicationStartedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        try {
            creat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public  static void  creat() throws Exception {
        Subject delegate = new RealSubject();
        long time = System.currentTimeMillis();
        Subject jdkProxy = createJdkDynamicProxy(delegate);
        time = System.currentTimeMillis() - time;
        logger.info("Create JDK Proxy: " + time + " ms");

        time = System.currentTimeMillis();
        Subject cglibProxy = createCglibDynamicProxy(delegate);
        time = System.currentTimeMillis() - time;
        logger.info("Create CGLIB Proxy: " + time + " ms");

        time = System.currentTimeMillis();
        Subject javassistBytecodeProxy = createJavassistDynamicProxy();
        time = System.currentTimeMillis() - time;
        logger.info("Create JavassistBytecode Proxy: " + time + " ms");

        for (int i = 0; i < 10; i++) {
            jdkProxy.doSomething();//warm
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            jdkProxy.doSomething();
        }
        logger.info("JDK Proxy invoke cost " + (System.currentTimeMillis() - start) + " ms");

        for (int i = 0; i < 10; i++) {
            cglibProxy.doSomething();//warm
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            cglibProxy.doSomething();
        }
        logger.info("CGLIB Proxy invoke cost " + (System.currentTimeMillis() - start) + " ms");

        for (int i = 0; i < 10; i++) {
            javassistBytecodeProxy.doSomething();//warm
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            javassistBytecodeProxy.doSomething();
        }
        logger.info("JavassistBytecode Proxy invoke cost " + (System.currentTimeMillis() - start) + " ms");

        Class<?> serviceClass = delegate.getClass();
        String methodName = "doSomething";
        for (int i = 0; i < 10; i++) {
            cglibProxy.doSomething();//warm
        }
        // 执行反射调用
        for (int i = 0; i < 10; i++) {//warm
            Method method = serviceClass.getMethod(methodName, new Class[]{});
            method.invoke(delegate, new Object[]{});
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Method method = serviceClass.getMethod(methodName, new Class[]{});
            method.invoke(delegate, new Object[]{});
        }
        logger.info("反射 invoke cost " + (System.currentTimeMillis() - start) + " ms");

        // 使用 CGLib 执行反射调用
        for (int i = 0; i < 10; i++) {//warm
            FastClass serviceFastClass = FastClass.create(serviceClass);
            FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, new Class[]{});
            serviceFastMethod.invoke(delegate, new Object[]{});
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            FastClass serviceFastClass = FastClass.create(serviceClass);
            FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, new Class[]{});
            serviceFastMethod.invoke(delegate, new Object[]{});
        }
        logger.info("CGLIB invoke cost " + (System.currentTimeMillis() - start) + " ms");


        /**
         *  Create JDK Proxy: 1 ms
            Create CGLIB Proxy: 32 ms
            Create JavassistBytecode Proxy: 33 ms

            JDK Proxy invoke cost 643 ms
            CGLIB Proxy invoke cost 632 ms
            JavassistBytecode Proxy invoke cost 615 ms
            反射 invoke cost 48265 ms
            CGLIB invoke cost 58982 ms
         */
    }


    /**
     * 创建 jdk 动态代理
     * @param tart
     * @return
     */
    private static Subject createJdkDynamicProxy(final Subject tart){
        Subject jdkProxy = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Subject.class}, new ProxyHandler(tart));
        return  jdkProxy;
    }

    /**
     * jdk 动态代理
     */
    private static class ProxyHandler implements InvocationHandler {

        private Object target;

        ProxyHandler(Object target){
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//           Object result = null;
            //这里就可以进行所谓的AOP编程了
//           //在调用具体函数方法前，执行功能处理
//           System.out.println("开始 操作。。。。。。。");
//           result = method.invoke(target, args);
//           System.out.println("结束操作 。。。。。。。");
            if(method.getName().equals("doSomething")){
                System.out.print("");
            }
            return null;
        }
    }


    /**
     * 创建 cglib 动态代理
     * @param tart
     * @return
     */
    private static  Subject createCglibDynamicProxy(final  Subject tart){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibInterceptor(tart));
        enhancer.setInterfaces(new Class[]{Subject.class});
        Subject cglibProxy = (Subject) enhancer.create();
        return  cglibProxy;
    }

    /**
     *
     */
    private static  class CglibInterceptor implements MethodInterceptor {
        private Object target;
        CglibInterceptor(Object target){
            this.target = target;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            if(method.getName().equals("doSomething")){
                System.out.print("");
            }
            return  null;
        }
    }


    /**
     * javassist 创建动态代理
     * @return
     * @throws Exception
     */
    private static  Subject createJavassistDynamicProxy() throws Exception {
        ClassPool classPool  = new ClassPool(true);
        CtClass ctClass = classPool.makeClass(Subject.class.getName()+"JavassistProxy");
        ctClass.addInterface(classPool.get(Subject.class.getName()));
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));
        ctClass.addMethod(CtNewMethod.make(
                "public void doSomething() { System.out.print(\"\") ; }", ctClass));
        Class<?> pc = ctClass.toClass();
        Subject bytecodeProxy = (Subject) pc.newInstance();
        return bytecodeProxy;
    }
}
