package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.k21;

/* compiled from: Taobao */
public class KProperty1Impl<T, V> extends KPropertyImpl<V> implements KProperty1<T, V> {
    private final az1.b<a<T, V>> l;
    private final Lazy<Field> m = b.a(LazyThreadSafetyMode.PUBLICATION, new KProperty1Impl$delegateField$1(this));

    /* compiled from: Taobao */
    public static final class a<T, V> extends KPropertyImpl.Getter<V> implements KProperty1.Getter<T, V> {
        @NotNull
        private final KProperty1Impl<T, V> h;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.KProperty1Impl<T, ? extends V> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull KProperty1Impl<T, ? extends V> kProperty1Impl) {
            k21.i(kProperty1Impl, "property");
            this.h = kProperty1Impl;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(T t) {
            return m().get(t);
        }

        @NotNull
        /* renamed from: o */
        public KProperty1Impl<T, V> m() {
            return this.h;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(str, "name");
        k21.i(str2, SocialOperation.GAME_SIGNATURE);
        az1.b<a<T, V>> b = az1.b(new KProperty1Impl$_getter$1(this));
        k21.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
    }

    @Override // kotlin.reflect.KProperty1
    public V get(T t) {
        return (V) p().call(t);
    }

    @Override // kotlin.reflect.KProperty1
    @Nullable
    public Object getDelegate(T t) {
        return n(this.m.getValue(), t);
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T t) {
        return get(t);
    }

    @NotNull
    /* renamed from: s */
    public a<T, V> p() {
        a<T, V> invoke = this.l.invoke();
        k21.h(invoke, "_getter()");
        return invoke;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(propertyDescriptor, "descriptor");
        az1.b<a<T, V>> b = az1.b(new KProperty1Impl$_getter$1(this));
        k21.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
    }
}
