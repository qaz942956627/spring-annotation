package com.lu.config;

import com.lu.bean.Color;
import com.lu.bean.Person;
import com.lu.bean.Red;
import com.lu.condition.LinuxCondition;
import com.lu.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 给容器中注册组件:
 * 1.包扫描+注解(@controller等)
 * 2.@bean[导入的第三方包里面的组件]
 * 3.@import[快速给容器中导入一个组件]
 *      1.@import(要导入到容器中的组件),容器中就会自动注册这个组件,id默认是全类名
 *      2.ImportSelector:返回需要导入的组件的全类名数组
 *      3.ImportBeanDefinitionRegistrar:搜懂注册bean 到容器中
 * @author 小卢
 */
@Configuration
/**
 * 导入第三方bean到spring容器中
 * @author 小卢
 */
@Import({Red.class,Color.class, MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {


    @Lazy
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public Person person() {
        System.out.println("向容器中添加bean");
        return new Person("张三", 25);
    }

    @Conditional(WindowsCondition.class)
    @Bean(value = "bill gates")
    public Person person1(){
        return new Person("bill gates", 60);
    }

    @Conditional(LinuxCondition.class)
    @Bean(value = "linus")
    public Person person2(){
        return new Person("linus", 50);
    }
}
