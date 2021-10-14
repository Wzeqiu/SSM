package com.wzq.test;

import com.wzq.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();
    }
}
