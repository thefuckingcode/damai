package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.k21;

/* compiled from: Taobao */
public class KProperty0Impl<V> extends KPropertyImpl<V> implements KProperty0<V> {
    private final az1.b<a<V>> l;
    private final Lazy<Object> m = b.a(LazyThreadSafetyMode.PUBLICATION, new KProperty0Impl$delegateFieldValue$1(this));

    /* compiled from: Taobao */
    public static final class a<R> extends KPropertyImpl.Getter<R> implements KProperty0.Getter<R> {
        @NotNull
        private final KProperty0Impl<R> h;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.KProperty0Impl<? extends R> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull KProperty0Impl<? extends R> kProperty0Impl) {
            k21.i(kProperty0Impl, "property");
            this.h = kProperty0Impl;
        }

        @Override // kotlin.jvm.functions.Function0
        public R invoke() {
            return m().get();
        }

        @NotNull
        /* renamed from: o */
        public KProperty0Impl<R> m() {
            return this.h;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(propertyDescriptor, "descriptor");
        az1.b<a<V>> b = az1.b(new KProperty0Impl$_getter$1(this));
        k21.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
    }

    @Override // kotlin.reflect.KProperty0
    public V get() {
        return p().call(new Object[0]);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object getDelegate() {
        return this.m.getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public V invoke() {
        return get();
    }

    @NotNull
    /* renamed from: s */
    public a<V> p() {
        a<V> invoke = this.l.invoke();
        k21.h(invoke, "_getter()");
        return invoke;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(str, "name");
        k21.i(str2, SocialOperation.GAME_SIGNATURE);
        az1.b<a<V>> b = az1.b(new KProperty0Impl$_getter$1(this));
        k21.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
    }
}
