package org.study.mybatis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.study.mybatis.demo.entity.Book;
import org.study.mybatis.demo.mapper.BookMapper;

import java.util.List;

/**
 * ClassName: BookController
 * Description: 测试 注解 mybatis
 * Date:     2019/3/24 15:03
 * History:
 * <version> 1.0
 * @author lin
 */
@RequestMapping(value = "/book")
@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    /**
     * @Description 查询全部
     * @param
     * @return java.util.List<com.base.entity.Book>
     * @exception
     * @author lin
     * @Date 14:41 2019/3/24
     **/
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public List<Book> getAll(){
        List<Book> books = bookMapper.getAll();
        return  books;
    }


    /**
     * @Description  根据id获取书信息
     * @param id
     * @return com.base.entity.Book
     * @exception
     * @author lin
     * @Date 14:42 2019/3/24
     **/
    @RequestMapping(value = "getOne",method = RequestMethod.GET)
    public Book getOne(Integer id){
        Book one = bookMapper.getOne(id);
        return  one;
    }


    /**
     * @Description  添加
     * @param book
     * @return int
     * @exception
     * @author lin
     * @Date 14:48 2019/3/24
     **/
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void insert(@RequestBody Book book){
         bookMapper.insert(book);
    }

    /**
     * @Description 更新
     * @param book
     * @return void
     * @exception
     * @author lin
     * @Date 14:54 2019/3/24
     **/
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public  void update(@RequestBody Book book){
       bookMapper.update(book);
    }


    /**
     * @Description  删除
     * @param id
     * @return void
     * @exception
     * @author lin
     * @Date 14:56 2019/3/24
     **/
    @RequestMapping(value ="delete")
    public void delete(Integer id){
      bookMapper.delete(id);
    }
}
