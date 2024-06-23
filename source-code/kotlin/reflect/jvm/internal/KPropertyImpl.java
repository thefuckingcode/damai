package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.dz1;
import tb.i22;
import tb.k21;
import tb.m40;
import tb.ur2;
import tb.wt2;
import tb.x01;

/* compiled from: Taobao */
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {
    @NotNull
    public static final b Companion = new b(null);
    @NotNull
    private static final Object k = new Object();
    private final az1.b<Field> e;
    private final az1.a<PropertyDescriptor> f;
    @NotNull
    private final KDeclarationContainerImpl g;
    @NotNull
    private final String h;
    @NotNull
    private final String i;
    private final Object j;

    /* compiled from: Taobao */
    public static abstract class Getter<V> extends a<V, V> implements KProperty.Getter<V> {
        static final /* synthetic */ KProperty[] g = {dz1.i(new PropertyReference1Impl(dz1.b(Getter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), dz1.i(new PropertyReference1Impl(dz1.b(Getter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        @NotNull
        private final az1.a e = az1.d(new KPropertyImpl$Getter$descriptor$2(this));
        @NotNull
        private final az1.b f = az1.b(new KPropertyImpl$Getter$caller$2(this));

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public Caller<?> f() {
            return (Caller) this.f.b(this, g[1]);
        }

        @Override // kotlin.reflect.KCallable
        @NotNull
        public String getName() {
            return "<get-" + m().getName() + '>';
        }

        @NotNull
        /* renamed from: n */
        public PropertyGetterDescriptor l() {
            return (PropertyGetterDescriptor) this.e.b(this, g[0]);
        }
    }

    /* compiled from: Taobao */
    public static abstract class Setter<V> extends a<V, ur2> implements KMutableProperty.Setter<V> {
        static final /* synthetic */ KProperty[] g = {dz1.i(new PropertyReference1Impl(dz1.b(Setter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), dz1.i(new PropertyReference1Impl(dz1.b(Setter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        @NotNull
        private final az1.a e = az1.d(new KPropertyImpl$Setter$descriptor$2(this));
        @NotNull
        private final az1.b f = az1.b(new KPropertyImpl$Setter$caller$2(this));

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public Caller<?> f() {
            return (Caller) this.f.b(this, g[1]);
        }

        @Override // kotlin.reflect.KCallable
        @NotNull
        public String getName() {
            return "<set-" + m().getName() + '>';
        }

        @NotNull
        /* renamed from: n */
        public PropertySetterDescriptor l() {
            return (PropertySetterDescriptor) this.e.b(this, g[0]);
        }
    }

    /* compiled from: Taobao */
    public static abstract class a<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType>, KProperty.Accessor<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public KDeclarationContainerImpl g() {
            return m().g();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @Nullable
        public Caller<?> h() {
            return null;
        }

        @Override // kotlin.reflect.KFunction
        public boolean isExternal() {
            return l().isExternal();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInfix() {
            return l().isInfix();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInline() {
            return l().isInline();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isOperator() {
            return l().isOperator();
        }

        @Override // kotlin.reflect.KFunction, kotlin.reflect.KCallable
        public boolean isSuspend() {
            return l().isSuspend();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public boolean k() {
            return m().k();
        }

        @NotNull
        public abstract PropertyAccessorDescriptor l();

        @NotNull
        public abstract KPropertyImpl<PropertyType> m();
    }

    /* compiled from: Taobao */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }
    }

    private KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, PropertyDescriptor propertyDescriptor, Object obj) {
        this.g = kDeclarationContainerImpl;
        this.h = str;
        this.i = str2;
        this.j = obj;
        az1.b<Field> b2 = az1.b(new KPropertyImpl$_javaField$1(this));
        k21.h(b2, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.e = b2;
        az1.a<PropertyDescriptor> c = az1.c(propertyDescriptor, new KPropertyImpl$_descriptor$1(this));
        k21.h(c, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.f = c;
    }

    public boolean equals(@Nullable Object obj) {
        KPropertyImpl<?> c = wt2.c(obj);
        if (c == null || !k21.d(g(), c.g()) || !k21.d(getName(), c.getName()) || !k21.d(this.i, c.i) || !k21.d(this.j, c.j)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public Caller<?> f() {
        return p().f();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public KDeclarationContainerImpl g() {
        return this.g;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public String getName() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @Nullable
    public Caller<?> h() {
        return p().h();
    }

    public int hashCode() {
        return (((g().hashCode() * 31) + getName().hashCode()) * 31) + this.i.hashCode();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return i().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return i().isLateInit();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean k() {
        return !k21.d(this.j, CallableReference.NO_RECEIVER);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Field l() {
        if (i().isDelegated()) {
            return q();
        }
        return null;
    }

    @Nullable
    public final Object m() {
        return x01.a(this.j, i());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Object n(@Nullable Field field, @Nullable Object obj) {
        try {
            if (obj == k) {
                if (i().getExtensionReceiverParameter() == null) {
                    throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() " + "is not going to work, use getDelegate() instead");
                }
            }
            if (field != null) {
                return field.get(obj);
            }
            return null;
        } catch (IllegalAccessException e2) {
            throw new IllegalPropertyDelegateAccessException(e2);
        }
    }

    @NotNull
    /* renamed from: o */
    public PropertyDescriptor i() {
        PropertyDescriptor invoke = this.f.invoke();
        k21.h(invoke, "_descriptor()");
        return invoke;
    }

    @NotNull
    public abstract Getter<V> p();

    @Nullable
    public final Field q() {
        return this.e.invoke();
    }

    @NotNull
    public final String r() {
        return this.i;
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.g(i());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KPropertyImpl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(str, "name");
        k21.i(str2, SocialOperation.GAME_SIGNATURE);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public KPropertyImpl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        this(kDeclarationContainerImpl, r3, i22.INSTANCE.f(propertyDescriptor).a(), propertyDescriptor, CallableReference.NO_RECEIVER);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(propertyDescriptor, "descriptor");
        String b2 = propertyDescriptor.getName().b();
        k21.h(b2, "descriptor.name.asString()");
    }
}
