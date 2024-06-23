package com.taobao.android.dinamicx.template.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
public abstract class DXDataBaseEntry {
    public static final String[] ID_PROJECTION = {"_id"};

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface Column {
        String defaultValue() default "";

        boolean indexed() default false;

        boolean notNull() default false;

        boolean primaryKey() default false;

        String value();
    }

    /* compiled from: Taobao */
    public interface Columns {
        public static final String ID = "_id";
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface Table {
        String value();
    }
}
