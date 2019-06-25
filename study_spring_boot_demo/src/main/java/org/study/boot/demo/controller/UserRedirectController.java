package org.study.boot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.study.boot.demo.entity.User;
import org.study.boot.demo.service.UserService;

import java.util.List;

/**
 * ClassName: UserRedirectController
 * Description: 重定向
 * Date:     2019/3/21 0:18
 * History:
 * <version> 1.0
 * @author lin
 */
@RequestMapping("/")
@Controller
public class UserRedirectController {

    @Autowired
    private UserService userService;



    @RequestMapping("/indexRedirect")
    public String index() {
        return "redirect:/list";
    }

    /**
     * 这里需要注意下，在使用@Controller 进行重定向时，有两种
     * 1，返回一个String ，然后return "redirect:/list"(重定向地址)
     * 2，使用ModelAndView，return new ModelAndView("redirect:/list");
     *
     * 注意如果使用@RestController注解，要进行重定向
     * 将一个HttpServletResponse参数添加到处理程序方法然后调用 response.sendRedirect("some-url");
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model){
        List<User> users = userService.finAll();
        model.addAttribute("users",users);
        return "user/list";
    }
    //return "user/userEdit"; 代表会直接去 resources 目录下找相关的文件。
    //return "redirect:/list"; 代表转发到对应的 Controller，这个示例就相当于删除内容之后自动调整到 list 请求，然后再输出到页面。


    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.addUser(user);
        return "redirect:/list";
    }


    @RequestMapping("/toEdit")
    public String toEdit(Model model, Integer id) {
        User user=userService.findById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(Integer id, String userName, Integer age) {
        userService.update(id, userName, age);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/list";
    }
}
