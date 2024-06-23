package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.do2;
import tb.dz1;
import tb.en0;
import tb.k21;
import tb.og1;
import tb.oi;
import tb.v00;
import tb.z41;

/* compiled from: Taobao */
public final class ReflectClassUtilKt {
    @NotNull
    private static final List<KClass<? extends Object>> a;
    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> b;
    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> c;
    @NotNull
    private static final Map<Class<? extends Function<?>>, Integer> d;

    static {
        int i = 0;
        List<KClass<? extends Object>> list = m.j(dz1.b(Boolean.TYPE), dz1.b(Byte.TYPE), dz1.b(Character.TYPE), dz1.b(Double.TYPE), dz1.b(Float.TYPE), dz1.b(Integer.TYPE), dz1.b(Long.TYPE), dz1.b(Short.TYPE));
        a = list;
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (T t : list) {
            arrayList.add(do2.a(z41.c(t), z41.d(t)));
        }
        b = x.r(arrayList);
        List<KClass<? extends Object>> list2 = a;
        ArrayList arrayList2 = new ArrayList(n.q(list2, 10));
        for (T t2 : list2) {
            arrayList2.add(do2.a(z41.d(t2), z41.c(t2)));
        }
        c = x.r(arrayList2);
        List list3 = m.j(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList3 = new ArrayList(n.q(list3, 10));
        for (Object obj : list3) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            arrayList3.add(do2.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        d = x.r(arrayList3);
    }

    @NotNull
    public static final Class<?> a(@NotNull Class<?> cls) {
        k21.i(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    @NotNull
    public static final oi b(@NotNull Class<?> cls) {
        k21.i(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(k21.r("Can't compute ClassId for primitive type: ", cls));
        } else if (!cls.isArray()) {
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                String simpleName = cls.getSimpleName();
                k21.h(simpleName, "simpleName");
                if (!(simpleName.length() == 0)) {
                    Class<?> declaringClass = cls.getDeclaringClass();
                    oi d2 = declaringClass == null ? null : b(declaringClass).d(og1.f(cls.getSimpleName()));
                    if (d2 == null) {
                        d2 = oi.m(new en0(cls.getName()));
                    }
                    k21.h(d2, "declaringClass?.classId?.createNestedClassId(Name.identifier(simpleName)) ?: ClassId.topLevel(FqName(name))");
                    return d2;
                }
            }
            en0 en0 = new en0(cls.getName());
            return new oi(en0.e(), en0.k(en0.g()), true);
        } else {
            throw new IllegalArgumentException(k21.r("Can't compute ClassId for array type: ", cls));
        }
    }

    @NotNull
    public static final String c(@NotNull Class<?> cls) {
        k21.i(cls, "<this>");
        if (k21.d(cls, Void.TYPE)) {
            return "V";
        }
        String name = a(cls).getName();
        k21.h(name, "createArrayType().name");
        String substring = name.substring(1);
        k21.h(substring, "(this as java.lang.String).substring(startIndex)");
        return o.E(substring, '.', v00.DIR, false, 4, null);
    }

    @Nullable
    public static final Integer d(@NotNull Class<?> cls) {
        k21.i(cls, "<this>");
        return d.get(cls);
    }

    @NotNull
    public static final List<Type> e(@NotNull Type type) {
        k21.i(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return m.g();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.t(SequencesKt__SequencesKt.h(type, ReflectClassUtilKt$parameterizedTypeArguments$1.INSTANCE), ReflectClassUtilKt$parameterizedTypeArguments$2.INSTANCE));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        k21.h(actualTypeArguments, "actualTypeArguments");
        return ArraysKt___ArraysKt.X(actualTypeArguments);
    }

    @Nullable
    public static final Class<?> f(@NotNull Class<?> cls) {
        k21.i(cls, "<this>");
        return b.get(cls);
    }

    @NotNull
    public static final ClassLoader g(@NotNull Class<?> cls) {
        k21.i(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        k21.h(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    @Nullable
    public static final Class<?> h(@NotNull Class<?> cls) {
        k21.i(cls, "<this>");
        return c.get(cls);
    }

    public static final boolean i(@NotNull Class<?> cls) {
        k21.i(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
