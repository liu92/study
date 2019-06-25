package org.study.mybatis.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: Bank
 * Description: 实体类
 * Date:     2019/3/21 15:50
 * History:
 * <version> 1.0
 * @author lin
 */
@Data
public class Bank {

    private Integer id;

    private String code;

    private String name;

    private Date createTime;


}
