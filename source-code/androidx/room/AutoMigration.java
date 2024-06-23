package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* compiled from: Taobao */
public @interface AutoMigration {
    int from();

    Class<?> spec() default Object.class;

    int to();
}
