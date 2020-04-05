package com.lu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author 小卢
 */
public class WindowsCondition implements Condition {


    /**
     * ConditionContext 判断条件能使用的上下文环境
     * AnnotatedTypeMetadata 注释信息
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1.能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 2.能够获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3.获取当前环境信息
        Environment environment = context.getEnvironment();
        // 4.获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
