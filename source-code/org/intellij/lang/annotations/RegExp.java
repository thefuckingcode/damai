package org.intellij.lang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Language("RegExp")
@Retention(RetentionPolicy.CLASS)
/* compiled from: Taobao */
public @interface RegExp {
    String prefix() default "";

    String suffix() default "";
}
