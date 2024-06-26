package kotlin.jvm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.METHOD})
@SinceKotlin(version = "1.2")
@Deprecated(message = "Switch to new -Xjvm-default modes: `all` or `all-compatibility`")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface JvmDefault {
}
