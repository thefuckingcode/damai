package com.alibaba.poplayer.factory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface PLViewInfo {
    boolean isDefaultType() default false;

    String type();
}
