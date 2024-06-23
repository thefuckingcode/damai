package com.taobao.weex.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface JSMethod {
    public static final String NOT_SET = "_";

    String alias() default "_";

    boolean uiThread() default true;
}
