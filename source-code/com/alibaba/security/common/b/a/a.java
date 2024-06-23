package com.alibaba.security.common.b.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface a {
    int a() default 0;

    String b() default "";

    String c() default "";

    boolean d() default true;
}
