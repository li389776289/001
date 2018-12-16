package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountDao {
    //查询所有账户
    @Select("select * from account")
    List<Account> findAll();
    //保存账户信息
    @Insert("insert into account (name,money) values (#{name},#{money})")
    void saveAccount(Account account);
    //根据id删除账户信息
    @Delete("delete  from account where id = #{id}")
    void  delectAccount(Integer id);
    //更新账户信息

    Account updateAccount();
}
