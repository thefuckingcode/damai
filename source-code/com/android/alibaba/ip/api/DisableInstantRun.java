package com.android.alibaba.ip.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* compiled from: Taobao */
public @interface DisableInstantRun {
}