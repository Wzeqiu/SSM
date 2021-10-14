package com.wzq.controller;

import com.wzq.domain.Account;
import com.wzq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {


    @Autowired   //按类型注入
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("Controller表现层：查询所有账户...");
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";  //在视图解析器中配置了前缀后缀
    }

    @RequestMapping("/find")
    @ResponseBody
    public List<Account> findAll() {
        System.out.println("Controller表现层：查询所有账户... find");
        List<Account> list = accountService.findAll();
        return list;  //在视图解析器中配置了前缀后缀
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Controller表现层：新增数据...");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return;
    }
}
