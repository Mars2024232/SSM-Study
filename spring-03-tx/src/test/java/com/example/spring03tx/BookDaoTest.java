package com.example.spring03tx;

import com.example.spring03tx.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    BookDao bookDao;
    @Test
void testquery(){
        BigDecimal bookPrice = bookDao.getBookPrice(1);
        System.out.println("bookPrice = " + bookPrice);
    }

}
