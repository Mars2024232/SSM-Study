package com.example.spring03tx.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserService {
    /*@param username:用户名
    *        bookId:图书ID
    *        buyNumber:购买数量
    *
    * */

    void checkout(String username, Integer bookId, Integer buyNumber) throws IOException;
}
