package com.example.spring02aop.service;

import com.example.spring02aop.Annotation.MyAn;
import org.springframework.beans.factory.annotation.Qualifier;

public interface UserService {
    void save();
    void getUserHaha(int i,int j);
    void updateUser(@MyAn Object o);
}
