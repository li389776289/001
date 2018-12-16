package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
private AccountService accountService;
    @RequestMapping("/testfindAll")
    public String testfindAll(Model model){
        System.out.println("servlet方法执行了");
        //调用service方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    //增加用户
    @RequestMapping("/saveAccount")
    public void saveAccount(HttpServletRequest request, HttpServletResponse response ,Account account) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/testfindAll");
    }
    //根据id删除用户
    @RequestMapping("/delectAccount")
    public String delectAccount( Integer id ) throws IOException {
        System.out.println(id);
        accountService.delectAccount(id);
       return"redirect:/account/testfindAll";
/*        response.sendRedirect(request.getContextPath()+"/account/testfindAll");*/
    }
}
