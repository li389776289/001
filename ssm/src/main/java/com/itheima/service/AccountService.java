package com.itheima.service;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface AccountService {
    //查询所有账户
    List<Account>findAll();
    //保存账户信息
    void  saveAccount(Account account);
    //根据id删除账户信息

    void  delectAccount(Integer id);
}
