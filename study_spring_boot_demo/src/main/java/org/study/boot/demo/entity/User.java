package org.study.boot.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: User
 * Description: 实体类
 * Date:     2019/3/20 15:17
 * History:
 * <version> 1.0
 * @author lin
 */
@Data
@Entity
@Table(name = "c_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer age;

}
