package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.Nullable;
import tb.i22;
import tb.k21;
import tb.wt2;
import tb.x01;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/Caller;", "invoke", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KFunctionImpl$defaultCaller$2 extends Lambda implements Function0<Caller<? extends Member>> {
    final /* synthetic */ KFunctionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KFunctionImpl$defaultCaller$2(KFunctionImpl kFunctionImpl) {
        super(0);
        this.this$0 = kFunctionImpl;
    }

    /* Return type fixed from 'kotlin.reflect.jvm.internal.calls.Caller<java.lang.reflect.Member>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Caller<? extends Member> invoke() {
        Object obj;
        Caller caller;
        JvmFunctionSignature g = i22.INSTANCE.g(this.this$0.i());
        if (g instanceof JvmFunctionSignature.c) {
            KDeclarationContainerImpl g2 = this.this$0.g();
            JvmFunctionSignature.c cVar = (JvmFunctionSignature.c) g;
            String c = cVar.c();
            String b = cVar.b();
            Member member = this.this$0.f().getMember();
            k21.f(member);
            obj = g2.e(c, b, !Modifier.isStatic(member.getModifiers()));
        } else if (g instanceof JvmFunctionSignature.b) {
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
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            obj = this.this$0.g().d(((JvmFunctionSignature.b) g).b());
        } else if (g instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
            List<Method> b2 = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) g).b();
            Class<?> jClass2 = this.this$0.g().getJClass();
            ArrayList arrayList2 = new ArrayList(n.q(b2, 10));
            for (T t : b2) {
                k21.h(t, AdvanceSetting.NETWORK_TYPE);
                arrayList2.add(t.getName());
            }
            return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, b2);
        } else {
            obj = null;
        }
        if (obj instanceof Constructor) {
            KFunctionImpl kFunctionImpl = this.this$0;
            caller = kFunctionImpl.q((Constructor) obj, kFunctionImpl.i());
        } else if (obj instanceof Method) {
            if (this.this$0.i().getAnnotations().findAnnotation(wt2.h()) != null) {
                DeclarationDescriptor containingDeclaration = this.this$0.i().getContainingDeclaration();
                Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (!((ClassDescriptor) containingDeclaration).isCompanionObject()) {
                    caller = this.this$0.s((Method) obj);
                }
            }
            caller = this.this$0.t((Method) obj);
        } else {
            caller = null;
        }
        if (caller != null) {
            return x01.b(caller, this.this$0.i(), true);
        }
        return null;
    }
}
