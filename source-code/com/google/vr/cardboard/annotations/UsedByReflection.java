package com.google.vr.cardboard.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR})
/* compiled from: Taobao */
public @interface UsedByReflection {
    String value();
}
