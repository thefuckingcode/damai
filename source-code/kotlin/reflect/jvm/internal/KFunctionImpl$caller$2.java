package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import tb.i22;
import tb.k21;
import tb.wt2;
import tb.x01;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KFunctionImpl$caller$2 extends Lambda implements Function0<Caller<? extends Member>> {
    final /* synthetic */ KFunctionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KFunctionImpl$caller$2(KFunctionImpl kFunctionImpl) {
        super(0);
        this.this$0 = kFunctionImpl;
    }

    /* Return type fixed from 'kotlin.reflect.jvm.internal.calls.Caller<java.lang.reflect.Member>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Caller<? extends Member> invoke() {
        Object obj;
        Caller caller;
        JvmFunctionSignature g = i22.INSTANCE.g(this.this$0.i());
        if (g instanceof JvmFunctionSignature.b) {
            if (this.this$0.j()) {
                Class<?> jClass = this.this$0.g().getJClass();
                List<KParameter> parameters = this.this$0.getParameters();
                ArrayList arrayList = new ArrayList(n.q(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = it.next().getName();
                    k21.f(name);
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            obj = this.this$0.g().c(((JvmFunctionSignature.b) g).b());
        } else if (g instanceof JvmFunctionSignature.c) {
            JvmFunctionSignature.c cVar = (JvmFunctionSignature.c) g;
            obj = this.this$0.g().g(cVar.c(), cVar.b());
        } else if (g instanceof JvmFunctionSignature.a) {
            obj = ((JvmFunctionSignature.a) g).b();
        } else if (g instanceof JvmFunctionSignature.JavaConstructor) {
            obj = ((JvmFunctionSignature.JavaConstructor) g).b();
        } else if (g instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
            List<Method> b = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) g).b();
            Class<?> jClass2 = this.this$0.g().getJClass();
            ArrayList arrayList2 = new ArrayList(n.q(b, 10));
            for (T t : b) {
                k21.h(t, AdvanceSetting.NETWORK_TYPE);
                arrayList2.add(t.getName());
            }
            return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, b);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (obj instanceof Constructor) {
            KFunctionImpl kFunctionImpl = this.this$0;
            caller = kFunctionImpl.q((Constructor) obj, kFunctionImpl.i());
        } else if (obj instanceof Method) {
            Method method = (Method) obj;
            if (!Modifier.isStatic(method.getModifiers())) {
                caller = this.this$0.r(method);
            } else if (this.this$0.i().getAnnotations().findAnnotation(wt2.h()) != null) {
                caller = this.this$0.s(method);
            } else {
                caller = this.this$0.t(method);
            }
        } else {
            throw new KotlinReflectionInternalError("Could not compute caller for function: " + this.this$0.i() + " (member = " + obj + ')');
        }
        return x01.c(caller, this.this$0.i(), false, 2, null);
    }
}
