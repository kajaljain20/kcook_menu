package com.kcook.menu.foodItem;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component
@Aspect
public class FoodItemAspect {

    //AOP expression for which methods shall be intercepted
    @Around("execution(* com.kcook.menu.foodItem.FoodItemService.*(..))")
    public Object aroundService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
       MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        //String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();

        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        //Log method execution time
        log.info("Execution time {} ms",stopWatch.getTotalTimeMillis());
        log.info("{} completed successfully", methodName);
        return result;
    }
}
