package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;

@Target({ElementType.FIELD})
@MustBeDocumented
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD})
@Documented
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* compiled from: Taobao */
public @interface Transient {
}
