package org.study.boot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.study.boot.demo.entity.User;
import org.study.boot.demo.service.UserService;

import java.util.List;

/**
 * ClassName: UserController
 * Description: 测试Restful api
 * Date:     2019/3/20 15:16
 * History:
 * <version> 1.0
 * @author lin
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "findById/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }


    @RequestMapping(value = "findByName/{name}",method = RequestMethod.GET)
    public List<User> findByName(@PathVariable("name") String name){
        return userService.findByName(name);
    }


    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    public int saveUser(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "age",required = false) Integer age){
        return userService.saveUser(name, age);
    }

    @RequestMapping(value ="findAll",method = RequestMethod.GET)
    public List<User> findAll(){
        return  userService.finAll();
    }

}
