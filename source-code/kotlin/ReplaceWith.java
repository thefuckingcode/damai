package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;

@Target({})
@MustBeDocumented
@kotlin.annotation.Target(allowedTargets = {})
@Documented
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* compiled from: Taobao */
public @interface ReplaceWith {
    String expression();

    String[] imports();
}
