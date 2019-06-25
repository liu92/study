package org.study.boot.datasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.boot.datasource.entity.Bank;
import org.study.boot.datasource.mapper.test1.Bank1Mapper;
import org.study.boot.datasource.mapper.test2.Bank2Mapper;
import org.study.boot.datasource.vo.BankVo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ClassName: BankController
 * Description:  mybatis  xml 测试
 * Date:     2019/3/21 16:52
 * History:
 * <version> 1.0
 * @author lin
 */
@RestController
@RequestMapping(value = "bank")
public class BankController {

    @Autowired
    private Bank1Mapper bank1Mapper;

    @Autowired
    private Bank2Mapper bank2Mapper;

    /**
     * 查询全部
     * @Description 查询全部
     * @param
     * @return java.util.List<com.base.entity.Bank>
     * @exception
     * @author lin
     * @Date 16:09 2019/3/21
     **/
    @RequestMapping(value = "getBanks")
    public List<Bank> getBanks(){
        List<Bank> banks = bank1Mapper.getAll();
        return banks;
    }

    @RequestMapping(value ="getById")
    public Bank getById(Integer id){
        Bank bank = bank2Mapper.getOne(id);
        return bank;
    }

    /**
     * 添加
     * @Description
     * @return void
     * @exception
     * @author lin
     * @Date 16:11 2019/3/21
     **/
    @RequestMapping(value = "add")
    public void save(@RequestBody BankVo bankVo){
          Bank bank2 = new Bank();
          bank2.setName(bankVo.getName());
          bank2.setCode(bankVo.getCode());
          Date time1;
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            time1 = simpleDateFormat.parse(bankVo.getCreateTime());
            bank2.setCreateTime(time1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        bank2Mapper.insert(bank2);
    }

    /**
     * 更新
     * @Description
     * @param bank
     * @return void
     * @exception
     * @author lin
     * @Date 16:11 2019/3/21
     **/
    @RequestMapping(value = "update")
    public void update(Bank bank){
        bank2Mapper.update(bank);
    }


    @RequestMapping(value = "delete")
    public void delete(@PathVariable("id") Integer id){
        bank1Mapper.delete(id);
    }

}
