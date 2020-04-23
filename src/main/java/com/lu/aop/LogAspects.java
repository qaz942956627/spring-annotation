package com.lu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

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
    public void logStart(JoinPoint joinPoint) {
        // 获取被增强方法参数列表
        Object[] args = joinPoint.getArgs();

        System.out.println(joinPoint.getSignature().getName()+"运行中,参数列表:{"+ Arrays.asList(args) +"}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName()+"结束");
    }

    // JoinPoint一定要出现在参数列表的第一位
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result) {
        System.out.println(joinPoint.getSignature().getName()+"得到返回值,结果:{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void logException(JoinPoint joinPoint,Exception e) {
        System.out.println(joinPoint.getSignature().getName()+"抛出异常,异常信息:{"+e+"}");
    }
}
