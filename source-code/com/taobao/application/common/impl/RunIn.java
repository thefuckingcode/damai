package com.taobao.application.common.impl;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.SOURCE)
/* compiled from: Taobao */
public @interface RunIn {
    String value();
}
