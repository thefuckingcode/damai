package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tb.k21;

/* compiled from: Taobao */
final class ReflectJavaClass$methods$1 extends Lambda implements Function1<Method, Boolean> {
    final /* synthetic */ ReflectJavaClass this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReflectJavaClass$methods$1(ReflectJavaClass reflectJavaClass) {
        super(1);
        this.this$0 = reflectJavaClass;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Method method) {
        return Boolean.valueOf(invoke(method));
    }

    public final boolean invoke(Method method) {
        if (!method.isSynthetic()) {
            if (!this.this$0.isEnum()) {
                return true;
            }
            ReflectJavaClass reflectJavaClass = this.this$0;
            k21.h(method, "method");
            if (!ReflectJavaClass.a(reflectJavaClass, method)) {
                return true;
            }
        }
        return false;
    }
}
