package com.google.android.material.internal;

import androidx.annotation.NonNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Deprecated
@Retention(RetentionPolicy.CLASS)
/* compiled from: Taobao */
public @interface Experimental {
    @NonNull
    String value() default "";
}
