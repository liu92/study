package org.study.mybatis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.mybatis.demo.entity.Bank;
import org.study.mybatis.demo.mapper.BankMapper;
import org.study.mybatis.demo.vo.BankVo;

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
public class BankController {

    @Autowired
    private BankMapper bankMapper;

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
    public List<Bank> findAll(){
        List<Bank> banks = bankMapper.findAll();
        return banks;
    }

    @RequestMapping(value ="getById")
    public Bank getById(Integer id){
        Bank bank = bankMapper.getOne(id);
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
          Bank bank = new Bank();
          bank.setName(bankVo.getName());
          bank.setCode(bankVo.getCode());
          Date time;
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            time = simpleDateFormat.parse(bankVo.getCreateTime());
            bank.setCreateTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        bankMapper.insert(bank);
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
        bankMapper.update(bank);
    }


    @RequestMapping(value = "delete")
    public void delete(@PathVariable("id") Integer id){
       bankMapper.delete(id);
    }

}
