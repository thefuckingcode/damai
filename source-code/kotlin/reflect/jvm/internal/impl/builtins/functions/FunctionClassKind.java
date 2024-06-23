package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.k21;
import tb.m40;
import tb.og1;

/* JADX WARN: Init of enum KFunction can be incorrect */
/* JADX WARN: Init of enum KSuspendFunction can be incorrect */
/* compiled from: Taobao */
public enum FunctionClassKind {
    Function(c.BUILT_INS_PACKAGE_FQ_NAME, "Function"),
    SuspendFunction(c.COROUTINES_PACKAGE_FQ_NAME_RELEASE, "SuspendFunction"),
    KFunction(r4, "KFunction"),
    KSuspendFunction(r4, "KSuspendFunction");
    
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final String classNamePrefix;
    @NotNull
    private final en0 packageFqName;

    /* compiled from: Taobao */
    public static final class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0267a {
            @NotNull
            private final FunctionClassKind a;
            private final int b;

            public C0267a(@NotNull FunctionClassKind functionClassKind, int i) {
                k21.i(functionClassKind, "kind");
                this.a = functionClassKind;
                this.b = i;
            }

            @NotNull
            public final FunctionClassKind a() {
                return this.a;
            }

            public final int b() {
                return this.b;
            }

            @NotNull
            public final FunctionClassKind c() {
                return this.a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0267a)) {
                    return false;
                }
                C0267a aVar = (C0267a) obj;
                return this.a == aVar.a && this.b == aVar.b;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b;
            }

            @NotNull
            public String toString() {
                return "KindWithArity(kind=" + this.a + ", arity=" + this.b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        private final Integer d(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                i++;
                int i3 = charAt - '0';
                if (!(i3 >= 0 && i3 <= 9)) {
                    return null;
                }
                i2 = (i2 * 10) + i3;
            }
            return Integer.valueOf(i2);
        }

        @Nullable
        public final FunctionClassKind a(@NotNull en0 en0, @NotNull String str) {
            k21.i(en0, "packageFqName");
            k21.i(str, PushClientConstants.TAG_CLASS_NAME);
            FunctionClassKind[] values = FunctionClassKind.values();
            for (FunctionClassKind functionClassKind : values) {
                if (k21.d(functionClassKind.getPackageFqName(), en0) && (o.L(str, functionClassKind.getClassNamePrefix(), false, 2, null))) {
                    return functionClassKind;
                }
            }
            return null;
        }

        @JvmStatic
        @Nullable
        public final FunctionClassKind b(@NotNull String str, @NotNull en0 en0) {
            k21.i(str, PushClientConstants.TAG_CLASS_NAME);
            k21.i(en0, "packageFqName");
            C0267a c = c(str, en0);
            if (c == null) {
                return null;
            }
            return c.c();
        }

        @Nullable
        public final C0267a c(@NotNull String str, @NotNull en0 en0) {
            k21.i(str, PushClientConstants.TAG_CLASS_NAME);
            k21.i(en0, "packageFqName");
            FunctionClassKind a = a(en0, str);
            if (a == null) {
                return null;
            }
            String substring = str.substring(a.getClassNamePrefix().length());
            k21.h(substring, "(this as java.lang.String).substring(startIndex)");
            Integer d = d(substring);
            if (d == null) {
                return null;
            }
            return new C0267a(a, d.intValue());
        }
    }

    static {
        en0 en0 = c.KOTLIN_REFLECT_FQ_NAME;
    }

    private FunctionClassKind(en0 en0, String str) {
        this.packageFqName = en0;
        this.classNamePrefix = str;
    }

    @NotNull
    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    @NotNull
    public final en0 getPackageFqName() {
        return this.packageFqName;
    }

    @NotNull
    public final og1 numberedClassName(int i) {
        og1 f = og1.f(k21.r(this.classNamePrefix, Integer.valueOf(i)));
        k21.h(f, "identifier(\"$classNamePrefix$arity\")");
        return f;
    }
}
