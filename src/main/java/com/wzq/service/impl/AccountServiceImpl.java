package com.wzq.service.impl;

import com.wzq.dao.IAccountdao;
import com.wzq.domain.Account;
import com.wzq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private IAccountdao iaccountdao;

    @Override
    public List<Account> findAll() {
        System.err.println("findAll");
        return iaccountdao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        iaccountdao.saveAccount(account);
    }
}
