package com.example.spring03tx;

import com.example.spring03tx.dao.AccountDao;
import com.example.spring03tx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionManager;

import java.io.IOException;
import java.math.BigDecimal;

@SpringBootTest
public class AccountDaoTest {
    @Autowired
    UserService userService;
   @Autowired
    AccountDao accountDao;
   @Autowired
   TransactionManager transactionManager;
   @Test
   void tm(){
       System.out.println(transactionManager);
       System.out.println(transactionManager.getClass());
   }
   void testupdate(){
        accountDao.updateBalanceByUsername("lisi",new BigDecimal(9.9));
    }
    @Test
    void testcheckout() throws IOException {
        userService.checkout("wangwu",3,4);
    }
}
