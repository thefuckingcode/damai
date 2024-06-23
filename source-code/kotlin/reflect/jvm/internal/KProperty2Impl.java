package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.jvm.internal.CallableReference;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.k21;

/* compiled from: Taobao */
public class KProperty2Impl<D, E, V> extends KPropertyImpl<V> implements KProperty2<D, E, V> {
    private final az1.b<a<D, E, V>> l;
    private final Lazy<Field> m = b.a(LazyThreadSafetyMode.PUBLICATION, new KProperty2Impl$delegateField$1(this));

    /* compiled from: Taobao */
    public static final class a<D, E, V> extends KPropertyImpl.Getter<V> implements KProperty2.Getter<D, E, V> {
        @NotNull
        private final KProperty2Impl<D, E, V> h;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.KProperty2Impl<D, E, ? extends V> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull KProperty2Impl<D, E, ? extends V> kProperty2Impl) {
            k21.i(kProperty2Impl, "property");
            this.h = kProperty2Impl;
        }

        @Override // kotlin.jvm.functions.Function2
        public V invoke(D d, E e) {
            return m().get(d, e);
        }

        @NotNull
        /* renamed from: o */
        public KProperty2Impl<D, E, V> m() {
            return this.h;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty2Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2) {
        super(kDeclarationContainerImpl, str, str2, CallableReference.NO_RECEIVER);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(str, "name");
        k21.i(str2, SocialOperation.GAME_SIGNATURE);
        az1.b<a<D, E, V>> b = az1.b(new KProperty2Impl$_getter$1(this));
        k21.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
    }

    @Override // kotlin.reflect.KProperty2
    public V get(D d, E e) {
        return (V) p().call(d, e);
    }

    @Override // kotlin.reflect.KProperty2
    @Nullable
    public Object getDelegate(D d, E e) {
        return n(this.m.getValue(), d);
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D d, E e) {
        return get(d, e);
    }

    @NotNull
    /* renamed from: s */
    public a<D, E, V> p() {
        a<D, E, V> invoke = this.l.invoke();
        k21.h(invoke, "_getter()");
        return invoke;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty2Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(propertyDescriptor, "descriptor");
        az1.b<a<D, E, V>> b = az1.b(new KProperty2Impl$_getter$1(this));
        k21.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
    }
}
