package org.study.boot.demo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName: blog
 * Description: 测试
 * Date:     2019/3/20 8:56
 * History:
 * <version> 1.0
 * @author lin
 */
@Component
@Data
//@ConfigurationProperties 如果使用该注解那么 就不用在每一个字段上声明@value 注解

public class Blog {

    @Value("${org.learn.boot.demo.name}")
    private String name;

    @Value("${org.learn.boot.demo.wish}")
    private String wish;
}
