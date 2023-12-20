package com.example.demo.togglz_based_annotation;

import com.example.demo.general_togglz_config.AppFeatures;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface TogglzFeature {

    AppFeatures value();

}
