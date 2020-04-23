package com.lu.config;


import com.lu.aop.LogAspects;
import com.lu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP: 动态代理
 *      值在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *
 * 1.导入aop模块:Spring AOP (spring-aspects)
 * 2.定义一个业务逻辑类MathCalculator,在业务逻辑运行的时候将日志进行打印(方法之前、结束、出现异常,xxx)
 * 3.定义一个日志切面类(LogAspects):切面类里面的方法需要动态感知到定义一个业务逻辑类MathCalculator.div方法运行到哪里然后执行
 *      LogAspects里面的方法叫通知方法:
 *          前置通知(@Before):logStart:在目标方法(div)运行之前
 *          后置通知(@After):logEnd:在目标方法(div)运行结束之后(无论方法是正常结束还是异常结束)
 *          返回通知(@AfterReturning):logReturn:在目标方法(div)正常返回之后
 *          异常通知(@AfterThrowing):logException:在目标方法(div)运行出现异常以后运行
 *          环绕通知(@Around):动态代理,手动推进目标方法运行(joinPoint.procced())
 * 4.给切面类的目标方法标准核实运行(通知注解)
 * 5.将切面类和业务逻辑类(目标方法所在类)都加入到容器中
 * 6.必须告诉spring那个类是切面类(给切面类上面加一个注解)
 * ***7.<aop:aspectj-autoproxy></aop:aspectj-autoproxy>在xml中这是开启基于注解版的切面功能
 *      @EnableAspectJAutoProxy 这个是基于纯注解的开启aop的注解
 *      在spring中有很多的@Enablexxx;都是开启某一项功能的
 *
 * @author 小卢
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    // 业务逻辑类加入到容器中
    @Bean
    public MathCalculator calculator() {
        return new MathCalculator();
    }

    // 切面类加入到容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

}
