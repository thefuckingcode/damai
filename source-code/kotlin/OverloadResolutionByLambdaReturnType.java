package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.experimental.ExperimentalTypeInference;

@Target({ElementType.METHOD})
@SinceKotlin(version = "1.4")
@ExperimentalTypeInference
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* compiled from: Taobao */
public @interface OverloadResolutionByLambdaReturnType {
}
