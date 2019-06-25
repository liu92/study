package org.study.boot.datasource.mapper.test1;



import org.study.boot.datasource.entity.Bank;

import java.util.List;

/**
 * ClassName: Bank1Mapper
 * Description: 测试多数据源配置
 * Date:     2019/3/24 17:02
 * History:
 * <version> 1.0
 * @author lin
 */
public interface Bank1Mapper {
    /**
     * 查询全部
     * @Description 查询全部
     * @param
     * @return java.util.List<com.base.entity.Bank>
     * @exception
     * @author lin
     * @Date 16:09 2019/3/21
     **/
    List<Bank> getAll();

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
