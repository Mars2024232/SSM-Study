package com.example.springioc.config;

import com.example.springioc.bean.Dog;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@ToString
@Configuration//标识这个类是一个配置类
/*第三方组件想要导入容器中,无法直接在第三方配置类上添加@Configuration
* 1.@Bean,自己new一个对象,注册给容器
* */
public class DogConfig {
    @Bean
    public Dog dog() {
        return new Dog();
    }
}
