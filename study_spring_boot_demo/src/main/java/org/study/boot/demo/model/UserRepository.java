package org.study.boot.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.study.boot.demo.entity.User;

import java.util.List;

/**
 * ClassName: UserDao
 * Description: 数据访问层
 * Date:     2019/3/20 15:25
 * History:
 * <version> 1.0
 * @author lin
 */
public interface UserRepository extends JpaRepository<User,Long> {

     /**
      * 根据ID查询
      * @Description 根据ID查询
      * @param id
      * @return com.boot.demo.entity.User
      * @author lin
      * @Date 15:42 2019/3/20
      **/
     @Query(value = "select u from User u where u.id=:id")
     User findById(@Param("id") int id);

     /**
      * 根据姓名查询
      * @Description 根据姓名查询
      * @param name
      * @return java.util.List<com.boot.demo.entity.User>
      * @author lin
      * @Date 15:43 2019/3/20
      **/
     @Query(value ="select u from User u where u.name=:name")
     List<User> findByName(@Param(value = "name") String name);

     /**
      * 添加用户
      * @Description 添加用户
      * @param name
      * @param age
      *
      * @return com.boot.demo.entity.User
      * @author lin
      * @Date 16:40 2019/3/20
      **/
     @Modifying
     @Query(value = "insert into c_user(name,age) values(?1,?2)",nativeQuery = true)
     int saveUser(String name, Integer age);


     /**修改
      * @Description 修改
      * @param id
      * @param name
      * @param age
      * @return com.boot.demo.entity.User
      * @exception   
      * @author lin
      * @Date 11:43 2019/3/21
      **/
     @Modifying
     @Query(value = "update  User u set u.name=?2 , u.age=?3 where u.id=?1")
     int update(Integer id, String name, Integer age);

     /**
      * 删除（使用原生sql）
      * @Description 删除（使用原生sql）
      * @param id
      * @return void
      * @exception   
      * @author lin
      * @Date 11:50 2019/3/21
      **/
     @Modifying
     @Query(value = "delete from c_user  WHERE id=?1",nativeQuery = true)
     void deleteById(Integer id);
}
