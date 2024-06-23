package tb;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.calls.BoundCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class ff<M extends Member> implements Caller<M> {
    @NotNull
    public static final d Companion = new d(null);
    @NotNull
    private final List<Type> a;
    @NotNull
    private final M b;
    @NotNull
    private final Type c;
    @Nullable
    private final Class<?> d;

    /* compiled from: Taobao */
    public static final class a extends ff<Constructor<?>> implements BoundCaller {
        private final Object e;

        /* JADX WARNING: Illegal instructions before constructor call */
        public a(@NotNull Constructor<?> constructor, @Nullable Object obj) {
            super(constructor, r3, null, (Type[]) r0, null);
            Object obj2;
            k21.i(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            k21.h(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            k21.h(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 2) {
                obj2 = new Type[0];
            } else {
                obj2 = kotlin.collections.e.h(genericParameterTypes, 1, genericParameterTypes.length - 1);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            this.e = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            k21.i(objArr, "args");
            a(objArr);
            ld2 ld2 = new ld2(3);
            ld2.a(this.e);
            ld2.b(objArr);
            ld2.a(null);
            return ((Constructor) getMember()).newInstance(ld2.d(new Object[ld2.c()]));
        }
    }

    /* compiled from: Taobao */
    public static final class b extends ff<Constructor<?>> {
        /* JADX WARNING: Illegal instructions before constructor call */
        public b(@NotNull Constructor<?> constructor) {
            super(constructor, r3, null, (Type[]) r0, null);
            Object obj;
            k21.i(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            k21.h(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            k21.h(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 1) {
                obj = new Type[0];
            } else {
                obj = kotlin.collections.e.h(genericParameterTypes, 0, genericParameterTypes.length - 1);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T>");
            }
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            k21.i(objArr, "args");
            a(objArr);
            ld2 ld2 = new ld2(2);
            ld2.b(objArr);
            ld2.a(null);
            return ((Constructor) getMember()).newInstance(ld2.d(new Object[ld2.c()]));
        }
    }

    /* compiled from: Taobao */
    public static final class c extends ff<Constructor<?>> implements BoundCaller {
        private final Object e;

        /* JADX WARNING: Illegal instructions before constructor call */
        public c(@NotNull Constructor<?> constructor, @Nullable Object obj) {
            super(constructor, r3, null, r5, null);
            k21.i(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            k21.h(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            k21.h(genericParameterTypes, "constructor.genericParameterTypes");
            this.e = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            k21.i(objArr, "args");
            a(objArr);
            ld2 ld2 = new ld2(2);
            ld2.a(this.e);
            ld2.b(objArr);
            return ((Constructor) getMember()).newInstance(ld2.d(new Object[ld2.c()]));
        }
    }

    /* compiled from: Taobao */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class e extends ff<Constructor<?>> {
        /* JADX WARNING: Illegal instructions before constructor call */
        public e(@NotNull Constructor<?> constructor) {
            super(constructor, r3, r4, r5, null);
            k21.i(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            k21.h(declaringClass, "constructor.declaringClass");
            Class<?> declaringClass2 = constructor.getDeclaringClass();
            k21.h(declaringClass2, "klass");
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            Class<?> cls = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            k21.h(genericParameterTypes, "constructor.genericParameterTypes");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            k21.i(objArr, "args");
            a(objArr);
            return ((Constructor) getMember()).newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* compiled from: Taobao */
    public static abstract class f extends ff<Field> {

        /* compiled from: Taobao */
        public static final class a extends f implements BoundCaller {
            private final Object e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(@NotNull Field field, @Nullable Object obj) {
                super(field, false, null);
                k21.i(field, "field");
                this.e = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller, tb.ff.f
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                k21.i(objArr, "args");
                a(objArr);
                return ((Field) getMember()).get(this.e);
            }
        }

        /* compiled from: Taobao */
        public static final class b extends f implements BoundCaller {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(@NotNull Field field) {
                super(field, false, null);
                k21.i(field, "field");
            }
        }

        /* compiled from: Taobao */
        public static final class c extends f {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(@NotNull Field field) {
                super(field, true, null);
                k21.i(field, "field");
            }
        }

        /* compiled from: Taobao */
        public static final class d extends f {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(@NotNull Field field) {
                super(field, true, null);
                k21.i(field, "field");
            }

            @Override // tb.ff
            public void a(@NotNull Object[] objArr) {
                k21.i(objArr, "args");
                ff.super.a(objArr);
                b(kotlin.collections.e.v(objArr));
            }
        }

        /* compiled from: Taobao */
        public static final class e extends f {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(@NotNull Field field) {
                super(field, false, null);
                k21.i(field, "field");
            }
        }

        public /* synthetic */ f(Field field, boolean z, m40 m40) {
            this(field, z);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            k21.i(objArr, "args");
            a(objArr);
            return ((Field) getMember()).get(c() != null ? kotlin.collections.e.u(objArr) : null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        private f(Field field, boolean z) {
            super(field, r2, z ? field.getDeclaringClass() : null, new Type[0], null);
            Type genericType = field.getGenericType();
            k21.h(genericType, "field.genericType");
        }
    }

    /* compiled from: Taobao */
    public static abstract class g extends ff<Field> {
        private final boolean e;

        /* compiled from: Taobao */
        public static final class a extends g implements BoundCaller {
            private final Object f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(@NotNull Field field, boolean z, @Nullable Object obj) {
                super(field, z, false, null);
                k21.i(field, "field");
                this.f = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller, tb.ff.g
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                k21.i(objArr, "args");
                a(objArr);
                ((Field) getMember()).set(this.f, kotlin.collections.e.u(objArr));
                return ur2.INSTANCE;
            }
        }

        /* compiled from: Taobao */
        public static final class b extends g implements BoundCaller {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(@NotNull Field field, boolean z) {
                super(field, z, false, null);
                k21.i(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller, tb.ff.g
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                k21.i(objArr, "args");
                a(objArr);
                ((Field) getMember()).set(null, kotlin.collections.e.G(objArr));
                return ur2.INSTANCE;
            }
        }

        /* compiled from: Taobao */
        public static final class c extends g {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(@NotNull Field field, boolean z) {
                super(field, z, true, null);
                k21.i(field, "field");
            }
        }

        /* compiled from: Taobao */
        public static final class d extends g {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(@NotNull Field field, boolean z) {
                super(field, z, true, null);
                k21.i(field, "field");
            }

            @Override // tb.ff.g, tb.ff
            public void a(@NotNull Object[] objArr) {
                k21.i(objArr, "args");
                super.a(objArr);
                b(kotlin.collections.e.v(objArr));
            }
        }

        /* compiled from: Taobao */
        public static final class e extends g {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(@NotNull Field field, boolean z) {
                super(field, z, false, null);
                k21.i(field, "field");
            }
        }

        public /* synthetic */ g(Field field, boolean z, boolean z2, m40 m40) {
            this(field, z, z2);
        }

        @Override // tb.ff
        public void a(@NotNull Object[] objArr) {
            k21.i(objArr, "args");
            ff.super.a(objArr);
            if (this.e && kotlin.collections.e.G(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            k21.i(objArr, "args");
            a(objArr);
            ((Field) getMember()).set(c() != null ? kotlin.collections.e.u(objArr) : null, kotlin.collections.e.G(objArr));
            return ur2.INSTANCE;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        private g(Field field, boolean z, boolean z2) {
            super(field, r2, r9, new Type[]{r0}, null);
            Class cls = Void.TYPE;
            k21.h(cls, "Void.TYPE");
            Class<?> declaringClass = z2 ? field.getDeclaringClass() : null;
            Type genericType = field.getGenericType();
            k21.h(genericType, "field.genericType");
            this.e = z;
        }
    }

    /* compiled from: Taobao */
    public static abstract class h extends ff<Method> {
        private final boolean e;

        /* compiled from: Taobao */
        public static final class a extends h implements BoundCaller {
            private final Object f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(@NotNull Method method, @Nullable Object obj) {
                super(method, false, null, 4, null);
                k21.i(method, "method");
                this.f = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                k21.i(objArr, "args");
                a(objArr);
                return d(this.f, objArr);
            }
        }

        /* compiled from: Taobao */
        public static final class b extends h implements BoundCaller {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(@NotNull Method method) {
                super(method, false, null, 4, null);
                k21.i(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                k21.i(objArr, "args");
                a(objArr);
                return d(null, objArr);
            }
        }

        /* compiled from: Taobao */
        public static final class c extends h implements BoundCaller {
            private final Object f;

            /* JADX WARNING: Illegal instructions before constructor call */
            public c(@NotNull Method method, @Nullable Object obj) {
                super(method, false, (Type[]) r0, null);
                Object obj2;
                k21.i(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                k21.h(genericParameterTypes, "method.genericParameterTypes");
                if (genericParameterTypes.length <= 1) {
                    obj2 = new Type[0];
                } else {
                    obj2 = kotlin.collections.e.h(genericParameterTypes, 1, genericParameterTypes.length);
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                this.f = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                k21.i(objArr, "args");
                a(objArr);
                ld2 ld2 = new ld2(2);
                ld2.a(this.f);
                ld2.b(objArr);
                return d(null, ld2.d(new Object[ld2.c()]));
            }
        }

        /* compiled from: Taobao */
        public static final class d extends h {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(@NotNull Method method) {
                super(method, false, null, 6, null);
                k21.i(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                Object[] objArr2;
                k21.i(objArr, "args");
                a(objArr);
                Object obj = objArr[0];
                if (objArr.length <= 1) {
                    objArr2 = new Object[0];
                } else {
                    objArr2 = kotlin.collections.e.h(objArr, 1, objArr.length);
                    Objects.requireNonNull(objArr2, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return d(obj, objArr2);
            }
        }

        /* compiled from: Taobao */
        public static final class e extends h {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(@NotNull Method method) {
                super(method, true, null, 4, null);
                k21.i(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                Object[] objArr2;
                k21.i(objArr, "args");
                a(objArr);
                b(kotlin.collections.e.v(objArr));
                if (objArr.length <= 1) {
                    objArr2 = new Object[0];
                } else {
                    objArr2 = kotlin.collections.e.h(objArr, 1, objArr.length);
                    Objects.requireNonNull(objArr2, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return d(null, objArr2);
            }
        }

        /* compiled from: Taobao */
        public static final class f extends h {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(@NotNull Method method) {
                super(method, false, null, 6, null);
                k21.i(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                k21.i(objArr, "args");
                a(objArr);
                return d(null, objArr);
            }
        }

        public /* synthetic */ h(Method method, boolean z, Type[] typeArr, m40 m40) {
            this(method, z, typeArr);
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final Object d(@Nullable Object obj, @NotNull Object[] objArr) {
            k21.i(objArr, "args");
            return this.e ? ur2.INSTANCE : ((Method) getMember()).invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* synthetic */ h(Method method, boolean z, Type[] typeArr, int i, m40 m40) {
            this(method, z, typeArr);
            z = (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z;
            if ((i & 4) != 0) {
                typeArr = method.getGenericParameterTypes();
                k21.h(typeArr, "method.genericParameterTypes");
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        private h(Method method, boolean z, Type[] typeArr) {
            super(method, r2, z ? method.getDeclaringClass() : null, typeArr, null);
            Type genericReturnType = method.getGenericReturnType();
            k21.h(genericReturnType, "method.genericReturnType");
            this.e = k21.d(getReturnType(), Void.TYPE);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0027, code lost:
        if (r1 != null) goto L_0x002e;
     */
    private ff(M m, Type type, Class<?> cls, Type[] typeArr) {
        List<Type> list;
        this.b = m;
        this.c = type;
        this.d = cls;
        if (cls != null) {
            ld2 ld2 = new ld2(2);
            ld2.a(cls);
            ld2.b(typeArr);
            list = m.j((Type[]) ld2.d(new Type[ld2.c()]));
        }
        list = ArraysKt___ArraysKt.X(typeArr);
        this.a = list;
    }

    public void a(@NotNull Object[] objArr) {
        k21.i(objArr, "args");
        Caller.a.a(this, objArr);
    }

    /* access modifiers changed from: protected */
    public final void b(@Nullable Object obj) {
        if (obj == null || !this.b.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    @Nullable
    public final Class<?> c() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final M getMember() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public List<Type> getParameterTypes() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final Type getReturnType() {
        return this.c;
    }

    public /* synthetic */ ff(Member member, Type type, Class cls, Type[] typeArr, m40 m40) {
        this(member, type, cls, typeArr);
    }
}
