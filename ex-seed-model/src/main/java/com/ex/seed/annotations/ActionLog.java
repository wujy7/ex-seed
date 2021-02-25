package com.ex.seed.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.METHOD})//使用位置（类，方法）
@Retention(RetentionPolicy.RUNTIME)//加载到jvm里运行
public @interface ActionLog {

    String remark();

    String type();

}
