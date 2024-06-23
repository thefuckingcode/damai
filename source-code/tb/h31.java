package tb;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class h31 {
    @NotNull
    public static final h31 INSTANCE = new h31();
    @Nullable
    private static a a;

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        private final Method a;
        @Nullable
        private final Method b;

        public a(@Nullable Method method, @Nullable Method method2) {
            this.a = method;
            this.b = method2;
        }

        @Nullable
        public final Method a() {
            return this.b;
        }

        @Nullable
        public final Method b() {
            return this.a;
        }
    }

    private h31() {
    }

    @NotNull
    public final a a(@NotNull Member member) {
        k21.i(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", new Class[0]), ReflectClassUtilKt.g(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    @Nullable
    public final List<String> b(@NotNull Member member) {
        Method a2;
        k21.i(member, "member");
        a aVar = a;
        if (aVar == null) {
            aVar = a(member);
            a = aVar;
        }
        Method b = aVar.b();
        if (b == null || (a2 = aVar.a()) == null) {
            return null;
        }
        Object invoke = b.invoke(member, new Object[0]);
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) invoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object invoke2 = a2.invoke(obj, new Object[0]);
            Objects.requireNonNull(invoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) invoke2);
        }
        return arrayList;
    }
}
