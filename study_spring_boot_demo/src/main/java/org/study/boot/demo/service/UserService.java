package org.study.boot.demo.service;



import org.study.boot.demo.entity.User;

import java.util.List;

/**
 * ClassName: UserService
 * Description: 接口类
 * Author:   lin
 * Date:     2019/3/20 16:23
 * History:
 * <version> 1.0
 */
public interface UserService {

    /**
     * @Description 根据ID查询
     * @param id
     * @return com.boot.demo.entity.User
     * @author lin
     * @Date 15:42 2019/3/20
     **/
    User findById(int id);
    /**
     * @Description 根据姓名查询
     * @param name
     * @return java.util.List<com.boot.demo.entity.User>
     * @author lin
     * @Date 15:43 2019/3/20
     **/
    List<User> findByName(String name);
    /**
     * @Description 添加用户
     * @param name
     * @param age
     *
     * @return int
     * @author lin
     * @Date 16:40 2019/3/20
     **/
    int saveUser(String name, Integer age);

    /**
     * @Description 查询全部
     * @return java.util.List<com.boot.demo.entity.User>
     * @author lin
     * @Date 18:55 2019/3/20
     **/
    List<User> finAll();

    /**
     * @Description 更新
     * @param id
     * @param name
     * @param age
     * @return com.boot.demo.entity.User
     * @exception   
     * @author lin
     * @Date 11:38 2019/3/21
     **/
    int update(Integer id, String name, Integer age);

    /**
     * @Description 删除
     * @param id
     * @return void
     * @exception   
     * @author lin
     * @Date 11:51 2019/3/21
     **/
    void delete(Integer id);
    /**
     * @Description 添加用户信息
     * @param user
     * @return User
     * @exception
     * @author lin
     * @Date 12:50 2019/3/21
     **/
    User addUser(User user);
}
