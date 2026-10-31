package com.example.spring03tx.service.impl;

import com.example.spring03tx.bean.Book;
import com.example.spring03tx.dao.AccountDao;
import com.example.spring03tx.dao.BookDao;
import com.example.spring03tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
/*
* 事务细节:
* 1.transationmanager:事务管理器:控制事务的获取,提交,回滚
*   底层默认使用哪个事务管理器? JdbcTransactionManager:
*   原理:
*    1. 事务管理器:JdbcTransactionManager:控制提交和回滚
 *   2.事务拦截器:TransactionInterceptor:控制何时提交和回滚
*
* 2.propagation:传播行为
*propagation.Propagation.Requires_New ()整体出问题,自己小方法不回滚
*propagation.Propagation.Required ()整体出问题,自己小方法要回滚
*
* 3.isolation:隔离级别
*  读未提交(Read Uncommitted)
*  读已提交(Read Committed)
*  可重复读(Repeattable Read )
*  串行话(Serializable)
*
* 4.timeout(timeoutTostring):超时时间 ,事务超时,秒为单位,
*   如果时间超时,自动回滚,超时时间是从方法的开始到最后一次数据库操作结束的时间
*
* 5.readonly:只读优化
*
* 6.rollbackFor:指明哪些异常需要回滚
*     异常:运行时异常(unchecked exception非受检异常),
*         编译时异常(checked  exceptions受检异常)
*
*    回滚的默认机制:运行时异常:回滚
*                编译时异常:不会滚
*            可以指定哪些异常可以回滚
*          回滚的:
*7.norollbackFor,指明哪些异常不需要回滚
* [不回滚 = 编译时异常+指定不悔滚异常]
*
*场景:用户结账,出现异常之后,金额回滚,库存不回滚
* 实现 checkout(){
* //自己的操作
* 扣减金额 //required
* 扣减库存//requires_new
* }

* @param username:用户名
*         bookId:图书ID
*         buyNumber:购买数量
* */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BookDao bookDao;
    @Autowired
    AccountDao accountDao;
    @Transactional(timeout = 3 )
    @Override
    public void checkout(String username, Integer bookId, Integer buyNum) throws IOException {
        //1.查询图书信息
        Book book = bookDao.getBookbyId(bookId);
        BigDecimal price = book.getPrice();
        //2.计算扣减额度
        BigDecimal total = new BigDecimal(buyNum).multiply(price);
        //3.扣减余额
        accountDao.updateBalanceByUsername(username,total);
        /*try {
            Thread.sleep(000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        //4.扣减库存
        bookDao.updateBookStock(bookId,buyNum);
        /*FileInputStream fileInputStream = new FileInputStream("D:\\123.txt");
        System.out.println("fileInputStream = " + fileInputStream.available());*/
        ;;
    }
}
