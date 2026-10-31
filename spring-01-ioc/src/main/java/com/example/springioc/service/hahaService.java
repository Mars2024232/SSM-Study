package com.example.springioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class hahaService {
    @Autowired
    private Environment environment;

    //获取操作系统的类型
    public String getOstype() {
        return environment.getProperty("os.name");
    }
}
