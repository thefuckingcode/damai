package cn.damai.common.db.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface Column {
    boolean autoGen() default true;

    boolean isId() default false;

    String name();

    String property() default "";
}
