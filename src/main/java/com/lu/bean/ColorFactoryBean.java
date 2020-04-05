package com.lu.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author 小卢
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个Color对象,这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean->getObject");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 返回true是单实例,false是多例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
