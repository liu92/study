package org.study.boot.rabbitmq.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName HelloTest
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/6/25 17:14
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello(){
        helloSender.send();
    }

}
