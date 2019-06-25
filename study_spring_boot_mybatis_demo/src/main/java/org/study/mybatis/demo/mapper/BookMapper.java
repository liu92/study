package org.study.mybatis.demo.mapper;


import org.apache.ibatis.annotations.*;
import org.study.mybatis.demo.entity.Book;

import java.util.List;

/**
 * ClassName: BookMapper
 * Description: 测试 mybatis注解配置
 * Date:     2019/3/24 14:36
 * History:
 * <version> 1.0
 * @author lin
 */
public interface BookMapper {

    /**
     * @Description 查询全部
     * @param
     * @return java.util.List<com.base.entity.Book>
     * @exception
     * @author lin
     * @Date 14:41 2019/3/24
     **/
    @Select("SELECT * FROM c_book")
    @Results({@Result(property = "bookName",column = "book_name"),
    @Result(property = "bookNumber",column = "book_number"),
    @Result(property = "publishCompany",column = "publish_company")})
    List<Book> getAll();


    /**
     * @Description  根据id获取书信息
     * @param id
     * @return com.base.entity.Book
     * @exception   
     * @author lin
     * @Date 14:42 2019/3/24
     **/
    @Select("SELECT * FROM c_book WhERE id=#{id}")
    @Results({@Result(property = "bookName",column = "book_name"),
    @Result(property = "bookNumber",column = "book_number"),
    @Result(property = "publishCompany",column = "publish_company")})
    Book getOne(Integer id);


    /**
     * @Description  添加
     * @param book
     * @return int
     * @exception   
     * @author lin
     * @Date 14:48 2019/3/24
     **/
    @Insert("INSERT INTO c_book(book_name,book_number,publish_company) " +
            "VALUES(#{bookName},#{bookNumber},#{publishCompany})")
    void insert(Book book);

    /**
     * @Description 更新
     * @param book
     * @return void
     * @exception   
     * @author lin
     * @Date 14:54 2019/3/24
     **/
    @Update("UPDATE c_book SET book_name=#{bookName}, book_number=#{bookNumber}," +
            "publish_company=#{publishCompany} WHERE id=#{id}")
    void update(Book book);


    /**
     * @Description  删除
     * @param id
     * @return void
     * @exception   
     * @author lin
     * @Date 14:56 2019/3/24
     **/
    @Delete("DELETE FROM c_book WHERE id=#{id}")
    void delete(Integer id);
}
