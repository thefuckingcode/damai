package com.ali.user.open.core.webview;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface BridgeMethod {
    String value() default "";
}
