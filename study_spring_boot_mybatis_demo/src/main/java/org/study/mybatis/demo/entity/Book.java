package org.study.mybatis.demo.entity;

import lombok.Data;

/**
 * ClassName: Book
 * Description: 测试 mybatis 注解配置
 * Date:     2019/3/24 14:34
 * History:
 * <version> 1.0
 * @author lin
 */
@Data
public class Book {

    private int id;

    private String bookName;

    private String bookNumber;

    private String publishCompany;
}
