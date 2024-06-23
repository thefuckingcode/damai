package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* compiled from: Taobao */
public @interface TypeConverters {
    BuiltInTypeConverters builtInTypeConverters() default @BuiltInTypeConverters;

    Class<?>[] value() default {};
}
