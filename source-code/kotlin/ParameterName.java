package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;

@Target({})
@SinceKotlin(version = "1.1")
@MustBeDocumented
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface ParameterName {
    String name();
}
