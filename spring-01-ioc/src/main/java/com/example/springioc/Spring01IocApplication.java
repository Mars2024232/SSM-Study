package com.example.springioc;

import com.example.springioc.config.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * 这个是主入口类,称为主程序类
 *
 * 扫描指定包下的组件,解决了组件不在主程序所在包及子包下组件无法被扫描的问题,
 * 不可以过分放大范围,内存占用和启动时间会增加。
 *
 * 默认分层注解其作用的条件是必须在SpringBoot应用的主程序所在包下,或者子包下。
 * Spring为我们提供了快速的Mvc分层注解:
 *   1.Controller 控制器
 *   2.Service 业务层
 *   3.Repository 持久层
 *   4.Component 组件
 *
 * 组件:框架的底配置
 * 配置文件:指定一些配置
 * 配置类:分类管理组件的配置,配置类也是组件,可以理解为是Java代码实现的配置文件
 *
 * 容器启动过程中就会创建好组件;单实例特性,每次获取直接从容器中获取。
 *
 * 给容器中注册一个自己的组件,容器中每个组件都有自己的名字,方法名就是组件的名字。
 */
@SpringBootApplication
public class Spring01IocApplication {

   /* public static void Test01(String[] args) {
        // 1.跑起一个spring应用,applicationContext:Sprinbg应用上下文对象; Ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("run=" + run);

        *//* 2.获取所有组件:容器中装了哪些组件,Spring启动时会有默认组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName=" + beanDefinitionName);
        } *//*

        // 4.获取容器中的组件对象,精确获取组件
        // 组件的四大特征:(名字 类型) 对象 作用域
        // 组件名字全局唯一

        // 小结
        // 1) 从容器中获取组件,如果没有这个组件,会抛出异常NoSuchBeanDefinitionException
        // 2) 组件不唯一,只要一个组件会抛出NoUniqueBeanDefinitionException
        //    按照名字只需要一个,精确获取指定对象
        // 3) 组件唯一,会返回组件对象
        Object hahaha = run.getBean("hahaha");
        System.out.println("对象=" + hahaha);

        // FactoryBean 的获取: 按名字拿到的是工厂造出来的产品(Car),不是工厂本身
        Object car = run.getBean("bydFactory");
        System.out.println("car(产品)=" + car);
        // 名字前加 & 才能拿到工厂本身
        Object factory = run.getBean("&bydFactory");
        System.out.println("factory(工厂本身)=" + factory);

        // 4.2 按照组件类型获取组件对象
        // 如果容器中这个类型的组件有多个,会抛出NoUniqueBeanDefinitionException
        Person person = run.getBean(Person.class);
        System.out.println("person=" + person);

        // 4.3 按照类型获取这个类型的所有组件
        System.out.println("person=" + run.getBeansOfType(Person.class));

        // 4.4 按照类型加名字获取组件对象
        Person person1 = run.getBean("zhangsan", Person.class);
        System.out.println("person1=" + person1);
    }*/

    /*
    public static void test02(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============ioc容器创建完成===============");
        Dog bean = ioc.getBean(Dog.class);
        System.out.println("bean=" + bean);
    }
    */

    /*
    public static void Test03(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        Usercontroller bean = ioc.getBean(Usercontroller.class);
        System.out.println("bean = " + bean);
        CoreConstants bean1 = ioc.getBean(CoreConstants.class);
        System.out.println("bean1 = " + bean1);
    }
    */

   /* public static void test04(String[] args) {
        *//* 测试自动注入
         * 1.自动装配流程
         *   1.0 有且只找到一个,直接注入,与名字无关
         *   1.1 如果找到多个,再按照名字去找,变量名就是名字
         *       1.1.1 如果找到,直接注入
         *       1.1.2 如果没有找到,会报错NoUniqueBeanDefinitionException
         *//*
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("================ioc容器创建完成==================");
        Usercontroller bean = ioc.getBean(Usercontroller.class);
        System.out.println("bean = " + bean);
    }*/

    /* 测试自动注入 */
/*    public static void test05(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("================ioc容器创建完成==================");
        Uersservice bean = ioc.getBean(Uersservice.class);
        System.out.println("bean = " + bean);
    }*/

/*    public static void test06(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("ioc容器创建完成");
        UserDao bean = run.getBean(UserDao.class);
        System.out.println("bean = " + bean);

    }*/

  /*  public static void test07(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("ioc容器创建完成");
        hahaService bean = run.getBean(hahaService.class);
        System.out.println("bean = " + bean.getOstype());

    }*/
 /* public static void test08(String[] args) throws FileNotFoundException {
      ConfigurableApplicationContext run = SpringApplication.run(Spring01IocApplication.class, args);
      run.getBean("hahaha");
      ResourceUtils.getFile("classpath:config/application.properties");
  }*/


  public static void main(String[] args) {
      //测试生命周期
      ConfigurableApplicationContext run = SpringApplication.run(Spring01IocApplication.class, args);
      System.out.println("=================ioc容器创建完成==================");
      UserConfig bean = run.getBean(UserConfig.class);
      System.out.println("bean = " + bean);
  }
}
