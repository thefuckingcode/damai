package com.taobao.weex.common;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@Inherited
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface WXModuleAnno {
    @Deprecated
    boolean moduleMethod() default true;

    boolean runOnUIThread() default true;
}
