package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class KMutableProperty1Impl<T, V> extends KProperty1Impl<T, V> implements KMutableProperty1<T, V> {
    private final az1.b<a<T, V>> n;

    /* compiled from: Taobao */
    public static final class a<T, V> extends KPropertyImpl.Setter<V> implements KMutableProperty1.Setter<T, V> {
        @NotNull
        private final KMutableProperty1Impl<T, V> h;

        public a(@NotNull KMutableProperty1Impl<T, V> kMutableProperty1Impl) {
            k21.i(kMutableProperty1Impl, "property");
            this.h = kMutableProperty1Impl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ ur2 invoke(Object obj, Object obj2) {
            p(obj, obj2);
            return ur2.INSTANCE;
        }

        @NotNull
        /* renamed from: o */
        public KMutableProperty1Impl<T, V> m() {
            return this.h;
        }

        public void p(T t, V v) {
            m().set(t, v);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(str, "name");
        k21.i(str2, SocialOperation.GAME_SIGNATURE);
        az1.b<a<T, V>> b = az1.b(new KMutableProperty1Impl$_setter$1(this));
        k21.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }

    @Override // kotlin.reflect.KMutableProperty1
    public void set(T t, V v) {
        getSetter().call(t, v);
    }

    @NotNull
    /* renamed from: t */
    public a<T, V> getSetter() {
        a<T, V> invoke = this.n.invoke();
        k21.h(invoke, "_setter()");
        return invoke;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(propertyDescriptor, "descriptor");
        az1.b<a<T, V>> b = az1.b(new KMutableProperty1Impl$_setter$1(this));
        k21.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }
}
