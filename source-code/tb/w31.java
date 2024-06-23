package tb;

import com.youku.upsplayer.util.YKUpsConvert;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class w31 {
    @NotNull
    public static final w31 INSTANCE;
    @NotNull
    private static final String a;
    @NotNull
    private static final String b;
    @NotNull
    private static final String c;
    @NotNull
    private static final String d;
    @NotNull
    private static final oi e;
    @NotNull
    private static final en0 f;
    @NotNull
    private static final oi g;
    @NotNull
    private static final HashMap<fn0, oi> h = new HashMap<>();
    @NotNull
    private static final HashMap<fn0, oi> i = new HashMap<>();
    @NotNull
    private static final HashMap<fn0, en0> j = new HashMap<>();
    @NotNull
    private static final HashMap<fn0, en0> k = new HashMap<>();
    @NotNull
    private static final List<a> l;

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        private final oi a;
        @NotNull
        private final oi b;
        @NotNull
        private final oi c;

        public a(@NotNull oi oiVar, @NotNull oi oiVar2, @NotNull oi oiVar3) {
            k21.i(oiVar, "javaClass");
            k21.i(oiVar2, "kotlinReadOnly");
            k21.i(oiVar3, "kotlinMutable");
            this.a = oiVar;
            this.b = oiVar2;
            this.c = oiVar3;
        }

        @NotNull
        public final oi a() {
            return this.a;
        }

        @NotNull
        public final oi b() {
            return this.b;
        }

        @NotNull
        public final oi c() {
            return this.c;
        }

        @NotNull
        public final oi d() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return k21.d(this.a, aVar.a) && k21.d(this.b, aVar.b) && k21.d(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        @NotNull
        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.a + ", kotlinReadOnly=" + this.b + ", kotlinMutable=" + this.c + ')';
        }
    }

    static {
        w31 w31 = new w31();
        INSTANCE = w31;
        StringBuilder sb = new StringBuilder();
        FunctionClassKind functionClassKind = FunctionClassKind.Function;
        sb.append(functionClassKind.getPackageFqName().toString());
        sb.append('.');
        sb.append(functionClassKind.getClassNamePrefix());
        a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        FunctionClassKind functionClassKind2 = FunctionClassKind.KFunction;
        sb2.append(functionClassKind2.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(functionClassKind2.getClassNamePrefix());
        b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        FunctionClassKind functionClassKind3 = FunctionClassKind.SuspendFunction;
        sb3.append(functionClassKind3.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(functionClassKind3.getClassNamePrefix());
        c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        FunctionClassKind functionClassKind4 = FunctionClassKind.KSuspendFunction;
        sb4.append(functionClassKind4.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(functionClassKind4.getClassNamePrefix());
        d = sb4.toString();
        oi m = oi.m(new en0("kotlin.jvm.functions.FunctionN"));
        k21.h(m, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        e = m;
        en0 b2 = m.b();
        k21.h(b2, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f = b2;
        oi m2 = oi.m(new en0("kotlin.reflect.KFunction"));
        k21.h(m2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        g = m2;
        k21.h(oi.m(new en0("kotlin.reflect.KClass")), "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        w31.h(Class.class);
        oi m3 = oi.m(c.a.iterable);
        k21.h(m3, "topLevel(FqNames.iterable)");
        en0 en0 = c.a.mutableIterable;
        en0 h2 = m3.h();
        en0 h3 = m3.h();
        k21.h(h3, "kotlinReadOnly.packageFqName");
        en0 d2 = kotlin.reflect.jvm.internal.impl.name.a.d(en0, h3);
        int i2 = 0;
        oi oiVar = new oi(h2, d2, false);
        oi m4 = oi.m(c.a.iterator);
        k21.h(m4, "topLevel(FqNames.iterator)");
        en0 en02 = c.a.mutableIterator;
        en0 h4 = m4.h();
        en0 h5 = m4.h();
        k21.h(h5, "kotlinReadOnly.packageFqName");
        oi oiVar2 = new oi(h4, kotlin.reflect.jvm.internal.impl.name.a.d(en02, h5), false);
        oi m5 = oi.m(c.a.collection);
        k21.h(m5, "topLevel(FqNames.collection)");
        en0 en03 = c.a.mutableCollection;
        en0 h6 = m5.h();
        en0 h7 = m5.h();
        k21.h(h7, "kotlinReadOnly.packageFqName");
        oi oiVar3 = new oi(h6, kotlin.reflect.jvm.internal.impl.name.a.d(en03, h7), false);
        oi m6 = oi.m(c.a.list);
        k21.h(m6, "topLevel(FqNames.list)");
        en0 en04 = c.a.mutableList;
        en0 h8 = m6.h();
        en0 h9 = m6.h();
        k21.h(h9, "kotlinReadOnly.packageFqName");
        oi oiVar4 = new oi(h8, kotlin.reflect.jvm.internal.impl.name.a.d(en04, h9), false);
        oi m7 = oi.m(c.a.set);
        k21.h(m7, "topLevel(FqNames.set)");
        en0 en05 = c.a.mutableSet;
        en0 h10 = m7.h();
        en0 h11 = m7.h();
        k21.h(h11, "kotlinReadOnly.packageFqName");
        oi oiVar5 = new oi(h10, kotlin.reflect.jvm.internal.impl.name.a.d(en05, h11), false);
        oi m8 = oi.m(c.a.listIterator);
        k21.h(m8, "topLevel(FqNames.listIterator)");
        en0 en06 = c.a.mutableListIterator;
        en0 h12 = m8.h();
        en0 h13 = m8.h();
        k21.h(h13, "kotlinReadOnly.packageFqName");
        oi oiVar6 = new oi(h12, kotlin.reflect.jvm.internal.impl.name.a.d(en06, h13), false);
        en0 en07 = c.a.map;
        oi m9 = oi.m(en07);
        k21.h(m9, "topLevel(FqNames.map)");
        en0 en08 = c.a.mutableMap;
        en0 h14 = m9.h();
        en0 h15 = m9.h();
        k21.h(h15, "kotlinReadOnly.packageFqName");
        oi oiVar7 = new oi(h14, kotlin.reflect.jvm.internal.impl.name.a.d(en08, h15), false);
        oi d3 = oi.m(en07).d(c.a.mapEntry.g());
        k21.h(d3, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        en0 en09 = c.a.mutableMapEntry;
        en0 h16 = d3.h();
        en0 h17 = d3.h();
        k21.h(h17, "kotlinReadOnly.packageFqName");
        List<a> list = m.j(new a(w31.h(Iterable.class), m3, oiVar), new a(w31.h(Iterator.class), m4, oiVar2), new a(w31.h(Collection.class), m5, oiVar3), new a(w31.h(List.class), m6, oiVar4), new a(w31.h(Set.class), m7, oiVar5), new a(w31.h(ListIterator.class), m8, oiVar6), new a(w31.h(Map.class), m9, oiVar7), new a(w31.h(Map.Entry.class), d3, new oi(h16, kotlin.reflect.jvm.internal.impl.name.a.d(en09, h17), false)));
        l = list;
        w31.g(Object.class, c.a.any);
        w31.g(String.class, c.a.string);
        w31.g(CharSequence.class, c.a.charSequence);
        w31.f(Throwable.class, c.a.throwable);
        w31.g(Cloneable.class, c.a.cloneable);
        w31.g(Number.class, c.a.number);
        w31.f(Comparable.class, c.a.comparable);
        w31.g(Enum.class, c.a._enum);
        w31.f(Annotation.class, c.a.annotation);
        for (a aVar : list) {
            INSTANCE.e(aVar);
        }
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i3 = 0;
        while (i3 < length) {
            JvmPrimitiveType jvmPrimitiveType = values[i3];
            i3++;
            w31 w312 = INSTANCE;
            oi m10 = oi.m(jvmPrimitiveType.getWrapperFqName());
            k21.h(m10, "topLevel(jvmType.wrapperFqName)");
            c cVar = c.INSTANCE;
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            k21.h(primitiveType, "jvmType.primitiveType");
            oi m11 = oi.m(c.c(primitiveType));
            k21.h(m11, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            w312.b(m10, m11);
        }
        for (oi oiVar8 : xk.INSTANCE.a()) {
            w31 w313 = INSTANCE;
            oi m12 = oi.m(new en0("kotlin.jvm.internal." + oiVar8.j().b() + "CompanionObject"));
            k21.h(m12, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            oi d4 = oiVar8.d(dd2.DEFAULT_NAME_FOR_COMPANION_OBJECT);
            k21.h(d4, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            w313.b(m12, d4);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            w31 w314 = INSTANCE;
            oi m13 = oi.m(new en0(k21.r("kotlin.jvm.functions.Function", Integer.valueOf(i4))));
            k21.h(m13, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            c cVar2 = c.INSTANCE;
            w314.b(m13, c.a(i4));
            w314.d(new en0(k21.r(b, Integer.valueOf(i4))), g);
            if (i5 >= 23) {
                break;
            }
            i4 = i5;
        }
        while (true) {
            int i6 = i2 + 1;
            FunctionClassKind functionClassKind5 = FunctionClassKind.KSuspendFunction;
            w31 w315 = INSTANCE;
            w315.d(new en0(k21.r(functionClassKind5.getPackageFqName().toString() + '.' + functionClassKind5.getClassNamePrefix(), Integer.valueOf(i2))), g);
            if (i6 >= 22) {
                en0 l2 = c.a.nothing.l();
                k21.h(l2, "nothing.toSafe()");
                w315.d(l2, w315.h(Void.class));
                return;
            }
            i2 = i6;
        }
    }

    private w31() {
    }

    private final void b(oi oiVar, oi oiVar2) {
        c(oiVar, oiVar2);
        en0 b2 = oiVar2.b();
        k21.h(b2, "kotlinClassId.asSingleFqName()");
        d(b2, oiVar);
    }

    private final void c(oi oiVar, oi oiVar2) {
        HashMap<fn0, oi> hashMap = h;
        fn0 j2 = oiVar.b().j();
        k21.h(j2, "javaClassId.asSingleFqName().toUnsafe()");
        hashMap.put(j2, oiVar2);
    }

    private final void d(en0 en0, oi oiVar) {
        HashMap<fn0, oi> hashMap = i;
        fn0 j2 = en0.j();
        k21.h(j2, "kotlinFqNameUnsafe.toUnsafe()");
        hashMap.put(j2, oiVar);
    }

    private final void e(a aVar) {
        oi a2 = aVar.a();
        oi b2 = aVar.b();
        oi c2 = aVar.c();
        b(a2, b2);
        en0 b3 = c2.b();
        k21.h(b3, "mutableClassId.asSingleFqName()");
        d(b3, a2);
        en0 b4 = b2.b();
        k21.h(b4, "readOnlyClassId.asSingleFqName()");
        en0 b5 = c2.b();
        k21.h(b5, "mutableClassId.asSingleFqName()");
        HashMap<fn0, en0> hashMap = j;
        fn0 j2 = c2.b().j();
        k21.h(j2, "mutableClassId.asSingleFqName().toUnsafe()");
        hashMap.put(j2, b4);
        HashMap<fn0, en0> hashMap2 = k;
        fn0 j3 = b4.j();
        k21.h(j3, "readOnlyFqName.toUnsafe()");
        hashMap2.put(j3, b5);
    }

    private final void f(Class<?> cls, en0 en0) {
        oi h2 = h(cls);
        oi m = oi.m(en0);
        k21.h(m, "topLevel(kotlinFqName)");
        b(h2, m);
    }

    private final void g(Class<?> cls, fn0 fn0) {
        en0 l2 = fn0.l();
        k21.h(l2, "kotlinFqName.toSafe()");
        f(cls, l2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final oi h(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            oi m = oi.m(new en0(cls.getCanonicalName()));
            k21.h(m, "topLevel(FqName(clazz.canonicalName))");
            return m;
        }
        oi d2 = h(declaringClass).d(og1.f(cls.getSimpleName()));
        k21.h(d2, "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))");
        return d2;
    }

    private final boolean k(fn0 fn0, String str) {
        Integer num;
        String b2 = fn0.b();
        k21.h(b2, "kotlinFqName.asString()");
        String str2 = StringsKt__StringsKt.I0(b2, str, "");
        if (!(str2.length() > 0) || (StringsKt__StringsKt.E0(str2, YKUpsConvert.CHAR_ZERO, false, 2, null)) || (num = n.k(str2)) == null || num.intValue() < 23) {
            return false;
        }
        return true;
    }

    @NotNull
    public final en0 i() {
        return f;
    }

    @NotNull
    public final List<a> j() {
        return l;
    }

    public final boolean l(@Nullable fn0 fn0) {
        HashMap<fn0, en0> hashMap = j;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(fn0);
    }

    public final boolean m(@Nullable fn0 fn0) {
        HashMap<fn0, en0> hashMap = k;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(fn0);
    }

    @Nullable
    public final oi n(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        return h.get(en0.j());
    }

    @Nullable
    public final oi o(@NotNull fn0 fn0) {
        k21.i(fn0, "kotlinFqName");
        if (k(fn0, a)) {
            return e;
        }
        if (k(fn0, c)) {
            return e;
        }
        if (k(fn0, b)) {
            return g;
        }
        if (k(fn0, d)) {
            return g;
        }
        return i.get(fn0);
    }

    @Nullable
    public final en0 p(@Nullable fn0 fn0) {
        return j.get(fn0);
    }

    @Nullable
    public final en0 q(@Nullable fn0 fn0) {
        return k.get(fn0);
    }
}
