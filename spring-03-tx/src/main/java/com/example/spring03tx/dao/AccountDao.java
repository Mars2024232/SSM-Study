package com.example.spring03tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    /*
    * 按照username扣除账户余额
    * @param username 用户名
    *        delta    扣除的金额
    * */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateBalanceByUsername(String username, BigDecimal delta){
        String sql="update account set balance=balance-? where username=?";
        //执行sql
       jdbcTemplate.update(sql, delta, username);
    }
}
