package com.example.demo.togglz_based_annotation;

import com.example.demo.spring_boot_ff.Feature;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.togglz.core.manager.FeatureManager;

@Aspect
@Component
@RequiredArgsConstructor
public class TogglzFeatureAspect {

    private final FeatureManager featureManager;

    @Around(value = "@annotation(com.example.demo.togglz_based_annotation.TogglzFeature)")
    public Object around(final ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        TogglzFeature feature = (TogglzFeature) signature.getMethod().getAnnotation(TogglzFeature.class);
        if (featureManager.isActive(feature.value())) {
            return pjp.proceed(); //User have authority to access feature
        }
        return null; //Skip method execution or add execution of default logic(implemented in AfterReturn aspect)
    }


}
