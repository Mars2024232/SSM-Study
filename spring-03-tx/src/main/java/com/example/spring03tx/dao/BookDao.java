package com.example.spring03tx.dao;

import com.example.spring03tx.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/*
* 按照id查询图书
* */
@Component
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //查询图书
    @Transactional

    public Book getBookbyId(Integer id){
        String sql="select * from book where id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
        return book;
    }
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public BigDecimal getBookPrice(Integer id){
        String sql="select price from book where id=?";
        return jdbcTemplate.queryForObject(sql, BigDecimal.class, id);

    }
    //增加图书
    @Transactional
    public void addBook(Book book){
        String sql="insert into book(bookName,price,stock) value(?,?,?)";
        jdbcTemplate.update(sql,book.getBookName(),book.getPrice(),book.getStock());
    }
    //按照id修改图书 number:要减的数量
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateBookStock(Integer bookId,Integer number){
        String sql="update book set stock=stock-? where id=?";
        jdbcTemplate.update(sql,number,bookId);
    }
    //按照id删除图书
    @Transactional
    public void deleteBook(Integer id){
        String sql="delete from book where id=?";
        jdbcTemplate.update(sql,id);
    }
}
