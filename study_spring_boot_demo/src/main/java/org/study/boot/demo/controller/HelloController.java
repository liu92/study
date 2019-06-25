package org.study.boot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/6/25 16:24
 **/
@RestController
public class HelloController {
    @Value("${org.learn.boot.demo.name}")
    private String name;
    @Value("${org.learn.boot.demo.wish}")
    private String wish;


    @RequestMapping(value = "helloIndex")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return name+wish;
    }
}
