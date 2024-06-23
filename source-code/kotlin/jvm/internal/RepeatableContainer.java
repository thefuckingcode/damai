package kotlin.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.SinceKotlin;

@Target({ElementType.ANNOTATION_TYPE})
@SinceKotlin(version = "1.6")
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Taobao */
public @interface RepeatableContainer {
}
