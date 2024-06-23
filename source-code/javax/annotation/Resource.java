package javax.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface Resource {

    /* compiled from: Taobao */
    public enum AuthenticationType {
        CONTAINER,
        APPLICATION
    }

    AuthenticationType authenticationType() default AuthenticationType.CONTAINER;

    String description() default "";

    String lookup() default "";

    String mappedName() default "";

    String name() default "";

    boolean shareable() default true;

    Class<?> type() default Object.class;
}
