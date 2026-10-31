package com.example.springioc.Dao;

import com.example.springioc.datasource.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class DEliveryDao {

    /*问题一"数据原有三个
    1.@Primary:dev
   效果:能不能自动切换数据源'
   1.告诉Spring,那个数据源那种情况下生效@Conditional
    * */@Autowired
    MyDataSource myDataSource;

    void saveDelivery(){
        System.out.println("保存发货信息");
    }
}
