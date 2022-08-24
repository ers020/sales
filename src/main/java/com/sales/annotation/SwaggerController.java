package com.sales.annotation;

import org.springframework.stereotype.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Controller
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SwaggerController {}
