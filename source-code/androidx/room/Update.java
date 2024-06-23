package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
/* compiled from: Taobao */
public @interface Update {
    Class<?> entity() default Object.class;

    @OnConflictStrategy
    int onConflict() default 3;
}
