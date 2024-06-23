package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Ljava/lang/reflect/Method;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1 extends Lambda implements Function1<Method, CharSequence> {
    public static final JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1 INSTANCE = new JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1();

    JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(Method method) {
        k21.h(method, AdvanceSetting.NETWORK_TYPE);
        Class<?> returnType = method.getReturnType();
        k21.h(returnType, "it.returnType");
        return ReflectClassUtilKt.c(returnType);
    }
}
