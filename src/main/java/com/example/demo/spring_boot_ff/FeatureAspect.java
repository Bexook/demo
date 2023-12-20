package com.example.demo.spring_boot_ff;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FeatureAspect {


    @Around(value = "@annotation(com.example.demo.spring_boot_ff.Feature)")
    public Object around(final ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Feature feature = (Feature) signature.getMethod().getAnnotation(Feature.class);
        System.out.println(feature.isActive());
        pjp.proceed();
        if (!feature.isActive()) {
            return null;
        }
        return pjp.proceed();
    }


}
