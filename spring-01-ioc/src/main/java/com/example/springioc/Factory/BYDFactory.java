package com.example.springioc.Factory;

import com.example.springioc.bean.Car;
import org.springframework.beans.factory.FactoryBean;

public class BYDFactory implements FactoryBean<Car> {

    //调用此方法给容器中制造对象
    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    //说明你制造的东西的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
    //说明此对象是单例的
    @Override
    public boolean isSingleton() {
        return true;
    }
}
