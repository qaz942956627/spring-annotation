package com.lu.aop;

import org.aspectj.lang.annotation.*;

/**
 * 切面类
 * @Aspect:告诉spring当前类是一个切面类
 */
@Aspect
public class LogAspects {

    /***
     * 抽取公共的切入点表达式
     *     1.本类引用
     *     2.其他的切面类引用
     */
    @Pointcut("execution(public int com.lu.aop.MathCalculator.*(..))")
    public void pointCut() {};

    //@Before()在目标方法之前切入:切入点表达式()
    @Before("pointCut()")
    public void logStart() {
        System.out.println("除法运行中,参数列表:{}");
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("除法结束");
    }

    @AfterReturning("pointCut()")
    public void logReturn() {
        System.out.println("得到返回值,结果:{}");
    }

    @AfterThrowing("pointCut()")
    public void logException() {
        System.out.println("抛出异常,异常信息:{}");
    }
}
