package kotlin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface Target {
    AnnotationTarget[] allowedTargets();
}
