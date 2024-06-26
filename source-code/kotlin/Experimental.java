package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.ANNOTATION_TYPE})
@SinceKotlin(version = "1.2")
@Deprecated(message = "Please use RequiresOptIn instead.")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@DeprecatedSinceKotlin(errorSince = "1.6", warningSince = "1.4")
/* compiled from: Taobao */
public @interface Experimental {

    /* compiled from: Taobao */
    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;
}
