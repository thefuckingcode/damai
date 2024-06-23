package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.az1;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class KMutableProperty2Impl<D, E, V> extends KProperty2Impl<D, E, V> implements KMutableProperty2<D, E, V> {
    private final az1.b<a<D, E, V>> n;

    /* compiled from: Taobao */
    public static final class a<D, E, V> extends KPropertyImpl.Setter<V> implements KMutableProperty2.Setter<D, E, V> {
        @NotNull
        private final KMutableProperty2Impl<D, E, V> h;

        public a(@NotNull KMutableProperty2Impl<D, E, V> kMutableProperty2Impl) {
            k21.i(kMutableProperty2Impl, "property");
            this.h = kMutableProperty2Impl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ur2 invoke(Object obj, Object obj2, Object obj3) {
            p(obj, obj2, obj3);
            return ur2.INSTANCE;
        }

        @NotNull
        /* renamed from: o */
        public KMutableProperty2Impl<D, E, V> m() {
            return this.h;
        }

        public void p(D d, E e, V v) {
            m().set(d, e, v);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KMutableProperty2Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2) {
        super(kDeclarationContainerImpl, str, str2);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(str, "name");
        k21.i(str2, SocialOperation.GAME_SIGNATURE);
        az1.b<a<D, E, V>> b = az1.b(new KMutableProperty2Impl$_setter$1(this));
        k21.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }

    @Override // kotlin.reflect.KMutableProperty2
    public void set(D d, E e, V v) {
        getSetter().call(d, e, v);
    }

    @NotNull
    /* renamed from: t */
    public a<D, E, V> getSetter() {
        a<D, E, V> invoke = this.n.invoke();
        k21.h(invoke, "_setter()");
        return invoke;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KMutableProperty2Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        k21.i(kDeclarationContainerImpl, "container");
        k21.i(propertyDescriptor, "descriptor");
        az1.b<a<D, E, V>> b = az1.b(new KMutableProperty2Impl$_setter$1(this));
        k21.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }
}
