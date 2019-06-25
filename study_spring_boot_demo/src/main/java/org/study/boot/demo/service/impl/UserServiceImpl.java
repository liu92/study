package org.study.boot.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.study.boot.demo.entity.User;
import org.study.boot.demo.model.UserRepository;
import org.study.boot.demo.service.UserService;

import java.util.List;

/**
 * ClassName: UserServiceImpl
 * Description: 实现类
 * Date:     2019/3/20 16:41
 * History:
 * <version> 1.0
 * @author lin
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {RuntimeException.class})
    public int saveUser(String name, Integer age) {
        return userRepository.saveUser(name, age);
    }

    @Override
    public List<User> finAll() {
        return userRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {RuntimeException.class})
    @Override
    public int update(Integer id, String name, Integer age) {
        return userRepository.update(id,name,age);
    }

    /**
     * @param id
     * @return void
     * @throws
     * @Description 删除
     * @author lin
     * @Date 11:51 2019/3/21
     **/
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {RuntimeException.class})
    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    /**
     * @param user
     * @return int
     * @throws
     * @Description 添加用户信息
     * @author lin
     * @Date 12:50 2019/3/21
     **/
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {RuntimeException.class})
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }


}
