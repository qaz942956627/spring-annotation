package com.lu.config;

import com.lu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 小卢
 */
public class MyImportBeanDefinitionRegistrar  implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类:
     *                 把所有需要添加到容器中的bean:调用
     *                 registry.registerBeanDefinition 手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean red = registry.containsBeanDefinition("com.lu.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.lu.bean.Blue");
        if (red && blue) {
            //指定bean的定义信息,(bean的类型,bean的scope等等)
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个bean指定bean名称
            registry.registerBeanDefinition("rainBow", beanDefinition);

        }
    }
}
