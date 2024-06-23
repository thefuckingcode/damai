package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import tb.bl;
import tb.d51;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public abstract class JvmFunctionSignature {

    /* compiled from: Taobao */
    public static final class FakeJavaAnnotationConstructor extends JvmFunctionSignature {
        @NotNull
        private final List<Method> a;
        @NotNull
        private final Class<?> b;

        /* compiled from: Taobao */
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                T t3 = t;
                k21.h(t3, AdvanceSetting.NETWORK_TYPE);
                String name = t3.getName();
                T t4 = t2;
                k21.h(t4, AdvanceSetting.NETWORK_TYPE);
                return bl.a(name, t4.getName());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FakeJavaAnnotationConstructor(@NotNull Class<?> cls) {
            super(null);
            k21.i(cls, "jClass");
            this.b = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            k21.h(declaredMethods, "jClass.declaredMethods");
            this.a = ArraysKt___ArraysKt.P(declaredMethods, new a());
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String a() {
            return CollectionsKt___CollectionsKt.Z(this.a, "", "<init>(", ")V", 0, null, JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1.INSTANCE, 24, null);
        }

        @NotNull
        public final List<Method> b() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    public static final class JavaConstructor extends JvmFunctionSignature {
        @NotNull
        private final Constructor<?> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public JavaConstructor(@NotNull Constructor<?> constructor) {
            super(null);
            k21.i(constructor, "constructor");
            this.a = constructor;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String a() {
            Class<?>[] parameterTypes = this.a.getParameterTypes();
            k21.h(parameterTypes, "constructor.parameterTypes");
            return ArraysKt___ArraysKt.F(parameterTypes, "", "<init>(", ")V", 0, null, JvmFunctionSignature$JavaConstructor$asString$1.INSTANCE, 24, null);
        }

        @NotNull
        public final Constructor<?> b() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    public static final class a extends JvmFunctionSignature {
        @NotNull
        private final Method a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull Method method) {
            super(null);
            k21.i(method, "method");
            this.a = method;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String a() {
            return RuntimeTypeMapperKt.b(this.a);
        }

        @NotNull
        public final Method b() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    public static final class b extends JvmFunctionSignature {
        private final String a;
        @NotNull
        private final d51.b b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull d51.b bVar) {
            super(null);
            k21.i(bVar, SocialOperation.GAME_SIGNATURE);
            this.b = bVar;
            this.a = bVar.a();
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String a() {
            return this.a;
        }

        @NotNull
        public final String b() {
            return this.b.b();
        }
    }

    /* compiled from: Taobao */
    public static final class c extends JvmFunctionSignature {
        private final String a;
        @NotNull
        private final d51.b b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull d51.b bVar) {
            super(null);
            k21.i(bVar, SocialOperation.GAME_SIGNATURE);
            this.b = bVar;
            this.a = bVar.a();
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String a() {
            return this.a;
        }

        @NotNull
        public final String b() {
            return this.b.b();
        }

        @NotNull
        public final String c() {
            return this.b.c();
        }
    }

    private JvmFunctionSignature() {
    }

    @NotNull
    public abstract String a();

    public /* synthetic */ JvmFunctionSignature(m40 m40) {
        this();
    }
}
