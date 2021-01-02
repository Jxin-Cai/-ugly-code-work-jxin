package com.jxin.todo.infrastructure.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * shell全局异常切面
 * @author 素律
 * @since 2021/1/2 5:36 下午
 */
@Order(1)
/*@Component*/
@Aspect
public class ShellGlobalErrAop {
    /**
     * shell层的Pointcut
     */
    @Pointcut("execution(* com.jxin.todo.ohs.shell.*.*.*(..))")
    private void shellPointcut(){}
    @Pointcut("execution(* com.jxin.todo.domain.item.repository.*.*.*(..))")
    private void repPointcut(){}

    @Around("repPointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        try {
            return proceedingJoinPoint.proceed();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
