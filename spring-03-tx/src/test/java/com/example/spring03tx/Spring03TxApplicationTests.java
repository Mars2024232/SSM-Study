package com.example.spring03tx;

import com.example.spring03tx.bean.Book;
import com.example.spring03tx.dao.BookDao;
import com.example.spring03tx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Spring03TxApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    BookDao bookDao;
    JdbcTemplate jdbcTemplate;//就是QueryRunnner
    @Test
    void contextLoads() throws SQLException {
        //HikarDataSource:
        //DruifDataSource
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }
    @Test
    void testQuery(){
        Book bookbyId = bookDao.getBookbyId(1);
        System.out.println("bookbyId = " + bookbyId);
    }
   @Test
    void testadd(){
        Book book = new Book();
        book.setBookName("西游记");
        book.setPrice(new BigDecimal(100));
        book.setStock(100);
        bookDao.addBook(book);
    }
    @Test
    void testupdate(){
        bookDao.updateBookStock(4,2);
    }
    @Test
    void testelete(){
        bookDao.deleteBook(4);
    }

}
