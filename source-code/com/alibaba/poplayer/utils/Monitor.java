package com.alibaba.poplayer.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
public class Monitor {

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface TargetClass {
        String tag() default "";
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface TargetField {
        String name() default "";

        String prefix() default "";
    }

    /* compiled from: Taobao */
    public static class a {
        public final Object a;
        public final Object b;

        public a(Object obj, String str, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }
    }

    private Monitor() {
    }
}
