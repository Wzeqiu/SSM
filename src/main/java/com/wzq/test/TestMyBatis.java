package com.wzq.test;

import com.wzq.dao.IAccountdao;
import com.wzq.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void run1() throws IOException {
        Account account = new Account();
        account.setName("张三");
        account.setMoney(1000.0);

        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        IAccountdao accountdao = sqlSession.getMapper(IAccountdao.class);
        accountdao.saveAccount(account);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void run2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IAccountdao accountdao = sqlSession.getMapper(IAccountdao.class);

        List<Account> accounts = accountdao.findAll();

        for (Account account : accounts) {
            System.out.println(account);
        }

        sqlSession.close();
        inputStream.close();

    }
}
