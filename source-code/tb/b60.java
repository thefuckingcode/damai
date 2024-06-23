package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class b60 {
    @JvmField
    @NotNull
    public static final b60 ALL;
    @JvmField
    @NotNull
    public static final b60 CALLABLES;
    @JvmField
    @NotNull
    public static final b60 CLASSIFIERS;
    @NotNull
    public static final a Companion;
    @JvmField
    @NotNull
    public static final b60 FUNCTIONS;
    @JvmField
    @NotNull
    public static final b60 NON_SINGLETON_CLASSIFIERS;
    @JvmField
    @NotNull
    public static final b60 PACKAGES;
    @JvmField
    @NotNull
    public static final b60 SINGLETON_CLASSIFIERS;
    @JvmField
    @NotNull
    public static final b60 TYPE_ALIASES;
    @JvmField
    @NotNull
    public static final b60 VALUES;
    @JvmField
    @NotNull
    public static final b60 VARIABLES;
    private static int c = 1;
    private static final int d;
    private static final int e;
    private static final int f;
    private static final int g;
    private static final int h;
    private static final int i;
    private static final int j;
    private static final int k;
    private static final int l;
    private static final int m;
    @NotNull
    private static final List<a.C0297a> n;
    @NotNull
    private static final List<a.C0297a> o;
    @NotNull
    private final List<a60> a;
    private final int b;

    /* compiled from: Taobao */
    public static final class a {

        /* renamed from: tb.b60$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        private static final class C0297a {
            private final int a;
            @NotNull
            private final String b;

            public C0297a(int i, @NotNull String str) {
                k21.i(str, "name");
                this.a = i;
                this.b = str;
            }

            public final int a() {
                return this.a;
            }

            @NotNull
            public final String b() {
                return this.b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final int l() {
            int i = b60.c;
            b60.c <<= 1;
            return i;
        }

        public final int b() {
            return b60.j;
        }

        public final int c() {
            return b60.m;
        }

        public final int d() {
            return b60.k;
        }

        public final int e() {
            return b60.h;
        }

        public final int f() {
            return b60.d;
        }

        public final int g() {
            return b60.g;
        }

        public final int h() {
            return b60.e;
        }

        public final int i() {
            return b60.f;
        }

        public final int j() {
            return b60.l;
        }

        public final int k() {
            return b60.i;
        }
    }

    static {
        a.C0297a aVar;
        a.C0297a aVar2;
        a aVar3 = new a(null);
        Companion = aVar3;
        d = aVar3.l();
        e = aVar3.l();
        f = aVar3.l();
        g = aVar3.l();
        h = aVar3.l();
        i = aVar3.l();
        j = aVar3.l() - 1;
        k = aVar3.f() | aVar3.h() | aVar3.i();
        l = aVar3.h() | aVar3.e() | aVar3.k();
        m = aVar3.e() | aVar3.k();
        ALL = new b60(aVar3.b(), null, 2, null);
        CALLABLES = new b60(aVar3.c(), null, 2, null);
        NON_SINGLETON_CLASSIFIERS = new b60(aVar3.f(), null, 2, null);
        SINGLETON_CLASSIFIERS = new b60(aVar3.h(), null, 2, null);
        TYPE_ALIASES = new b60(aVar3.i(), null, 2, null);
        CLASSIFIERS = new b60(aVar3.d(), null, 2, null);
        PACKAGES = new b60(aVar3.g(), null, 2, null);
        FUNCTIONS = new b60(aVar3.e(), null, 2, null);
        VARIABLES = new b60(aVar3.k(), null, 2, null);
        VALUES = new b60(aVar3.j(), null, 2, null);
        Field[] fields = b60.class.getFields();
        k21.h(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            b60 b60 = obj instanceof b60 ? (b60) obj : null;
            if (b60 != null) {
                int o2 = b60.o();
                String name = field2.getName();
                k21.h(name, "field.name");
                aVar2 = new a.C0297a(o2, name);
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                arrayList2.add(aVar2);
            }
        }
        n = arrayList2;
        Field[] fields2 = b60.class.getFields();
        k21.h(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (k21.d(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field4.getName();
                k21.h(name2, "field.name");
                aVar = new a.C0297a(intValue, name2);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                arrayList5.add(aVar);
            }
        }
        o = arrayList5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends tb.a60> */
    /* JADX WARN: Multi-variable type inference failed */
    public b60(int i2, @NotNull List<? extends a60> list) {
        k21.i(list, "excludes");
        this.a = list;
        for (a60 a60 : list) {
            i2 &= ~a60.a();
        }
        this.b = i2;
    }

    public final boolean a(int i2) {
        return (i2 & this.b) != 0;
    }

    @NotNull
    public final List<a60> n() {
        return this.a;
    }

    public final int o() {
        return this.b;
    }

    @Nullable
    public final b60 p(int i2) {
        int i3 = i2 & this.b;
        if (i3 == 0) {
            return null;
        }
        return new b60(i3, this.a);
    }

    @NotNull
    public String toString() {
        T t;
        boolean z;
        Iterator<T> it = n.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.a() == o()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t2 = t;
        String b2 = t2 == null ? null : t2.b();
        if (b2 == null) {
            List<a.C0297a> list = o;
            ArrayList arrayList = new ArrayList();
            for (T t3 : list) {
                String b3 = a(t3.a()) ? t3.b() : null;
                if (b3 != null) {
                    arrayList.add(b3);
                }
            }
            b2 = CollectionsKt___CollectionsKt.Z(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + b2 + AVFSCacheConstants.COMMA_SEP + this.a + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b60(int i2, List list, int i3, m40 m40) {
        this(i2, (i3 & 2) != 0 ? m.g() : list);
    }
}
