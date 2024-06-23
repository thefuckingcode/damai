package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: Taobao */
public @interface LoopTranslation {

    /* compiled from: Taobao */
    public enum LoopStyle {
        JAVA_ITERATOR,
        FAST_ENUMERATION
    }

    LoopStyle value();
}
