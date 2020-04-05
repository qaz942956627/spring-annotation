package com.lu.config;

import com.lu.bean.Color;
import com.lu.bean.Person;
import com.lu.condition.LinuxCondition;
import com.lu.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author 小卢
 */
@Configuration
@Import({Color.class, MyImportSelector.class}) //导入第三方bean到spring容器中
public class MainConfig2 {

    /**
     *
     * @return
     */
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
