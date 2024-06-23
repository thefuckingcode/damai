package tb;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.collections.e;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.calls.BoundCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ff;

/* compiled from: Taobao */
public abstract class g21 implements Caller<Method> {
    @NotNull
    private final Type a;
    private final Method b;
    @NotNull
    private final List<Type> c;

    /* compiled from: Taobao */
    public static final class a extends g21 implements BoundCaller {
        private final Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull Method method, @Nullable Object obj) {
            super(method, m.g(), null);
            k21.i(method, "unboxMethod");
            this.d = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            k21.i(objArr, "args");
            b(objArr);
            return a(this.d, objArr);
        }
    }

    /* compiled from: Taobao */
    public static final class b extends g21 {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull Method method) {
            super(method, l.e(method.getDeclaringClass()), null);
            k21.i(method, "unboxMethod");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            Object[] objArr2;
            k21.i(objArr, "args");
            b(objArr);
            Object obj = objArr[0];
            ff.d dVar = ff.Companion;
            if (objArr.length <= 1) {
                objArr2 = new Object[0];
            } else {
                objArr2 = e.h(objArr, 1, objArr.length);
                Objects.requireNonNull(objArr2, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            return a(obj, objArr2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends java.lang.reflect.Type> */
    /* JADX WARN: Multi-variable type inference failed */
    private g21(Method method, List<? extends Type> list) {
        this.b = method;
        this.c = list;
        Class<?> returnType = method.getReturnType();
        k21.h(returnType, "unboxMethod.returnType");
        this.a = returnType;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Object a(@Nullable Object obj, @NotNull Object[] objArr) {
        k21.i(objArr, "args");
        return this.b.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public void b(@NotNull Object[] objArr) {
        k21.i(objArr, "args");
        Caller.a.a(this, objArr);
    }

    @Nullable
    /* renamed from: c */
    public final Method getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final List<Type> getParameterTypes() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final Type getReturnType() {
        return this.a;
    }

    public /* synthetic */ g21(Method method, List list, m40 m40) {
        this(method, list);
    }
}
