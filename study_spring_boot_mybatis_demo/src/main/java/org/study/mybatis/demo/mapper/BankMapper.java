package org.study.mybatis.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.study.mybatis.demo.entity.Bank;

import java.util.List;

/**
 * ClassName: BankMapper 使用 xml的配置方式
 * Description: 测试mybatis
 * Date:     2019/3/21 16:07
 * History:
 * <version> 1.0
 * @author lin
 */
//@Mapper
public interface BankMapper {

    /**
     * 查询全部
     * @Description 查询全部
     * @param
     * @return java.util.List<com.base.entity.Bank>
     * @exception   
     * @author lin
     * @Date 16:09 2019/3/21
     **/
    List<Bank> findAll();

    /**
     * 根据id查询
     * @Description 根据id查询
     * @param id
     * @return com.base.entity.Bank
     * @exception   
     * @author lin
     * @Date 16:10 2019/3/21
     **/
    Bank getOne(Integer id);

    /**
     * 添加
     * @Description
     * @param bank
     * @return void
     * @exception   
     * @author lin
     * @Date 16:11 2019/3/21
     **/
    void insert(Bank bank);

    /**
     * 更新
     * @Description
     * @param bank
     * @return void
     * @exception   
     * @author lin
     * @Date 16:11 2019/3/21
     **/
    void update(Bank bank);

    /**
     * 删除
     * @Description
     * @param id
     * @return void
     * @exception   
     * @author lin
     * @Date 16:11 2019/3/21
     **/
    void delete(Integer id);
}
