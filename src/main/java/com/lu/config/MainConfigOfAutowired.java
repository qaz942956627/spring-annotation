package com.lu.config;

import com.lu.bean.Car;
import com.lu.bean.Color;
import com.lu.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配:
 *      spring利用依赖注入
 *
 * 1.@Autowired
 *      1.默认优先按照类型去容器中找对应的组件:context.getBean(BookDao.class);
 *      2.如果找到多个相同类型的组件,再将属性的名称作为组件的id去容器中查找
 *      3.@Qualifier("bookDao"): 使用注解指定需要装配的bean的id而不是使用属性名
 *      4.自动装配默认一定要将属性值赋值好,没有就会报错
 *              @Autowired(required=false) 这样允许不赋值
 *      5.@Primary:让spring进行自动装配的时候,默认使用首选的bean 不能使用Qualifier指定了
 *      BookService{
 *          @Autowired
 *          BookDao bookDao
 *      }
 * 2.Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 *      @Resource:
 *          可以和@Autowired一样实现自动装配功能,默认是按照组件名称进行装配的
 *          没有能支持@Primary功能没有支持@Autowired(required=false)
 *      @Inject:
 *          需要导入javax.inject的包,和@Autowired的功能一样,没有required=false功能
 * AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能
 *
 * 3.@Autowired:构造器,参数,方法,属性;能够标注在这些上面
 *      1.标注在方法上
 *      2.标注在构造器上
 * 4.自定义组件想要使用Spring容器底层的一些组件(ApplicationContext,BeanFactory,xxx)
 *      自定义组件实现xxxAware:在创建对象的时候,会调用接口规定的方法注入相关组件:Aware;
 *      把spring底层一些组建爱你注入到自定义的bean中:
 *      xxxAware:功能使用xxxProcessor:
 *          applicationContextAware-->applicationContextAwareProcessor
 * @author 小卢
 */
@Configuration
@ComponentScan({"com.lu.dao","com.lu.service","com.lu.controller","com.lu.bean"})
public class MainConfigOfAutowired {

    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    /**
     * @Bean标注的方法创建对象的时候,方法参数的值从容器中获取 可以不在car前加@Autowired
     * @param car
     * @return
     */
    @Bean
    public Color color( Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }

}
