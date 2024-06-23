package kotlin.contracts;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.RequiresOptIn;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;

@SinceKotlin(version = "1.3")
@MustBeDocumented
@RequiresOptIn
@Documented
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* compiled from: Taobao */
public @interface ExperimentalContracts {
}
