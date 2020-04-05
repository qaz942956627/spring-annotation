package com.lu.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * 自定义逻辑返回需要导入的组件
 * @author 小卢
 */
public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 导入到容器中的组件全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.lu.bean.Blue","com.lu.bean.Yellow"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
