package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class KMutableProperty0Impl<V> extends KProperty0Impl<V> implements KMutableProperty0<V> {
    private final az1.b<a<V>> n;

    /* compiled from: Taobao */
    public static final class a<R> extends KPropertyImpl.Setter<R> implements KMutableProperty0.Setter<R> {
        @NotNull
        private final KMutableProperty0Impl<R> h;

        public a(@NotNull KMutableProperty0Impl<R> kMutableProperty0Impl) {
            k21.i(kMutableProperty0Impl, "property");
            this.h = kMutableProperty0Impl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ur2 invoke(Object obj) {
            p(obj);
            return ur2.INSTANCE;
        }

        @NotNull
        /* renamed from: o */
        public KMutableProperty0Impl<R> m() {
            return this.h;
        }

        public void p(R r) {
            m().set(r);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(propertyDescriptor, "descriptor");
        az1.b<a<V>> b = az1.b(new KMutableProperty0Impl$_setter$1(this));
        k21.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(V v) {
        getSetter().call(v);
    }

    @NotNull
    /* renamed from: t */
    public a<V> getSetter() {
        a<V> invoke = this.n.invoke();
        k21.h(invoke, "_setter()");
        return invoke;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(str, "name");
        k21.i(str2, SocialOperation.GAME_SIGNATURE);
        az1.b<a<V>> b = az1.b(new KMutableProperty0Impl$_setter$1(this));
        k21.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }
}
