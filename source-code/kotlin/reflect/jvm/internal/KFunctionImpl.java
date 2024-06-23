package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.dz1;
import tb.ff;
import tb.gf;
import tb.i22;
import tb.k21;
import tb.m40;
import tb.wt2;
import tb.x01;
import tb.y01;

/* compiled from: Taobao */
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ KProperty[] k = {dz1.i(new PropertyReference1Impl(dz1.b(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), dz1.i(new PropertyReference1Impl(dz1.b(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), dz1.i(new PropertyReference1Impl(dz1.b(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    @NotNull
    private final az1.a e;
    @NotNull
    private final az1.b f;
    @Nullable
    private final az1.b g;
    @NotNull
    private final KDeclarationContainerImpl h;
    private final String i;
    private final Object j;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj, int i2, m40 m40) {
        this(kDeclarationContainerImpl, str, str2, functionDescriptor, (i2 & 16) != 0 ? CallableReference.NO_RECEIVER : obj);
    }

    /* access modifiers changed from: private */
    public final ff<Constructor<?>> q(Constructor<?> constructor, FunctionDescriptor functionDescriptor) {
        if (y01.f(functionDescriptor)) {
            if (k()) {
                return new ff.a(constructor, u());
            }
            return new ff.b(constructor);
        } else if (k()) {
            return new ff.c(constructor, u());
        } else {
            return new ff.e(constructor);
        }
    }

    /* access modifiers changed from: private */
    public final ff.h r(Method method) {
        return k() ? new ff.h.a(method, u()) : new ff.h.d(method);
    }

    /* access modifiers changed from: private */
    public final ff.h s(Method method) {
        return k() ? new ff.h.b(method) : new ff.h.e(method);
    }

    /* access modifiers changed from: private */
    public final ff.h t(Method method) {
        return k() ? new ff.h.c(method, u()) : new ff.h.f(method);
    }

    private final Object u() {
        return x01.a(this.j, i());
    }

    public boolean equals(@Nullable Object obj) {
        KFunctionImpl b = wt2.b(obj);
        if (b == null || !k21.d(g(), b.g()) || !k21.d(getName(), b.getName()) || !k21.d(this.i, b.i) || !k21.d(this.j, b.j)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public Caller<?> f() {
        return (Caller) this.f.b(this, k[1]);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public KDeclarationContainerImpl g() {
        return this.h;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return gf.a(f());
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public String getName() {
        String b = i().getName().b();
        k21.h(b, "descriptor.name.asString()");
        return b;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @Nullable
    public Caller<?> h() {
        return (Caller) this.g.b(this, k[2]);
    }

    public int hashCode() {
        return (((g().hashCode() * 31) + getName().hashCode()) * 31) + this.i.hashCode();
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public Object invoke() {
        return FunctionWithAllInvokes.a.a(this);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return i().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return i().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return i().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return i().isOperator();
    }

    @Override // kotlin.reflect.KFunction, kotlin.reflect.KCallable
    public boolean isSuspend() {
        return i().isSuspend();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean k() {
        return !k21.d(this.j, CallableReference.NO_RECEIVER);
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.d(i());
    }

    @NotNull
    /* renamed from: v */
    public FunctionDescriptor i() {
        return (FunctionDescriptor) this.e.b(this, k[0]);
    }

    private KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj) {
        this.h = kDeclarationContainerImpl;
        this.i = str2;
        this.j = obj;
        this.e = az1.c(functionDescriptor, new KFunctionImpl$descriptor$2(this, str));
        this.f = az1.b(new KFunctionImpl$caller$2(this));
        this.g = az1.b(new KFunctionImpl$defaultCaller$2(this));
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public Object invoke(@Nullable Object obj) {
        return FunctionWithAllInvokes.a.b(this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2) {
        return FunctionWithAllInvokes.a.c(this, obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        return FunctionWithAllInvokes.a.d(this, obj, obj2, obj3);
    }

    @Override // kotlin.jvm.functions.Function4
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4) {
        return FunctionWithAllInvokes.a.e(this, obj, obj2, obj3, obj4);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(str, "name");
        k21.i(str2, SocialOperation.GAME_SIGNATURE);
    }

    @Override // kotlin.jvm.functions.Function5
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5) {
        return FunctionWithAllInvokes.a.f(this, obj, obj2, obj3, obj4, obj5);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public KFunctionImpl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull FunctionDescriptor functionDescriptor) {
        this(kDeclarationContainerImpl, r3, i22.INSTANCE.g(functionDescriptor).a(), functionDescriptor, null, 16, null);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(functionDescriptor, "descriptor");
        String b = functionDescriptor.getName().b();
        k21.h(b, "descriptor.name.asString()");
    }

    @Override // kotlin.jvm.functions.Function6
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6) {
        return FunctionWithAllInvokes.a.g(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7) {
        return FunctionWithAllInvokes.a.h(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8) {
        return FunctionWithAllInvokes.a.i(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.jvm.functions.Function9
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9) {
        return FunctionWithAllInvokes.a.j(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.jvm.functions.Function10
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10) {
        return FunctionWithAllInvokes.a.k(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11) {
        return FunctionWithAllInvokes.a.l(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12) {
        return FunctionWithAllInvokes.a.m(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13) {
        return FunctionWithAllInvokes.a.n(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14) {
        return FunctionWithAllInvokes.a.o(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15) {
        return FunctionWithAllInvokes.a.p(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16) {
        return FunctionWithAllInvokes.a.q(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17) {
        return FunctionWithAllInvokes.a.r(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function18
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18) {
        return FunctionWithAllInvokes.a.s(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // kotlin.jvm.functions.Function19
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19) {
        return FunctionWithAllInvokes.a.t(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // kotlin.jvm.functions.Function20
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20) {
        return FunctionWithAllInvokes.a.u(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // kotlin.jvm.functions.Function21
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21) {
        return FunctionWithAllInvokes.a.v(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // kotlin.jvm.functions.Function22
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21, @Nullable Object obj22) {
        return FunctionWithAllInvokes.a.w(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
