package com.lu.config;

import com.lu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean的声明周期:
 *      bean创建---初始化---销毁的过程
 * 容器管理bena的声明周期;
 * 我们可以自定义初始化和销毁方法;容器在bean进行到当前声明周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 构造(创建对象)
 *      单实例:在容器启动的时候创建对象
 *      多实例:在每次获取的时候创建对象
 * 初始化:
 *      对象创建完成,并赋值好,调用初始化方法...
 * 销毁:
 *      单实例:容器关闭的时候
 *      多实例:容器不会管理这个bean:容器不会调用销毁方法
 * 1.指定初始化和销毁方法
 *      在xml中  init-method  destroy-method
 *      在java文件中 通过@bean注解的 initMethod = "init",destroyMethod = "destroy"
 * 2.通过让bean实现InitializingBean(定义初始化逻辑)
 *               DisposableBean(定义销毁逻辑)
 *
 *
 * @author 小卢
 */
@ComponentScan("com.lu.bean")
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
