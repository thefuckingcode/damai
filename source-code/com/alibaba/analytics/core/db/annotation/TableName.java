package com.alibaba.analytics.core.db.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface TableName {
    String value();
}
