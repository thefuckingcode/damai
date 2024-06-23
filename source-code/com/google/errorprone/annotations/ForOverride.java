package com.google.errorprone.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.lang.model.element.Modifier;

@IncompatibleModifiers({Modifier.PUBLIC, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL})
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* compiled from: Taobao */
public @interface ForOverride {
}
