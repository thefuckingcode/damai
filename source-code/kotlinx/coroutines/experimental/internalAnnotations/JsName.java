package kotlinx.coroutines.experimental.internalAnnotations;

import com.lzy.okgo.cookie.SerializableCookie;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\t\u0010\u0002\u001a\u00020\u0003¢\u0006\u0000¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/experimental/internalAnnotations/JsName;", "", SerializableCookie.NAME, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Annotations.kt */
public @interface JsName {
    String name();
}
